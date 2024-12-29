// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
package com.bandw.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class DarkEndermanModel extends EntityModel<Entity> {
    private final ModelPart Head;
    private final ModelPart Body;
    private final ModelPart RightArm;
    private final ModelPart LeftArm;
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;

    public DarkEndermanModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -24.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F))
            .uv(0, 16).cuboid(-4.0F, -22.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild("Body", ModelPartBuilder.create().uv(32, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));
        modelPartData.addChild("RightArm", ModelPartBuilder.create().uv(56, 0).cuboid(-3.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -12.0F, 0.0F));

        modelPartData.addChild("LeftArm", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, -12.0F, 0.0F));

        modelPartData.addChild("RightLeg", ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.0F));

        modelPartData.addChild("LeftLeg", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, -2.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.yaw = netHeadYaw * ((float) Math.PI / 180F);
        this.Head.pitch = headPitch * ((float) Math.PI / 180F);
        
        this.RightArm.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.LeftArm.pitch = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
        
        this.RightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LeftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}

