package net.fryc.frycmod.mixin;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.entity.mobs.ModMobs;
import net.fryc.frycmod.tag.ModBiomeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ZombieEntity.class)
abstract class ZombieConvertMixin extends HostileEntity {
    boolean canConvert = true;
    Random random = new Random();

    protected ZombieConvertMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    //converts zombie to forgotten or explorer
    //only first mob tick (right after spawning) tries to convert it
    //baby zombies won't convert
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void convertToZombieVariant(CallbackInfo info) {
        if(!world.isClient){
            if(canConvert){
                ZombieEntity zombie = ((ZombieEntity)(Object)this);
                if(zombie.getName().contains(Text.of("Zombie")) && !zombie.isBaby()){ //baby variants have the same hitboxes as adult variants (I don't know how to fix it)
                    int i = (int)zombie.getY();
                    if(zombie.getWorld().getBiome(zombie.getBlockPos()).isIn(ModBiomeTags.EXPLORER_SPAWN_BIOMES) && i > 38){
                        if(random.nextInt(0, 100) <= FrycMod.config.zombieToExplorerConvertChance) zombie.convertTo(ModMobs.EXPLORER, true); // ~80% chance to convert in jungle, swamp or lush cave (default)
                    }
                    else {
                        if(i < FrycMod.config.zombieToForgottenConvertLevelY){
                            if(random.nextInt(i, 100 + i) < FrycMod.config.zombieToForgottenConvertLevelY){ // ~26% to convert on 0Y level (default)
                                zombie.convertTo(ModMobs.FORGOTTEN, true);
                            }
                        }
                    }
                    canConvert = false;
                }
            }
        }
    }
}
