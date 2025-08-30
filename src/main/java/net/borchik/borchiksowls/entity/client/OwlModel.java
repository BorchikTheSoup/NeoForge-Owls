package net.borchik.borchiksowls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.custom.OwlEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class OwlModel<T extends OwlEntity> extends HierarchicalModel<T> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(OwlsMod.MOD_ID, "brown_owl"), "main");
    private final ModelPart Body;
    private final ModelPart main;
    private final ModelPart tail;
    private final ModelPart fluff;
    private final ModelPart head;
    private final ModelPart beak;
    private final ModelPart right_brow;
    private final ModelPart left_brow;
    private final ModelPart right_foot;
    private final ModelPart left_foot;
    private final ModelPart wing_right;
    private final ModelPart wing_left;

    public OwlModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.main = this.Body.getChild("main");
        this.tail = this.main.getChild("tail");
        this.fluff = this.main.getChild("fluff");
        this.head = this.Body.getChild("head");
        this.beak = this.head.getChild("beak");
        this.right_brow = this.head.getChild("right_brow");
        this.left_brow = this.head.getChild("left_brow");
        this.right_foot = this.Body.getChild("right_foot");
        this.left_foot = this.Body.getChild("left_foot");
        this.wing_right = this.Body.getChild("wing_right");
        this.wing_left = this.Body.getChild("wing_left");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 1.5F, 0.1309F, 0.0F, 0.0F));

        PartDefinition main = Body.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 24).mirror().addBox(3.0F, -2.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(8, 24).addBox(-3.0F, -2.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 24).addBox(3.03F, -2.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 24).addBox(-3.03F, -2.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 21).addBox(-3.0F, -2.0F, 3.0F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r2 = main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 2).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition tail = main.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(6.0F, -0.5F, 0.0F));

        PartDefinition fluff = main.addOrReplaceChild("fluff", CubeListBuilder.create().texOffs(8, 21).addBox(-3.0F, -3.0F, -2.03F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(22, 1).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-3.0F, -3.0F, -2.03F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(3.01F, -3.0F, -2.03F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).mirror().addBox(-3.01F, -3.0F, -2.03F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.0F, -1.0F));

        PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -8.0F, -0.5F, -0.0873F, 0.0F, 0.0F));

        PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(22, 3).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -4.0F));

        PartDefinition right_brow = head.addOrReplaceChild("right_brow", CubeListBuilder.create(), PartPose.offset(-1.0F, -3.5F, -4.0F));

        PartDefinition browsmallerright_r1 = right_brow.addOrReplaceChild("browsmallerright_r1", CubeListBuilder.create().texOffs(20, 23).addBox(-4.0F, -1.0F, 1.99F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.45F, 0.9F, -0.25F, -0.3058F, 0.025F, 0.0003F));

        PartDefinition browbiggerright_r1 = right_brow.addOrReplaceChild("browbiggerright_r1", CubeListBuilder.create().texOffs(20, 22).addBox(-4.0F, -2.0F, 1.99F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.55F, 1.25F, 0.0F, -0.0449F, -0.0298F, 0.082F));

        PartDefinition left_brow = head.addOrReplaceChild("left_brow", CubeListBuilder.create(), PartPose.offset(0.0F, -3.5F, -4.0F));

        PartDefinition browbiggerleft_r1 = left_brow.addOrReplaceChild("browbiggerleft_r1", CubeListBuilder.create().texOffs(20, 22).mirror().addBox(2.0F, -2.0F, 1.99F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.55F, 1.25F, 0.0F, -0.0449F, 0.0298F, -0.082F));

        PartDefinition browsmallerleft_r1 = left_brow.addOrReplaceChild("browsmallerleft_r1", CubeListBuilder.create().texOffs(20, 23).mirror().addBox(2.0F, -1.0F, 1.99F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.45F, 0.9F, -0.25F, -0.3058F, -0.025F, -0.0003F));

        PartDefinition right_foot = Body.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(22, 8).addBox(-1.5F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 7).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -1.75F, -0.1309F, 0.0F, 0.0F));

        PartDefinition left_foot = Body.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(22, 8).mirror().addBox(0.5F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 7).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.0F, -1.75F, -0.1309F, 0.0F, 0.0F));

        PartDefinition wing_right = Body.addOrReplaceChild("wing_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -0.5F));

        PartDefinition wing_right_r1 = wing_right.addOrReplaceChild("wing_right_r1", CubeListBuilder.create().texOffs(18, 11).addBox(0.0F, -8.0F, 0.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0295F, 0.4665F, -0.2075F, 0.2773F, 0.0196F, -0.0003F));

        PartDefinition wing_left = Body.addOrReplaceChild("wing_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -0.5F));

        PartDefinition wing_left_r1 = wing_left.addOrReplaceChild("wing_left_r1", CubeListBuilder.create().texOffs(18, 11).mirror().addBox(-1.0F, -8.0F, 0.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0295F, 0.4665F, -0.2075F, 0.2773F, -0.0196F, 0.0003F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(OwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OwlAnimations.OWL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.walkingAnimationState, OwlAnimations.OWL_WALK, ageInTicks, 1f);

        this.animateWalk(OwlAnimations.OWL_FLYING, limbSwing, limbSwingAmount, 2f, 2f);
        this.animate(entity.flyingAnimationState, OwlAnimations.OWL_FLYING, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -135f, 135);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Body;
    }
}
