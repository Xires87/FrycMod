package net.fryc.frycmod.entity.mobs.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fryc.frycmod.entity.mobs.ModMobs;

public class ModMobsRenderers {

    public static void registerMobRenderers(){
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
    }
}
