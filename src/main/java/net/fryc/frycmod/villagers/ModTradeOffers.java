package net.fryc.frycmod.villagers;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.items.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.map.MapIcon;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModTradeOffers extends TradeOffers{

    public static Int2ObjectMap<Factory[]> copyToFastUtilMap(ImmutableMap<Integer, Factory[]> map) {
        return new Int2ObjectOpenHashMap(map);
    }

    public static void registerTradeOffers(){
        if(FrycMod.config.modifyTradeOffersForArmorer) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.ARMORER, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.ARMORER), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.ARMORER));
        if(FrycMod.config.modifyTradeOffersForToolsmith) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.TOOLSMITH, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.TOOLSMITH), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.TOOLSMITH));
        if(FrycMod.config.modifyTradeOffersForWeaponsmith) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.WEAPONSMITH, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.WEAPONSMITH), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.WEAPONSMITH));
        if(FrycMod.config.modifyTradeOffersForLibrarian) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.LIBRARIAN, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN));
        ModTradeOffers.registerFabricTradeOffers();
    }

    public static void registerFabricTradeOffers(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.BANDAGE, 1),
                            8, 2, 0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(ModItems.HONEY_BANDAGE, 1),
                            8, 10, 0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.HERBAL_BALM, 1),
                            8, 10, 0.02f
                    )));
                });
    }

    //Trade offers from my mod
    public static final Map<VillagerProfession, Int2ObjectMap<Factory[]>> MOD_PROFESSION_TO_LEVELED_TRADE = (Map) Util.make(Maps.newHashMap(), (map) -> {
        map.put(VillagerProfession.TOOLSMITH, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 1),new BuyForOneEmeraldFactory(Items.COPPER_INGOT, 11, 8, 2), new SellItemFactory(Items.STONE_PICKAXE, 1 , 1 , 2)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.IRON_INGOT, 6, 8, 8), new SellEnchantedToolFactory(ModItems.COPPER_PICKAXE, 1 , 3 , 15 , 0.2f), new SellEnchantedToolFactory(ModItems.COPPER_SHOVEL, 1 , 3 , 15 , 0.2f)}, 3, new Factory[]{new SellEnchantedToolFactory(Items.IRON_SHOVEL, 2, 3, 30, 0.2f), new SellEnchantedToolFactory(Items.IRON_PICKAXE, 3, 3, 30, 0.2f)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.GOLD_INGOT, 5, 5, 15) , new BuyForOneEmeraldFactory(ModItems.GOLDEN_PICKAXE, 1, 1, 120)}, 5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_PICKAXE, 7, 3, 30, 0.2f) , new SellEnchantedToolFactory(ModItems.GOLDEN_SHOVEL, 3, 3, 30, 0.2f)})));
        map.put(VillagerProfession.ARMORER, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new SellItemFactory(new ItemStack(ModItems.COPPER_LEGGINGS), 5, 1, 12, 3, 0.2f), new SellItemFactory(new ItemStack(ModItems.COPPER_BOOTS), 3, 1, 12, 2, 0.2f), new SellItemFactory(new ItemStack(ModItems.COPPER_HELMET), 4, 1, 12, 2, 0.2f), new SellItemFactory(new ItemStack(ModItems.COPPER_CHESTPLATE), 6, 1, 12, 4, 0.2f)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.IRON_INGOT, 6, 8, 10), new SellItemFactory(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 10, 1, 12, 15, 0.2f)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.GOLD_INGOT, 5, 5, 20), new SellItemFactory(new ItemStack(Items.CHAINMAIL_LEGGINGS), 8, 1, 12, 15, 0.2f)}, 4, new Factory[]{new SellEnchantedToolFactory(Items.IRON_CHESTPLATE, 13, 3, 25, 0.2f), new SellEnchantedToolFactory(Items.IRON_BOOTS, 8, 3, 20, 0.2f), new SellEnchantedToolFactory(Items.IRON_LEGGINGS, 10, 3, 20, 0.2f) , new SellEnchantedToolFactory(Items.IRON_HELMET, 9, 3, 20, 0.2f)}, 5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_HELMET, 13, 3, 30, 0.2f), new SellEnchantedToolFactory(ModItems.GOLDEN_CHESTPLATE, 17, 3, 30, 0.2f)})));
        map.put(VillagerProfession.LIBRARIAN, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2), new SellItemFactory(Blocks.BOOKSHELF, 9, 1, 12, 1), new SellItemFactory(ModItems.MAGIC_SCROLL_ARMOR, 5, 1, 3, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.BOOK, 4, 12, 10), new SellItemFactory(Items.LANTERN, 1, 1, 5), new SellItemFactory(ModItems.MAGIC_SCROLL_WEAPON, 5, 1, 3, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.INK_SAC, 5, 12, 20), new SellItemFactory(Items.GLASS, 1, 4, 10), new SellItemFactory(ModItems.MAGIC_SCROLL_TOOL, 6, 1, 3, 10)}, 4, new Factory[]{new ModEnchantBookFactory(15), new ModEnchantBookFactory(15)}, 5, new Factory[]{new SellItemFactory(Items.NAME_TAG, 20, 1, 30), new EnchantBookFactory(30)})));
        map.put(VillagerProfession.WEAPONSMITH, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new BuyForOneEmeraldFactory(Items.FLINT, 24, 12, 10)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.IRON_INGOT, 6, 8, 10) ,new SellItemFactory(new ItemStack(ModItems.COPPER_SWORD), 2, 1, 12, 2, 0.2f)}, 3, new Factory[]{new SellEnchantedToolFactory(Items.IRON_AXE, 3, 3, 12, 0.2f), new SellEnchantedToolFactory(ModItems.IRON_HAMMER, 4, 3, 15, 0.2f), new SellEnchantedToolFactory(Items.IRON_SWORD, 3, 3, 12, 0.2f)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.GOLD_INGOT, 4, 8, 20), new SellItemFactory(Items.SHIELD, 2, 1, 3)}, 5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_SWORD, 9, 3, 30, 0.2f), new SellEnchantedToolFactory(ModItems.GOLDEN_HAMMER, 10, 3, 30, 0.2f), new SellEnchantedToolFactory(ModItems.GOLDEN_AXE, 9, 3, 30, 0.2f)})));
        map.put(VillagerProfession.FARMER, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.WHEAT, 20, 16, 2), new BuyForOneEmeraldFactory(Items.POTATO, 26, 16, 2), new BuyForOneEmeraldFactory(Items.CARROT, 22, 16, 2), new BuyForOneEmeraldFactory(Items.BEETROOT, 15, 16, 2), new SellItemFactory(Items.BREAD, 1, 6, 16, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Blocks.PUMPKIN, 6, 12, 10), new SellItemFactory(Items.PUMPKIN_PIE, 1, 4, 5), new SellItemFactory(Items.APPLE, 1, 4, 16, 5)}, 3, new Factory[]{new SellItemFactory(ModItems.HERBAL_BALM, 1, 1, 10),new SellItemFactory(Items.COOKIE, 3, 18, 10), new BuyForOneEmeraldFactory(Blocks.MELON, 4, 12, 20)}, 4, new Factory[]{new SellItemFactory(Blocks.CAKE, 1, 1, 12, 15), new SellSuspiciousStewFactory(StatusEffects.NIGHT_VISION, 100, 15), new SellSuspiciousStewFactory(StatusEffects.JUMP_BOOST, 160, 15), new SellSuspiciousStewFactory(StatusEffects.WEAKNESS, 140, 15), new SellSuspiciousStewFactory(StatusEffects.BLINDNESS, 120, 15), new SellSuspiciousStewFactory(StatusEffects.POISON, 280, 15), new SellSuspiciousStewFactory(StatusEffects.SATURATION, 7, 15)}, 5, new Factory[]{new SellItemFactory(Items.GOLDEN_CARROT, 3, 3, 30), new SellItemFactory(Items.GLISTERING_MELON_SLICE, 4, 3, 30)})));
        map.put(VillagerProfession.FISHERMAN, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.STRING, 20, 16, 2), new BuyForOneEmeraldFactory(Items.COAL, 10, 16, 2), new ProcessItemFactory(Items.COD, 6, Items.COOKED_COD, 6, 16, 1), new SellItemFactory(Items.COD_BUCKET, 3, 1, 16, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.COD, 15, 16, 10), new ProcessItemFactory(Items.SALMON, 6, Items.COOKED_SALMON, 6, 16, 5), new SellItemFactory(Items.CAMPFIRE, 2, 1, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.SALMON, 13, 16, 20), new SellEnchantedToolFactory(Items.FISHING_ROD, 3, 3, 10, 0.2F)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.TROPICAL_FISH, 6, 12, 30)}, 5, new Factory[]{new BuyForOneEmeraldFactory(Items.PUFFERFISH, 4, 12, 30)})));
        map.put(VillagerProfession.SHEPHERD, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Blocks.WHITE_WOOL, 18, 16, 2), new BuyForOneEmeraldFactory(Blocks.BROWN_WOOL, 18, 16, 2), new BuyForOneEmeraldFactory(Blocks.BLACK_WOOL, 18, 16, 2), new BuyForOneEmeraldFactory(Blocks.GRAY_WOOL, 18, 16, 2), new SellItemFactory(Items.SHEARS, 2, 1, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.WHITE_DYE, 12, 16, 10), new BuyForOneEmeraldFactory(Items.GRAY_DYE, 12, 16, 10), new BuyForOneEmeraldFactory(Items.BLACK_DYE, 12, 16, 10), new BuyForOneEmeraldFactory(Items.LIGHT_BLUE_DYE, 12, 16, 10), new BuyForOneEmeraldFactory(Items.LIME_DYE, 12, 16, 10), new SellItemFactory(Blocks.WHITE_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.ORANGE_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.MAGENTA_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.LIGHT_BLUE_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.YELLOW_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.LIME_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.PINK_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.GRAY_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.LIGHT_GRAY_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.CYAN_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.PURPLE_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.BLUE_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.BROWN_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.GREEN_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.RED_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.BLACK_WOOL, 1, 1, 16, 5), new SellItemFactory(Blocks.WHITE_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.ORANGE_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.MAGENTA_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.LIGHT_BLUE_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.YELLOW_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.LIME_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.PINK_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.GRAY_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.LIGHT_GRAY_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.CYAN_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.PURPLE_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.BLUE_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.BROWN_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.GREEN_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.RED_CARPET, 1, 4, 16, 5), new SellItemFactory(Blocks.BLACK_CARPET, 1, 4, 16, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.YELLOW_DYE, 12, 16, 20), new BuyForOneEmeraldFactory(Items.LIGHT_GRAY_DYE, 12, 16, 20), new BuyForOneEmeraldFactory(Items.ORANGE_DYE, 12, 16, 20), new BuyForOneEmeraldFactory(Items.RED_DYE, 12, 16, 20), new BuyForOneEmeraldFactory(Items.PINK_DYE, 12, 16, 20), new SellItemFactory(Blocks.WHITE_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.YELLOW_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.RED_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.BLACK_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.BLUE_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.BROWN_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.CYAN_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.GRAY_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.GREEN_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.LIGHT_BLUE_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.LIGHT_GRAY_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.LIME_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.MAGENTA_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.ORANGE_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.PINK_BED, 3, 1, 12, 10), new SellItemFactory(Blocks.PURPLE_BED, 3, 1, 12, 10)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.BROWN_DYE, 12, 16, 30), new BuyForOneEmeraldFactory(Items.PURPLE_DYE, 12, 16, 30), new BuyForOneEmeraldFactory(Items.BLUE_DYE, 12, 16, 30), new BuyForOneEmeraldFactory(Items.GREEN_DYE, 12, 16, 30), new BuyForOneEmeraldFactory(Items.MAGENTA_DYE, 12, 16, 30), new BuyForOneEmeraldFactory(Items.CYAN_DYE, 12, 16, 30), new SellItemFactory(Items.WHITE_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.BLUE_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.RED_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.PINK_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.GREEN_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.LIME_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.GRAY_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.BLACK_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.PURPLE_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.CYAN_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.BROWN_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.YELLOW_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.ORANGE_BANNER, 3, 1, 12, 15), new SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 12, 15)}, 5, new Factory[]{new SellItemFactory(Items.PAINTING, 2, 3, 30)})));
        map.put(VillagerProfession.FLETCHER, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.STICK, 32, 16, 2), new SellItemFactory(Items.ARROW, 1, 16, 1), new ProcessItemFactory(Blocks.GRAVEL, 10, Items.FLINT, 10, 12, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10), new SellItemFactory(Items.BOW, 2, 1, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.STRING, 14, 16, 20), new SellItemFactory(Items.CROSSBOW, 3, 1, 10)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.FEATHER, 24, 16, 30), new SellEnchantedToolFactory(Items.BOW, 2, 3, 15)}, 5, new Factory[]{new BuyForOneEmeraldFactory(Items.TRIPWIRE_HOOK, 8, 12, 30), new SellEnchantedToolFactory(Items.CROSSBOW, 3, 3, 15), new SellPotionHoldingItemFactory(Items.ARROW, 5, Items.TIPPED_ARROW, 5, 2, 12, 30)})));
        map.put(VillagerProfession.CARTOGRAPHER, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2), new SellItemFactory(Items.MAP, 7, 1, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.GLASS_PANE, 11, 16, 10), new SellMapFactory(13, StructureTags.ON_OCEAN_EXPLORER_MAPS, "filled_map.monument", MapIcon.Type.MONUMENT, 12, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.COMPASS, 1, 12, 20), new SellMapFactory(14, StructureTags.ON_WOODLAND_EXPLORER_MAPS, "filled_map.mansion", MapIcon.Type.MANSION, 12, 10)}, 4, new Factory[]{new SellItemFactory(Items.ITEM_FRAME, 7, 1, 15), new SellItemFactory(Items.WHITE_BANNER, 3, 1, 15), new SellItemFactory(Items.BLUE_BANNER, 3, 1, 15), new SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 15), new SellItemFactory(Items.RED_BANNER, 3, 1, 15), new SellItemFactory(Items.PINK_BANNER, 3, 1, 15), new SellItemFactory(Items.GREEN_BANNER, 3, 1, 15), new SellItemFactory(Items.LIME_BANNER, 3, 1, 15), new SellItemFactory(Items.GRAY_BANNER, 3, 1, 15), new SellItemFactory(Items.BLACK_BANNER, 3, 1, 15), new SellItemFactory(Items.PURPLE_BANNER, 3, 1, 15), new SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 15), new SellItemFactory(Items.CYAN_BANNER, 3, 1, 15), new SellItemFactory(Items.BROWN_BANNER, 3, 1, 15), new SellItemFactory(Items.YELLOW_BANNER, 3, 1, 15), new SellItemFactory(Items.ORANGE_BANNER, 3, 1, 15), new SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 15)}, 5, new Factory[]{new SellItemFactory(Items.GLOBE_BANNER_PATTERN, 8, 1, 30)})));
        map.put(VillagerProfession.CLERIC, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.ROTTEN_FLESH, 32, 16, 2), new SellItemFactory(Items.REDSTONE, 1, 2, 1), new SellItemFactory(ModItems.BANDAGE, 2, 1, 2, 2)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.GOLD_INGOT, 3, 12, 10), new SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 5)}, 3, new Factory[]{new SellItemFactory(ModItems.HONEY_BANDAGE, 4, 1, 10),new BuyForOneEmeraldFactory(Items.RABBIT_FOOT, 2, 12, 20), new SellItemFactory(Blocks.GLOWSTONE, 4, 1, 12, 10)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30), new BuyForOneEmeraldFactory(Items.GLASS_BOTTLE, 9, 12, 30), new SellItemFactory(Items.ENDER_PEARL, 5, 1, 15)}, 5, new Factory[]{new BuyForOneEmeraldFactory(Items.NETHER_WART, 22, 12, 30), new SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 30)})));
        map.put(VillagerProfession.BUTCHER, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.CHICKEN, 14, 16, 2), new BuyForOneEmeraldFactory(Items.PORKCHOP, 7, 16, 2), new BuyForOneEmeraldFactory(Items.RABBIT, 4, 16, 2), new SellItemFactory(Items.RABBIT_STEW, 1, 1, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new SellItemFactory(Items.COOKED_PORKCHOP, 1, 5, 16, 5), new SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 16, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.MUTTON, 7, 16, 20), new BuyForOneEmeraldFactory(Items.BEEF, 10, 16, 20)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 10, 12, 30)}, 5, new Factory[]{new BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 10, 12, 30)})));
        map.put(VillagerProfession.LEATHERWORKER, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.LEATHER, 6, 16, 2), new SellDyedArmorFactory(Items.LEATHER_LEGGINGS, 3), new SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10), new SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 5), new SellDyedArmorFactory(Items.LEATHER_BOOTS, 4, 12, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Items.RABBIT_HIDE, 9, 12, 20), new SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30), new SellDyedArmorFactory(Items.LEATHER_HORSE_ARMOR, 6, 12, 15)}, 5, new Factory[]{new SellItemFactory(new ItemStack(Items.SADDLE), 6, 1, 12, 30, 0.2F), new SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 30)})));
        map.put(VillagerProfession.MASON, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyForOneEmeraldFactory(Items.CLAY_BALL, 10, 16, 2), new SellItemFactory(Items.BRICK, 1, 10, 16, 1)}, 2, new Factory[]{new BuyForOneEmeraldFactory(Blocks.STONE, 20, 16, 10), new SellItemFactory(Blocks.CHISELED_STONE_BRICKS, 1, 4, 16, 5)}, 3, new Factory[]{new BuyForOneEmeraldFactory(Blocks.GRANITE, 16, 16, 20), new BuyForOneEmeraldFactory(Blocks.ANDESITE, 16, 16, 20), new BuyForOneEmeraldFactory(Blocks.DIORITE, 16, 16, 20), new SellItemFactory(Blocks.DRIPSTONE_BLOCK, 1, 4, 16, 10), new SellItemFactory(Blocks.POLISHED_ANDESITE, 1, 4, 16, 10), new SellItemFactory(Blocks.POLISHED_DIORITE, 1, 4, 16, 10), new SellItemFactory(Blocks.POLISHED_GRANITE, 1, 4, 16, 10)}, 4, new Factory[]{new BuyForOneEmeraldFactory(Items.QUARTZ, 12, 12, 30), new SellItemFactory(Blocks.ORANGE_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.WHITE_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.BLUE_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.LIGHT_BLUE_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.GRAY_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.LIGHT_GRAY_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.BLACK_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.RED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.PINK_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.MAGENTA_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.LIME_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.GREEN_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.CYAN_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.PURPLE_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.YELLOW_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.BROWN_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.ORANGE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.WHITE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.BLACK_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.RED_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.PINK_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.LIME_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.GREEN_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.CYAN_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.PURPLE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.YELLOW_GLAZED_TERRACOTTA, 1, 1, 12, 15), new SellItemFactory(Blocks.BROWN_GLAZED_TERRACOTTA, 1, 1, 12, 15)}, 5, new Factory[]{new SellItemFactory(Blocks.QUARTZ_PILLAR, 1, 1, 12, 30), new SellItemFactory(Blocks.QUARTZ_BLOCK, 1, 1, 12, 30)})));
    });





    //Returns weaker enchants than EnchantBookFactory
    public static class ModEnchantBookFactory
            implements Factory {
        private final int experience;

        public ModEnchantBookFactory(int experience) {
            this.experience = experience;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            List list = Registries.ENCHANTMENT.stream().filter(Enchantment::isAvailableForEnchantedBookOffer).collect(Collectors.toList());
            Enchantment enchantment = (Enchantment)list.get(random.nextInt(list.size()));
            //int i = MathHelper.nextInt(random, enchantment.getMinLevel(), enchantment.getMaxLevel()); <--- original
            int i = enchantment.getMaxLevel();
            if(i>2) i-=2;
            else if(i>1) i-=1;
            ItemStack itemStack = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment, i));
            int j = 2 + random.nextInt(5 + i * 10) + 3 * i;
            if (enchantment.isTreasure()) {
                if(enchantment.getMaxLevel() == 1) j*= 3;
                else j *= 2;
            }
            if (j > 64) {
                j = 64;
            }
            return new TradeOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemStack, 12, this.experience, 0.2f);
        }

    }

}
