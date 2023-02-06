package net.fryc.frycmod.entity.mobs.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fryc.frycmod.entity.mobs.renderer.biome.*;
import net.fryc.frycmod.entity.mobs.renderer.nether.*;
import net.fryc.frycmod.entity.mobs.renderer.cave.*;
import net.fryc.frycmod.entity.mobs.ModMobs;

public class ModMobsRenderers {

    public static void registerMobRenderers(){
        //cave variants
        EntityRendererRegistry.register(ModMobs.FORGOTTEN, (context) -> {
            return new ForgottenEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.UNDEAD_WARRIOR, (context) -> {
            return new UndeadWarriorEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.ARMORED_SPIDER, (context) -> {
            return new ArmoredSpiderEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.CAVE_CREEPER, (context) -> {
            return new CaveCreeperEntityRenderer(context);
        });

        //biome variants
        EntityRendererRegistry.register(ModMobs.EXPLORER, (context) -> {
            return new ExplorerEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.FROZEN_ZOMBIE, (context) -> {
            return new FrozenZombieEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.TROPICAL_SPIDER, (context) -> {
            return new TropicalSpiderEntityRenderer(context);
        });


        //nether variants
        EntityRendererRegistry.register(ModMobs.EXECUTIONER, (context) -> {
            return new ExecutionerEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.NIGHTMARE, (context) -> {
            return new NightmareEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.INFECTED_PIGLIN, (context) -> {
            return new InfectedPiglinEntityRenderer(context);
        });

        EntityRendererRegistry.register(ModMobs.INFECTED_PIGLIN_BRUTE, (context) -> {
            return new InfectedPiglinBruteEntityRenderer(context);
        });
    }
}
