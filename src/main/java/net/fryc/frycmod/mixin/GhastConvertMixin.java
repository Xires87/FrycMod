package net.fryc.frycmod.mixin;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.entity.mobs.ModMobs;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(GhastEntity.class)
abstract class GhastConvertMixin extends FlyingEntity implements Monster {
    boolean canConvert = true;
    Random random = new Random();

    protected GhastConvertMixin(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
    }

    //converts ghasts to nightmare
    public void tick() {
        super.tick();
        if (!world.isClient) {
            GhastEntity ghast = ((GhastEntity) (Object) this);
            if(ghast.hasStatusEffect(StatusEffects.NAUSEA)) canConvert = false;
            if (canConvert) {
                if (ghast.getClass() == GhastEntity.class) {
                    if (random.nextInt(0, 100) <= FrycMod.config.ghastConvertChance) {
                        ghast.convertTo(ModMobs.NIGHTMARE, false);
                    }
                    canConvert = false;
                }
            }
        }
    }
}
