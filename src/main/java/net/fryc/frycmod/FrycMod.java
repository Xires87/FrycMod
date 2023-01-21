package net.fryc.frycmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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

		//creative
		ItemGroup FRYCMOD = FabricItemGroup.builder(new Identifier(MOD_ID, "frycmod_item_group"))
				.displayName(Text.literal("Frycmod"))
				.icon(() -> new ItemStack(ModBlocks.COPPER_TABLE))
				.entries((enabledFeatures, entries, operatorEnabled) -> {
					//tables
					entries.add(ModBlocks.COPPER_TABLE);
					entries.add(ModBlocks.IRON_TABLE);
					entries.add(ModBlocks.GOLD_TABLE);
					entries.add(ModBlocks.DIAMOND_TABLE);

					//hammers
					entries.add(ModItems.COPPER_HAMMER);
					entries.add(ModItems.NUGGET_COPPER_HAMMER);
					entries.add(ModItems.INGOT_COPPER_HAMMER);

					entries.add(ModItems.IRON_HAMMER);
					entries.add(ModItems.NUGGET_IRON_HAMMER);
					entries.add(ModItems.INGOT_IRON_HAMMER);

					entries.add(ModItems.GOLDEN_HAMMER);
					entries.add(ModItems.DIAMOND_GOLDEN_HAMMER);

					entries.add(ModItems.DIAMOND_HAMMER);
					entries.add(ModItems.NETHERITE_HAMMER);

					//copper
					entries.add(ModItems.COPPER_PICKAXE);
					entries.add(ModItems.COPPER_AXE);
					entries.add(ModItems.COPPER_SHOVEL);
					entries.add(ModItems.COPPER_HOE);
					entries.add(ModItems.COPPER_SWORD);
					entries.add(ModItems.COPPER_HELMET);
					entries.add(ModItems.COPPER_CHESTPLATE);
					entries.add(ModItems.COPPER_LEGGINGS);
					entries.add(ModItems.COPPER_BOOTS);

					//nugget copper
					entries.add(ModItems.NUGGET_COPPER_PICKAXE);
					entries.add(ModItems.NUGGET_COPPER_AXE);
					entries.add(ModItems.NUGGET_COPPER_SHOVEL);
					entries.add(ModItems.NUGGET_COPPER_HOE);
					entries.add(ModItems.NUGGET_COPPER_SWORD);
					entries.add(ModItems.NUGGET_COPPER_HELMET);
					entries.add(ModItems.NUGGET_COPPER_CHESTPLATE);
					entries.add(ModItems.NUGGET_COPPER_LEGGINGS);
					entries.add(ModItems.NUGGET_COPPER_BOOTS);

					//ingot copper
					entries.add(ModItems.INGOT_COPPER_PICKAXE);
					entries.add(ModItems.INGOT_COPPER_AXE);
					entries.add(ModItems.INGOT_COPPER_SHOVEL);
					entries.add(ModItems.INGOT_COPPER_HOE);
					entries.add(ModItems.INGOT_COPPER_SWORD);
					entries.add(ModItems.INGOT_COPPER_HELMET);
					entries.add(ModItems.INGOT_COPPER_CHESTPLATE);
					entries.add(ModItems.INGOT_COPPER_LEGGINGS);
					entries.add(ModItems.INGOT_COPPER_BOOTS);

					//nugget iron
					entries.add(ModItems.NUGGET_IRON_PICKAXE);
					entries.add(ModItems.NUGGET_IRON_AXE);
					entries.add(ModItems.NUGGET_IRON_SHOVEL);
					entries.add(ModItems.NUGGET_IRON_HOE);
					entries.add(ModItems.NUGGET_IRON_SWORD);
					entries.add(ModItems.NUGGET_IRON_HELMET);
					entries.add(ModItems.NUGGET_IRON_CHESTPLATE);
					entries.add(ModItems.NUGGET_IRON_LEGGINGS);
					entries.add(ModItems.NUGGET_IRON_BOOTS);

					//ingot iron
					entries.add(ModItems.INGOT_IRON_PICKAXE);
					entries.add(ModItems.INGOT_IRON_AXE);
					entries.add(ModItems.INGOT_IRON_SHOVEL);
					entries.add(ModItems.INGOT_IRON_HOE);
					entries.add(ModItems.INGOT_IRON_SWORD);
					entries.add(ModItems.INGOT_IRON_HELMET);
					entries.add(ModItems.INGOT_IRON_CHESTPLATE);
					entries.add(ModItems.INGOT_IRON_LEGGINGS);
					entries.add(ModItems.INGOT_IRON_BOOTS);

					//gold
					entries.add(ModItems.GOLDEN_PICKAXE);
					entries.add(ModItems.GOLDEN_AXE);
					entries.add(ModItems.GOLDEN_SHOVEL);
					entries.add(ModItems.GOLDEN_HOE);
					entries.add(ModItems.GOLDEN_SWORD);
					entries.add(ModItems.GOLDEN_HELMET);
					entries.add(ModItems.GOLDEN_CHESTPLATE);
					entries.add(ModItems.GOLDEN_LEGGINGS);
					entries.add(ModItems.GOLDEN_BOOTS);

					//diamond gold
					entries.add(ModItems.DIAMOND_GOLDEN_PICKAXE);
					entries.add(ModItems.DIAMOND_GOLDEN_AXE);
					entries.add(ModItems.DIAMOND_GOLDEN_SHOVEL);
					entries.add(ModItems.DIAMOND_GOLDEN_HOE);
					entries.add(ModItems.DIAMOND_GOLDEN_SWORD);
					entries.add(ModItems.DIAMOND_GOLDEN_HELMET);
					entries.add(ModItems.DIAMOND_GOLDEN_CHESTPLATE);
					entries.add(ModItems.DIAMOND_GOLDEN_LEGGINGS);
					entries.add(ModItems.DIAMOND_GOLDEN_BOOTS);

					//bone armors
					entries.add(ModItems.BONE_HELMET);
					entries.add(ModItems.BONE_CHESTPLATE);
					entries.add(ModItems.BONE_LEGGINGS);
					entries.add(ModItems.BONE_BOOTS);

					entries.add(ModItems.WITHER_HELMET);
					entries.add(ModItems.WITHER_CHESTPLATE);
					entries.add(ModItems.WITHER_LEGGINGS);
					entries.add(ModItems.WITHER_BOOTS);

					entries.add(ModItems.WARDEN_HELMET);
					entries.add(ModItems.WARDEN_CHESTPLATE);
					entries.add(ModItems.WARDEN_LEGGINGS);
					entries.add(ModItems.WARDEN_BOOTS);

					entries.add(ModItems.ECHO_WARDEN_HELMET);
					entries.add(ModItems.ECHO_WARDEN_CHESTPLATE);
					entries.add(ModItems.ECHO_WARDEN_LEGGINGS);
					entries.add(ModItems.ECHO_WARDEN_BOOTS);

					//scrolls
					entries.add(ModItems.MAGIC_SCROLL_ARMOR);
					entries.add(ModItems.MAGIC_SCROLL_TOOL);
					entries.add(ModItems.MAGIC_SCROLL_WEAPON);

					//bandages
					entries.add(ModItems.BANDAGE);
					entries.add(ModItems.HONEY_BANDAGE);
					entries.add(ModItems.STICKY_BANDAGE);
					entries.add(ModItems.HERBAL_BALM);

					//other
					entries.add(ModItems.WITHER_BONE);
					entries.add(ModItems.RED_CRYSTALS);
					entries.add(ModItems.CLOVER);
					entries.add(ModItems.ANCIENT_REMAINS);
					entries.add(ModItems.ECHO_ANCIENT_REMAINS);
					entries.add(ModBlocks.ANCIENT_FOSSIL);

					//spawn eggs
					entries.add(ModSpawnEggs.ARMORED_SPIDER_SPAWN_EGG);
					entries.add(ModSpawnEggs.CAVE_CREEPER_SPAWN_EGG);
					entries.add(ModSpawnEggs.FORGOTTEN_SPAWN_EGG);
					entries.add(ModSpawnEggs.UNDEAD_WARRIOR_SPAWN_EGG);
					entries.add(ModSpawnEggs.EXPLORER_SPAWN_EGG);
					entries.add(ModSpawnEggs.TROPICAL_SPIDER_SPAWN_EGG);
					entries.add(ModSpawnEggs.EXECUTIONER_SPAWN_EGG);
					entries.add(ModSpawnEggs.NIGHTMARE_SPAWN_EGG);

				})
				.build();
	}
}
