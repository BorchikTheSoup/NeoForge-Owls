package net.borchik.borchiksowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.custom.ElfOwlEntity;
import net.borchik.borchiksowls.entity.custom.OwlEntity;
import net.borchik.borchiksowls.entity.custom.OwlVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.EnumMap;
import java.util.Map;

public class ElfOwlRenderer extends MobRenderer<ElfOwlEntity, ElfOwlModel<ElfOwlEntity>> {

    public ElfOwlRenderer(EntityRendererProvider.Context context) {
        super(context, new ElfOwlModel<>(context.bakeLayer(ElfOwlModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(ElfOwlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(OwlsMod.MOD_ID, "textures/entity/elf_owl/elf_owl.png");
    }

    @Override
    public void render(ElfOwlEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else
        {
            poseStack.scale(1.2f, 1.2f, 1.2f);
        }
    }


}