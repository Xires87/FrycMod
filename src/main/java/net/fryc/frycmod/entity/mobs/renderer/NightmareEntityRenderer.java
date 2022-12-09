package net.fryc.frycmod.entity.mobs.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.GhastEntityRenderer;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class NightmareEntityRenderer extends GhastEntityRenderer {
    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/ghast/nightmare.png");

    private static final Identifier ANGRY_TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/ghast/nightmare_angry.png");

    public NightmareEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


    public Identifier getTexture(GhastEntity ghastEntity) {
        return ghastEntity.isShooting() ? ANGRY_TEXTURE : TEXTURE;
    }

}
