package net.fryc.frycmod.mixin;

import net.fryc.frycmod.effects.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    //players and mobs cant get poison, wither or health loss while having immunity effect
    @Inject(method = "canHaveStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z", at = @At("RETURN"), cancellable = true)
    public void hasImmunity(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> ret) {
        LivingEntity entity = ((LivingEntity) (Object) this);
        if(entity.hasStatusEffect(ModEffects.IMMUNITY)){
            StatusEffect statusEffect = effect.getEffectType();
            if(statusEffect == StatusEffects.POISON || statusEffect == StatusEffects.WITHER || statusEffect == ModEffects.HEALTH_LOSS){
                ret.setReturnValue(false);
            }
        }
    }
}
