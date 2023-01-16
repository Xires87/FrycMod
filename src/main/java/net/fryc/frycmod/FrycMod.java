package net.fryc.frycmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fryc.frycmod.blocks.ModBlocks;
import net.fryc.frycmod.config.FrycmodConfig;
import net.fryc.frycmod.crafting.CraftingRules;
import net.fryc.frycmod.effects.ModEffects;
import net.fryc.frycmod.enchantments.ModEnchantments;
import net.fryc.frycmod.entity.mobs.ModMobs;
import net.fryc.frycmod.entity.mobs.eggs.ModSpawnEggs;
import net.fryc.frycmod.items.ModItems;
import net.fryc.frycmod.loot.ModLootTables;
import net.fryc.frycmod.painting.ModPaintings;
import net.fryc.frycmod.potions.ModPotions;
import net.fryc.frycmod.screen.ModScreenHandlers;
import net.fryc.frycmod.villagers.ModTradeOffers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrycMod implements ModInitializer {
	public static final String MOD_ID = "frycmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static FrycmodConfig config;


	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(FrycmodConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(FrycmodConfig.class).getConfig();

		//crafting rules
		CraftingRules.createCraftingRules();

		//trade offers
		ModTradeOffers.registerTradeOffers();

		//other
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();

		ModPotions.registerPotions();
		ModLootTables.modifyLoot();

		ModEffects.registerEffects();

		ModEnchantments.registerModEnchantments();

		ModPaintings.registerPaintings();

		ModMobs.registerModMobs();
		ModSpawnEggs.registerSpawnEggs();
	}
}
