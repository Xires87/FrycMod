package net.fryc.frycmod.entity.mobs.renderer.cave;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CaveCreeperEntityRenderer extends CreeperEntityRenderer {

    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/creeper/cave_creeper.png");

    public CaveCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(CreeperEntity creeperEntity) {
        return TEXTURE;
    }
}
