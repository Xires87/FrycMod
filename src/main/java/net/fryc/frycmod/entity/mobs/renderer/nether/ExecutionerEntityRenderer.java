package net.fryc.frycmod.entity.mobs.renderer.nether;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.frycmod.FrycMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.WitherSkeletonEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ExecutionerEntityRenderer extends WitherSkeletonEntityRenderer {
    private static final Identifier TEXTURE =
            new Identifier(FrycMod.MOD_ID, "textures/entity/skeleton/executioner.png");

    public ExecutionerEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }

    protected void scale(AbstractSkeletonEntity abstractSkeletonEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(1.3F, 1.3F, 1.3F);
    }
}
