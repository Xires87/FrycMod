package net.fryc.frycmod.potions;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.items.ModItems;
import net.fryc.frycmod.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion WITHER_POTION;
    public static Potion LONG_WITHER_POTION;
    public static Potion STRONG_WITHER_POTION;

    public static Potion HEALTH_BOOST_POTION;
    public static Potion LONG_HEALTH_BOOST_POTION;
    public static Potion STRONG_HEALTH_BOOST_POTION;

    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, new Identifier(FrycMod.MOD_ID, name),
                potion);
    }

    public static void registerPotions() {
        WITHER_POTION = registerPotion("wither_potion", new Potion(new StatusEffectInstance(StatusEffects.WITHER, 600, 0)));
        LONG_WITHER_POTION = registerPotion("long_wither_potion", new Potion(new StatusEffectInstance(StatusEffects.WITHER, 1200, 0)));
        STRONG_WITHER_POTION = registerPotion("strong_wither_potion", new Potion(new StatusEffectInstance(StatusEffects.WITHER, 260, 1)));

        HEALTH_BOOST_POTION = registerPotion("hp_boost_potion", new Potion(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 3600, 0)));
        LONG_HEALTH_BOOST_POTION = registerPotion("long_hp_boost_potion", new Potion(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 9600, 0)));
        STRONG_HEALTH_BOOST_POTION = registerPotion("strong_hp_boost_potion", new Potion(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1800, 1)));

        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.CLOVER,
                Potions.LUCK);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.WITHER_BONE,
                ModPotions.WITHER_POTION);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.WITHER_POTION, Items.REDSTONE,
                ModPotions.LONG_WITHER_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.STRONG_WITHER_POTION, Items.REDSTONE,
                ModPotions.LONG_WITHER_POTION);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.WITHER_POTION, Items.GLOWSTONE_DUST,
                ModPotions.STRONG_WITHER_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.LONG_WITHER_POTION, Items.GLOWSTONE_DUST,
                ModPotions.STRONG_WITHER_POTION);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.RED_CRYSTALS,
                ModPotions.HEALTH_BOOST_POTION);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HEALTH_BOOST_POTION, Items.REDSTONE,
                ModPotions.LONG_HEALTH_BOOST_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.STRONG_HEALTH_BOOST_POTION, Items.REDSTONE,
                ModPotions.LONG_HEALTH_BOOST_POTION);

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.HEALTH_BOOST_POTION, Items.GLOWSTONE_DUST,
                ModPotions.STRONG_HEALTH_BOOST_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.LONG_HEALTH_BOOST_POTION, Items.GLOWSTONE_DUST,
                ModPotions.STRONG_HEALTH_BOOST_POTION);
    }
}
