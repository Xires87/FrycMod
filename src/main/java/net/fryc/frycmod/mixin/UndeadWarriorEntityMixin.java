package net.fryc.frycmod.mixin;

import net.fryc.frycmod.FrycMod;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "net.fryc.frycmobvariants.mobs.cave.UndeadWarriorEntity")
public class UndeadWarriorEntityMixin {

    @Inject(method = "getUndeadWarriorSword()Lnet/minecraft/item/ItemStack;", at = @At("HEAD"), cancellable = true)
    private static void getIronSword(CallbackInfoReturnable<ItemStack> ret) {
        ret.setReturnValue(FrycMod.undeadWarriorSword());
    }
}
