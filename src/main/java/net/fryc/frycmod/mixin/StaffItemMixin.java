package net.fryc.frycmod.mixin;

import net.fryc.frycmod.FrycMod;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(targets = "net.fryc.recallstaffs.items.custom.StaffItem")
abstract class StaffItemMixin {

    Random random = Random.create();

    @Redirect(method = "finishUsing(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;)Lnet/minecraft/item/ItemStack;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;teleport(Lnet/minecraft/server/world/ServerWorld;DDDFF)V"))
    private void injected(ServerPlayerEntity player, ServerWorld server, double x, double y, double z, float yaw, float pitch) {
        if(FrycMod.recallStaffsScrollsAndCursesCompatibility(player)){
            server = ((ServerWorld) player.getWorld());
            x += random.nextBetween(-1500, 1500);
            y += 10;
            z += random.nextBetween(-1500, 1500);
            BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);
            while(mutable.getY() > server.getBottomY() && !server.getBlockState(mutable).blocksMovement()) {
                mutable.move(Direction.DOWN);
            }

            do{
                mutable.move(Direction.UP);
            }while(!server.getBlockState(mutable).isAir() && !server.getBlockState(mutable).isLiquid());
            y = mutable.getY();
        }
        player.teleport(server, x, y, z, yaw, pitch);

    }
}
