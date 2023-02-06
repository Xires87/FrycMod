package net.fryc.frycmod.entity.mobs.renderer.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ExplorerEntityRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/zombie/explorer.png");

    public ExplorerEntityRenderer(EntityRendererFactory.Context context) {
        super(context,EntityModelLayers.ZOMBIE, EntityModelLayers.ZOMBIE_INNER_ARMOR, EntityModelLayers.ZOMBIE_OUTER_ARMOR);
    }



    public Identifier getTexture(ZombieEntity zombieEntity) {
        return TEXTURE;
    }
}
