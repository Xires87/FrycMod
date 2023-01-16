package net.fryc.frycmod.painting;

import net.fryc.frycmod.FrycMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {

    public static final PaintingVariant FRYC = registerPaintings("fryc", new PaintingVariant(64 , 64));

    private static PaintingVariant registerPaintings(String name, PaintingVariant PaintingVariant){
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(FrycMod.MOD_ID, name), PaintingVariant);
    }

    public static void registerPaintings() {
        FrycMod.LOGGER.info("Registering Paintings for " + FrycMod.MOD_ID);
    }
}
