package net.fryc.frycmod.mixin;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.effects.ModEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    int toughness;
    //Causes player to bleed after taking damage AND gives wither to enemies if you wear wither armor
    @Inject(method = "applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V", at = @At("TAIL"))
    public void applyBleed(DamageSource source, float amount, CallbackInfo ci) {
        PlayerEntity player = ((PlayerEntity) (Object) this);
        if(player.getHealth() < 6 && FrycMod.config.enableDarknessAtLowHp){
            if(player.hasStatusEffect(StatusEffects.DARKNESS)){
                if(player.getActiveStatusEffects().get(StatusEffects.DARKNESS).getDuration() < 36) player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 35 , 0));
            }
            else player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 35 , 0));
        }
        toughness = (int) (player.getAttributes().getValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS) * 1.4);
        if(toughness < 1) toughness = 1;
        if(source.getSource() instanceof ArrowEntity){
            int multiplier = (int) (amount * ((20 - player.getArmor())- toughness));
            if(multiplier > 2){
                if(!player.hasStatusEffect(ModEffects.BLEED_EFFECT) || !FrycMod.config.enableArrowEffectUpgrading) player.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED_EFFECT, multiplier*FrycMod.config.arrowBleedLength, 0), source.getAttacker());
                else player.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED_EFFECT, multiplier*(FrycMod.config.arrowBleedLength + 5), 1), source.getAttacker());
            }

        }
        else if(!source.isProjectile() && source.getAttacker() instanceof SpiderEntity spiderEntity){
            if(!player.hasStatusEffect(ModEffects.IMMUNITY)){
                int multiplier = 17 - player.getArmor();
                if(multiplier > 1){
                    if(!player.hasStatusEffect(ModEffects.HEALTH_LOSS) || !FrycMod.config.enableMeleeEffectUpgrading) player.addStatusEffect(new StatusEffectInstance(ModEffects.HEALTH_LOSS, multiplier*FrycMod.config.healthLossLength, 0), spiderEntity);
                    else player.addStatusEffect(new StatusEffectInstance(ModEffects.HEALTH_LOSS, multiplier*(FrycMod.config.healthLossLength + 80), 1), spiderEntity);
                }
            }
            else {
                //gives wither to enemy if player has wither armor (or permanent immunity)
                if(player.getActiveStatusEffects().get(ModEffects.IMMUNITY).getDuration() > 10000) spiderEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 180, 0));
            }
        }
        else if(!source.isProjectile() && !source.isExplosive() && source.getAttacker() instanceof LivingEntity livingEntity){
            if(player.hasStatusEffect(ModEffects.IMMUNITY)){
                //gives wither to enemy if player has wither armor (or permanent immunity)
                if(player.getActiveStatusEffects().get(ModEffects.IMMUNITY).getDuration() > 10000) livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 180, 0));
            }
            int multiplier = (int) (amount * ((21 - player.getArmor())- toughness));
            if(multiplier > 2){
                if(!player.hasStatusEffect(ModEffects.BLEED_EFFECT) || !FrycMod.config.enableMeleeEffectUpgrading) player.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED_EFFECT, multiplier*FrycMod.config.meleeBleedLength, 0), livingEntity);
                else player.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED_EFFECT, multiplier*(FrycMod.config.meleeBleedLength + 8), 1), livingEntity);
            }
        }

        if(source.isFire() && FrycMod.config.fireDamageLowersBleedingDuration){
            if(player.hasStatusEffect(ModEffects.BLEED_EFFECT)){
                int amp = player.getActiveStatusEffects().get(ModEffects.BLEED_EFFECT).getAmplifier();
                int dur = player.getActiveStatusEffects().get(ModEffects.BLEED_EFFECT).getDuration();
                if(amp == 0) dur -= 280;
                else dur -= 120;
                player.removeStatusEffect(player.getActiveStatusEffects().get(ModEffects.BLEED_EFFECT).getEffectType());
                if(dur > 0){
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED_EFFECT, dur, amp));
                }
            }
        }

    }

    //Stops food healing while bleeding
    @Inject(method = "canFoodHeal()Z", at = @At("RETURN"), cancellable = true)
    public void noHealing(CallbackInfoReturnable<Boolean> ret) {
        PlayerEntity player = ((PlayerEntity) (Object) this);
        ret.setReturnValue(player.getHealth() > 0.0F && player.getHealth() < player.getMaxHealth() && (!player.getActiveStatusEffects().containsKey(ModEffects.BLEED_EFFECT) || !FrycMod.config.bleedingStopsFoodHealing));
    }

    //Gives blindness if player has 1 hp or lower
    @Inject(method = "tick()V", at = @At("TAIL"))
    public void setBlindness(CallbackInfo info){
        PlayerEntity player = ((PlayerEntity) (Object) this);
        if(player.getHealth()<=1 && FrycMod.config.enableBlindnessAtLowHp){
            if(player.hasStatusEffect(StatusEffects.BLINDNESS)){
                if(player.getActiveStatusEffects().get(StatusEffects.BLINDNESS).getDuration() < 25) player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60 , 0));
            }
            else player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60 , 0));
        }
    }


}
