package net.fryc.frycmod.effects;

import net.fryc.frycmod.entity.damage.BleedDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BleedEffect extends StatusEffect {
        public BleedEffect(StatusEffectCategory statusEffectCategory, int color) {
            super(statusEffectCategory, color);
        }

        @Override
        public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
            if (!pLivingEntity.world.isClient()) {

                if(pLivingEntity.getHealth() > 0.5F){
                    pLivingEntity.damage(BleedDamageSource.bleed(), 0.5F);
                }
                else if(!pLivingEntity.getActiveStatusEffects().containsKey(ModEffects.BLEEDOUT)){
                    pLivingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDOUT, 600, 0));
                }
                else{
                    pLivingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDOUT, pLivingEntity.getActiveStatusEffects().get(ModEffects.BLEEDOUT).getDuration() + 1200, 0));
                }

            }

            super.applyUpdateEffect(pLivingEntity, pAmplifier);
        }

        @Override
        public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
            int i;
            if (this == ModEffects.BLEED_EFFECT) {
                i = 120 >> pAmplifier;
                if (i > 0) {
                    return pDuration % i == 0;
                } else {
                    return true;
                }
            }
            else return true;
        }
}
