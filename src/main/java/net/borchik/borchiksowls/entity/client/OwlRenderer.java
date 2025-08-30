package net.borchik.borchiksowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.custom.OwlEntity;
import net.borchik.borchiksowls.entity.custom.OwlVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.EnumMap;
import java.util.Map;

public class OwlRenderer extends MobRenderer<OwlEntity, OwlModel<OwlEntity>> {

    private static final Map<OwlVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(new EnumMap<>(OwlVariant.class), map -> {
                map.put(OwlVariant.BROWN,
                        ResourceLocation.fromNamespaceAndPath(OwlsMod.MOD_ID, "textures/entity/owl/brown_owl.png"));
                map.put(OwlVariant.SNOWY,
                        ResourceLocation.fromNamespaceAndPath(OwlsMod.MOD_ID, "textures/entity/owl/snowy_owl.png"));
            });

    public OwlRenderer(EntityRendererProvider.Context context) {
        super(context, new OwlModel<>(context.bakeLayer(OwlModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(OwlEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(OwlEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else
        {
            poseStack.scale(1.2f, 1.2f, 1.2f);
        }
    }


}
