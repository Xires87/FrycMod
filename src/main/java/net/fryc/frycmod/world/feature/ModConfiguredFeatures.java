package net.fryc.frycmod.world.feature;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.blocks.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> ANCIENT_FOSSIL = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ANCIENT_FOSSIL.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ANCIENT_FOSSIL_ORE =
            ConfiguredFeatures.register("ancient_fossil", Feature.ORE, new OreFeatureConfig(ANCIENT_FOSSIL, 3));

    public static void registerConfiguredFeatures() {
        FrycMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + FrycMod.MOD_ID);
    }
}
