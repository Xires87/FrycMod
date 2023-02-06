package net.fryc.frycmod.entity.mobs.renderer.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.entity.mobs.biome.TropicalSpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TropicalSpiderEntityRenderer extends SpiderEntityRenderer<TropicalSpiderEntity> {

    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/spider/tropical_spider.png");

    public TropicalSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.SPIDER);
    }

    public Identifier getTexture(TropicalSpiderEntity tropicalSpiderEntity) {
        return TEXTURE;
    }
}
