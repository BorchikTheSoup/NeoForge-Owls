package net.borchik.borchiksowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.custom.ElfOwlEntity;
import net.borchik.borchiksowls.entity.custom.OwlEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ElfOwlModel<T extends ElfOwlEntity> extends HierarchicalModel<T> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(OwlsMod.MOD_ID, "elf_owl"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart fluff;
    private final ModelPart left_foot;
    private final ModelPart right_foot;
    private final ModelPart right_wing;
    private final ModelPart left_wing;

    public ElfOwlModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.fluff = this.body.getChild("fluff");
        this.left_foot = this.body.getChild("left_foot");
        this.right_foot = this.body.getChild("right_foot");
        this.right_wing = this.body.getChild("right_wing");
        this.left_wing = this.body.getChild("left_wing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-0.25F, 23.15F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(13, 19).addBox(0.75F, -6.75F, -1.01F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(13, 19).addBox(-0.75F, -6.75F, -1.01F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -7.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition fluff = body.addOrReplaceChild("fluff", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r4 = fluff.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0001F, -5.0F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 14).addBox(-1.0F, -5.0F, -1.01F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(2.0011F, -5.0F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition left_foot = body.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(6, 17).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.75F, 0.25F));

        PartDefinition right_foot = body.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(4, 17).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.75F, 0.25F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.25F, 0.65F));

        PartDefinition cube_r5 = right_wing.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 0).addBox(1.0F, -5.0F, -1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, -0.65F, 0.0854F, -0.0436F, 0.0437F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(2.0F, 0.25F, 0.85F));

        PartDefinition cube_r6 = left_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 7).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, -0.85F, 0.0854F, 0.0436F, -0.0437F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(ElfOwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(ElfOwlAnimations.ELF_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.walkingAnimationState, ElfOwlAnimations.ELF_WALK, ageInTicks, 1f);

        this.animateWalk(ElfOwlAnimations.FLIGHT, limbSwing, limbSwingAmount, 2f, 2f);
        this.animate(entity.flyingAnimationState, ElfOwlAnimations.FLIGHT, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -135f, 135);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

}
