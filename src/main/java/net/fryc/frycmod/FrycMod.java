package net.fryc.frycmod;

import net.fabricmc.api.ModInitializer;
import net.fryc.frycmod.blocks.ModBlocks;
import net.fryc.frycmod.effects.ModEffects;
import net.fryc.frycmod.enchantments.ModEnchantments;
import net.fryc.frycmod.entity.mobs.ModMobs;
import net.fryc.frycmod.entity.mobs.eggs.ModSpawnEggs;
import net.fryc.frycmod.gamerules.ModGameRules;
import net.fryc.frycmod.items.ModItems;
import net.fryc.frycmod.loot.ModLootTables;
import net.fryc.frycmod.painting.ModPaintings;
import net.fryc.frycmod.potions.ModPotions;
import net.fryc.frycmod.screen.ModScreenHandlers;
import net.fryc.frycmod.world.feature.ModConfiguredFeatures;
import net.fryc.frycmod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrycMod implements ModInitializer {
	public static final String MOD_ID = "frycmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOre();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();

		ModPotions.registerPotions();
		ModLootTables.modifyLoot();

		ModEffects.registerEffects();

		ModEnchantments.registerModEnchantments();

		ModPaintings.registerPaintings();

		ModGameRules.registerGameRules();

		ModMobs.registerModMobs();
		ModSpawnEggs.registerSpawnEggs();
	}
}
