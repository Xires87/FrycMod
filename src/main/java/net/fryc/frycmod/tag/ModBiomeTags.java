package net.fryc.frycmod.tag;

import net.fryc.frycmod.FrycMod;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {
    public static final TagKey<Biome> EXPLORER_SPAWN_BIOMES = ModBiomeTags.register("explorer_spawn_biomes");


    private ModBiomeTags(){
    }
    private static TagKey<Biome> register(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(FrycMod.MOD_ID, id));
    }
}
