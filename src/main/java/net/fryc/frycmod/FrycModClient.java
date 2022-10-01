package net.fryc.frycmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fryc.frycmod.entity.mobs.renderer.ModMobsRenderers;
import net.fryc.frycmod.screen.ModScreenHandlers;
import net.fryc.frycmod.screen.ModSmithingScreen;

public class FrycModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, ModSmithingScreen::new);
        ModMobsRenderers.registerMobRenderers();
    }
}
