package net.fryc.frycmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fryc.frycmod.entity.mobs.renderer.ModMobsRenderers;
import net.fryc.frycmod.items.custom.BalmItem;
import net.fryc.frycmod.screen.ModScreenHandlers;
import net.fryc.frycmod.screen.ModSmithingScreen;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class FrycModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, ModSmithingScreen::new);
        ModMobsRenderers.registerMobRenderers();
        ModelPredicateProviderRegistry.register(new Identifier("balm"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem().getItem() instanceof BalmItem ? 1.0F : 0.0F;
        });
    }
}
