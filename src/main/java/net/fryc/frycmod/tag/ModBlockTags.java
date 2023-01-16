package net.fryc.frycmod.tag;

import net.fryc.frycmod.FrycMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> TABLES = ModBlockTags.register("tables");
    public static final TagKey<Block> IRON_TABLES = ModBlockTags.register("iron_tables");
    public static final TagKey<Block> GOLDEN_TABLES = ModBlockTags.register("golden_tables");
    public static final TagKey<Block> DIAMOND_TABLES = ModBlockTags.register("diamond_tables");
    public static final TagKey<Block> FURNACES_FOR_INGOTS = ModBlockTags.register("furnaces_for_ingots");

    private ModBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(FrycMod.MOD_ID, id));
    }
}
