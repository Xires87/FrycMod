package net.fryc.frycmod.entity.mobs.renderer.nether;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PiglinEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class InfectedPiglinEntityRenderer extends PiglinEntityRenderer {

    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/piglin/infected_piglin.png");

    public InfectedPiglinEntityRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.PIGLIN, EntityModelLayers.PIGLIN_INNER_ARMOR, EntityModelLayers.PIGLIN_OUTER_ARMOR, false);
    }

    public Identifier getTexture(MobEntity mobEntity) {
        return TEXTURE;
    }

}
