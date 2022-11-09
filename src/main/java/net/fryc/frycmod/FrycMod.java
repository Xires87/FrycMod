package net.fryc.frycmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fryc.craftingmanipulator.rules.RecipeBlockingRules;
import net.fryc.craftingmanipulator.rules.StandNearBlockRBR;
import net.fryc.frycmod.blocks.ModBlocks;
import net.fryc.frycmod.config.FrycmodConfig;
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
import net.fryc.frycmod.tag.ModBlockTags;
import net.fryc.frycmod.tag.ModItemTags;
import net.fryc.frycmod.villagers.ModTradeOffers;
import net.fryc.frycmod.world.feature.ModConfiguredFeatures;
import net.fryc.frycmod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrycMod implements ModInitializer {
	public static final String MOD_ID = "frycmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static FrycmodConfig config;
	String[] tooltips;
	@Override
	public void onInitialize() {
		//ore
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOre();


		//config
		AutoConfig.register(FrycmodConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(FrycmodConfig.class).getConfig();
		if(config.isTooltipsEnabled){
			tooltips = new String[]{"Workshop: Copper Smithing Table", "Workshop: Iron Smithing Table", "Workshop: Golden Smithing Table", "Workshop: Diamond Smithing Table"};
		}
		else{
			tooltips = new String[]{"", "", "", ""};
		}

		if(config.isCopperRecipeBlocked){
			StandNearBlockRBR COPPER = new StandNearBlockRBR(tooltips[0], ModItemTags.NEEDS_COPPER_TABLE, ModBlockTags.TABLES);
		}
		if(config.isIronRecipeBlocked){
			StandNearBlockRBR IRON = new StandNearBlockRBR(tooltips[1], ModItemTags.NEEDS_IRON_TABLE, ModBlockTags.IRON_TABLES);
		}
		if(config.isGoldRecipeBlocked){
			StandNearBlockRBR GOLDEN = new StandNearBlockRBR(tooltips[2], ModItemTags.NEEDS_GOLDEN_TABLE, ModBlockTags.GOLDEN_TABLES);
		}
		if(config.isDiamondRecipeBlocked){
			StandNearBlockRBR DIAMOND = new StandNearBlockRBR(tooltips[3], ModItemTags.NEEDS_DIAMOND_TABLE, ModBlockTags.DIAMOND_TABLES);
		}
		RecipeBlockingRules VANILLA_GOLDEN_ITEMS = new RecipeBlockingRules("Recipe disabled by: Frycmod", ModItemTags.VANILLA_GOLDEN_TOOLS);


		if(config.isTradeOffersModified){
			ModTradeOffers.registerTradeOffers();
		}
		else {
			ModTradeOffers.registerFabricTradeOffers();
		}

		//other
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
