package net.borchik.borchiksowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.custom.BrownOwlEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BrownOwlRenderer extends MobRenderer<BrownOwlEntity, BrownOwlModel<BrownOwlEntity>> {
    public BrownOwlRenderer(EntityRendererProvider.Context context) {
        super(context, new BrownOwlModel<>(context.bakeLayer(BrownOwlModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(BrownOwlEntity brownOwlEntity) {
        return ResourceLocation.fromNamespaceAndPath(OwlsMod.MOD_ID, "textures/entity/owl/brown_owl.png");
    }

    @Override
    public void render(BrownOwlEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else
        {
            poseStack.scale(1.2f, 1.2f, 1.2f);
        }
    }


}
