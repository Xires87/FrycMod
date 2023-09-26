package net.fryc.frycmod.spagyria;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ScrollsAndCursesPotions {

    public static Potion CHAOTIC_TELEPORTATION_POTION;
    public static Potion LONG_CHAOTIC_TELEPORTATION_POTION;
    public static Potion STRONG_CHAOTIC_TELEPORTATION_POTION;

    private static Potion registerPotion(String name, Potion potion) {
        return (Potion) Registry.register(Registries.POTION, new Identifier(net.fryc.threepotions.ThreePotions.MOD_ID, name),
                potion);
    }

    public static void registerScrollsAndCursesPotions() {
        if(net.fryc.frycscrolls.effects.ModEffects.CHAOTIC_TELEPORTATION != null){
            //FrycMod.LOGGER.warn("Registering potions!");
            CHAOTIC_TELEPORTATION_POTION = registerPotion("chaotic_teleportation_potion", new Potion(new StatusEffectInstance(net.fryc.frycscrolls.effects.ModEffects.CHAOTIC_TELEPORTATION, 1000, 0)));
            LONG_CHAOTIC_TELEPORTATION_POTION = registerPotion("long_chaotic_teleportation_potion", new Potion(new StatusEffectInstance(net.fryc.frycscrolls.effects.ModEffects.CHAOTIC_TELEPORTATION, 2000, 0)));
            STRONG_CHAOTIC_TELEPORTATION_POTION = registerPotion("strong_chaotic_teleportation_potion", new Potion(new StatusEffectInstance(net.fryc.frycscrolls.effects.ModEffects.CHAOTIC_TELEPORTATION, 400, 1)));


            registerPotionRecipes();
        }
        else{
            net.fryc.frycscrolls.effects.ModEffects.registerEffects();
            registerScrollsAndCursesPotions();
        }
    }

    private static void registerPotionRecipes() {


        //chaotic teleportation
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.ENDER_PEARL,
                CHAOTIC_TELEPORTATION_POTION);

        BrewingRecipeRegistry.registerPotionRecipe(CHAOTIC_TELEPORTATION_POTION, Items.REDSTONE,
                LONG_CHAOTIC_TELEPORTATION_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(STRONG_CHAOTIC_TELEPORTATION_POTION, Items.REDSTONE,
                LONG_CHAOTIC_TELEPORTATION_POTION);

        BrewingRecipeRegistry.registerPotionRecipe(CHAOTIC_TELEPORTATION_POTION, Items.GLOWSTONE_DUST,
                STRONG_CHAOTIC_TELEPORTATION_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(LONG_CHAOTIC_TELEPORTATION_POTION, Items.GLOWSTONE_DUST,
                STRONG_CHAOTIC_TELEPORTATION_POTION);




    }
}
