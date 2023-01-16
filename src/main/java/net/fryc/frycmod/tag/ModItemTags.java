package net.fryc.frycmod.tag;

import net.fryc.frycmod.FrycMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModItemTags {
    public static final TagKey<Item> HAMMERS = ModItemTags.register("hammers");
    public static final TagKey<Item> IRON_HAMMERS = ModItemTags.register("iron_hammers");
    public static final TagKey<Item> GOLDEN_HAMMERS = ModItemTags.register("golden_hammers");
    public static final TagKey<Item> DIAMOND_HAMMERS = ModItemTags.register("diamond_hammers");
    public static final TagKey<Item> COPPER_BLOCKS = ModItemTags.register("copper_blocks");
    public static final TagKey<Item> TABLES = ModItemTags.register("tables");
    public static final TagKey<Item> NETHERITE_INGOT = ModItemTags.register("netherite_ingot");
    public static final TagKey<Item> VANILLA_GOLDEN_TOOLS = ModItemTags.register("vanilla_golden_tools");
    public static final TagKey<Item> TABLES_INGREDIENTS = ModItemTags.register("tables_ingredients");

    public static final TagKey<Item> NEEDS_COPPER_TABLE = ModItemTags.register("needs_copper_table");
    public static final TagKey<Item> NEEDS_IRON_TABLE = ModItemTags.register("needs_iron_table");
    public static final TagKey<Item> NEEDS_GOLDEN_TABLE = ModItemTags.register("needs_golden_table");
    public static final TagKey<Item> NEEDS_DIAMOND_TABLE = ModItemTags.register("needs_diamond_table");
    public static final TagKey<Item> POWDER_SNOW_WALKABLE_BOOTS = ModItemTags.register("powder_snow_walkable_boots");
    public static final TagKey<Item> WITHER_ARMORS = ModItemTags.register("wither_armors");
    public static final TagKey<Item> SCROLLS = ModItemTags.register("scrolls");
    public static final TagKey<Item> TULIPS = ModItemTags.register("tulips");

    //for sounds
    public static final TagKey<Item> SOUND_TOOLS_AND_ARMOR = ModItemTags.register("sound_tools_and_armor");
    public static final TagKey<Item> SOUND_WOOD = ModItemTags.register("sound_wood");
    public static final TagKey<Item> SOUND_STONE = ModItemTags.register("sound_stone");
    public static final TagKey<Item> SOUND_DEEPSLATE = ModItemTags.register("sound_deepslate");
    public static final TagKey<Item> SOUND_INGOTS_FROM_FURNACE = ModItemTags.register("sound_ingots_from_furnace");
    public static final TagKey<Item> SOUND_BONE_ARMORS = ModItemTags.register("sound_bone_armors");
    public static final TagKey<Item> SOUND_CHAIN_ARMORS = ModItemTags.register("sound_chain_armors");



    private ModItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(FrycMod.MOD_ID, id));
    }
}
