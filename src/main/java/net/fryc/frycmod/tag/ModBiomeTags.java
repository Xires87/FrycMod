package net.fryc.frycmod.tag;

import net.fryc.frycmod.FrycMod;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {
    public static final TagKey<Biome> EXPLORER_SPAWN_BIOMES = ModBiomeTags.register("explorer_spawn_biomes");


    private ModBiomeTags(){
    }
    private static TagKey<Biome> register(String id) {
        return TagKey.of(Registry.BIOME_KEY, new Identifier(FrycMod.MOD_ID, id));
    }
}
