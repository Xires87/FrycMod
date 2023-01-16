package net.fryc.frycmod.effects;

import net.fryc.frycmod.FrycMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect BLEED_EFFECT;
    public static StatusEffect BLEEDOUT;
    public static StatusEffect HEALTH_LOSS;
    public static StatusEffect ENDER_CURSE;
    public static StatusEffect IMMUNITY;

    static StatusEffect bleedout = new BleedoutEffect(StatusEffectCategory.HARMFUL, 16262179).addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "7D6F0BA2-1186-46AC-B896-C61C5CEE99CC", -12.0, EntityAttributeModifier.Operation.ADDITION);
    static StatusEffect bleed = new BleedEffect(StatusEffectCategory.HARMFUL, 16262179);
    static StatusEffect healthloss = new HealthLossEffect(StatusEffectCategory.HARMFUL, 16262179).addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "8D6F0BA2-1186-46AC-B896-C61C5CEE99CC", -2.0, EntityAttributeModifier.Operation.ADDITION);
    static StatusEffect endercurse = new EnderCurseEffect(StatusEffectCategory.NEUTRAL, 13458603);
    static StatusEffect immunity = new ImmunityEffect(StatusEffectCategory.BENEFICIAL, 99999179);
    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FrycMod.MOD_ID, name),
                effect);
    }



    public static void registerEffects() {
        BLEED_EFFECT = registerStatusEffect("bleed", bleed);
        BLEEDOUT = registerStatusEffect("bleedout" , bleedout);
        HEALTH_LOSS = registerStatusEffect("health_loss", healthloss);
        ENDER_CURSE = registerStatusEffect("ender_curse", endercurse);
        IMMUNITY = registerStatusEffect("immunity", immunity);
    }
}
