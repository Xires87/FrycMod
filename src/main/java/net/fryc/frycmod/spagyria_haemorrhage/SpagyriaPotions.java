package net.fryc.frycmod.spagyria_haemorrhage;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SpagyriaPotions {

    public static Potion BLEEDING_POTION;
    public static Potion LONG_BLEEDING_POTION;
    public static Potion STRONG_BLEEDING_POTION;

    public static Potion HEALTH_LOSS_POTION;
    public static Potion LONG_HEALTH_LOSS_POTION;
    public static Potion STRONG_HEALTH_LOSS_POTION;

    private static Potion registerPotion(String name, Potion potion) {
        return (Potion)Registry.register(Registries.POTION, new Identifier(net.fryc.threepotions.ThreePotions.MOD_ID, name),
                potion);
    }

    public static void registerSpagyriaPotions() {
        if(net.fryc.imbleeding.effects.ModEffects.BLEED_EFFECT != null){
            //FrycMod.LOGGER.warn("Registering potions!");
            BLEEDING_POTION = registerPotion("bleeding_potion", new Potion(new StatusEffectInstance(net.fryc.imbleeding.effects.ModEffects.BLEED_EFFECT, 2400, 0)));
            LONG_BLEEDING_POTION = registerPotion("long_bleeding_potion", new Potion(new StatusEffectInstance(net.fryc.imbleeding.effects.ModEffects.BLEED_EFFECT, 4800, 0)));
            STRONG_BLEEDING_POTION = registerPotion("strong_bleeding_potion", new Potion(new StatusEffectInstance(net.fryc.imbleeding.effects.ModEffects.BLEED_EFFECT, 1000, 1)));

            HEALTH_LOSS_POTION = registerPotion("health_loss_potion", new Potion(new StatusEffectInstance(net.fryc.imbleeding.effects.ModEffects.HEALTH_LOSS, 4800, 0)));
            LONG_HEALTH_LOSS_POTION = registerPotion("long_health_loss_potion", new Potion(new StatusEffectInstance(net.fryc.imbleeding.effects.ModEffects.HEALTH_LOSS, 9600, 0)));
            STRONG_HEALTH_LOSS_POTION = registerPotion("strong_health_loss_potion", new Potion(new StatusEffectInstance(net.fryc.imbleeding.effects.ModEffects.HEALTH_LOSS, 2400, 1)));



            registerPotionRecipes();
        }
        else{
            net.fryc.imbleeding.effects.ModEffects.registerEffects();
            registerSpagyriaPotions();
        }
    }

    private static void registerPotionRecipes() {

        //health loss
        BrewingRecipeRegistry.registerPotionRecipe(net.fryc.threepotions.potions.ModPotions.HEALTH_BOOST_POTION, Items.FERMENTED_SPIDER_EYE,
                SpagyriaPotions.HEALTH_LOSS_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(net.fryc.threepotions.potions.ModPotions.LONG_HEALTH_BOOST_POTION, Items.FERMENTED_SPIDER_EYE,
                SpagyriaPotions.HEALTH_LOSS_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(net.fryc.threepotions.potions.ModPotions.STRONG_HEALTH_BOOST_POTION, Items.FERMENTED_SPIDER_EYE,
                SpagyriaPotions.HEALTH_LOSS_POTION);

        BrewingRecipeRegistry.registerPotionRecipe(SpagyriaPotions.HEALTH_LOSS_POTION, Items.REDSTONE,
                SpagyriaPotions.LONG_HEALTH_LOSS_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(SpagyriaPotions.STRONG_HEALTH_LOSS_POTION, Items.REDSTONE,
                SpagyriaPotions.LONG_HEALTH_LOSS_POTION);

        BrewingRecipeRegistry.registerPotionRecipe(SpagyriaPotions.HEALTH_LOSS_POTION, Items.GLOWSTONE_DUST,
                SpagyriaPotions.STRONG_HEALTH_LOSS_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(LONG_HEALTH_LOSS_POTION, Items.GLOWSTONE_DUST,
                SpagyriaPotions.STRONG_HEALTH_LOSS_POTION);


        //bleeding
        BrewingRecipeRegistry.registerPotionRecipe(net.fryc.threepotions.potions.ModPotions.WITHER_POTION, Items.FERMENTED_SPIDER_EYE,
                SpagyriaPotions.BLEEDING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(net.fryc.threepotions.potions.ModPotions.LONG_WITHER_POTION, Items.FERMENTED_SPIDER_EYE,
                SpagyriaPotions.BLEEDING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(net.fryc.threepotions.potions.ModPotions.STRONG_WITHER_POTION, Items.FERMENTED_SPIDER_EYE,
                SpagyriaPotions.BLEEDING_POTION);

        BrewingRecipeRegistry.registerPotionRecipe(SpagyriaPotions.BLEEDING_POTION, Items.REDSTONE,
                SpagyriaPotions.LONG_BLEEDING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(SpagyriaPotions.STRONG_BLEEDING_POTION, Items.REDSTONE,
                SpagyriaPotions.LONG_BLEEDING_POTION);

        BrewingRecipeRegistry.registerPotionRecipe(SpagyriaPotions.BLEEDING_POTION, Items.GLOWSTONE_DUST,
                SpagyriaPotions.STRONG_BLEEDING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(LONG_BLEEDING_POTION, Items.GLOWSTONE_DUST,
                SpagyriaPotions.STRONG_BLEEDING_POTION);




    }
}
