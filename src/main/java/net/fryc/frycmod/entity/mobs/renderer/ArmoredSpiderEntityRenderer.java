package net.fryc.frycmod.entity.mobs.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.entity.mobs.ArmoredSpiderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArmoredSpiderEntityRenderer extends SpiderEntityRenderer<ArmoredSpiderEntity> {

    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/spider/armored_spider.png");

    public ArmoredSpiderEntityRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.SPIDER);
    }

    public Identifier getTexture(ArmoredSpiderEntity armoredSpiderEntity) {
        return TEXTURE;
    }
}
