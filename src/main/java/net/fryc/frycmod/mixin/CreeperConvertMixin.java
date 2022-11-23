package net.fryc.frycmod.mixin;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.entity.mobs.ModMobs;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CreeperEntity.class)
abstract class CreeperConvertMixin extends HostileEntity implements SkinOverlayOwner {

    boolean canConvert = true;
    Random random = new Random();

    protected CreeperConvertMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    //converts creeper to cave creeper
    //only first mob tick (right after spawning) tries to convert it
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void convertToForgotten(CallbackInfo info) {
        if(!world.isClient){
            CreeperEntity creeper = ((CreeperEntity)(Object)this);
            if(creeper.getName().contains(Text.of("Creeper"))){
                int i = (int)creeper.getY();
                if(canConvert && i < FrycMod.config.creeperToCaveCreeperConvertLevelY){
                    if(random.nextInt(i, 100 + i) < FrycMod.config.creeperToCaveCreeperConvertLevelY){ // ~26% to convert on 0Y level (default)
                        creeper.convertTo(ModMobs.CAVE_CREEPER, false);
                    }
                    canConvert = false;
                }
            }
        }
    }

}
