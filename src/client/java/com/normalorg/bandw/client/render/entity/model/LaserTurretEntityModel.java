package com.normalorg.bandw.client.render.entity.model;

import com.normalorg.bandw.client.DefianceClient;
import com.normalorg.bandw.client.render.entity.state.LaserTurretEntityRenderState;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.Dilation;

public class LaserTurretEntityModel extends EntityModel<LaserTurretEntityRenderState> {
    private ModelPart base;
	private ModelPart joint;
	private ModelPart upperjoint;
	private ModelPart conechen;
	private ModelPart gun;
	private ModelPart barrel;
	
	public LaserTurretEntityModel(ModelPart root) {
		super(root);
		this.base = root.getChild("base");
		this.joint = this.base.getChild("joint");
		this.upperjoint = this.joint.getChild("upperjoint");
		this.conechen = this.upperjoint.getChild("conechen");
		this.gun = this.conechen.getChild("gun");
		this.barrel = this.gun.getChild("barrel");
	};
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create().uv(30, 27).cuboid(-7.0F, -2.0F, -1.0F, 14.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-4.0F, -3.0F, -4.0F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(28, 41).cuboid(-8.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(38, 41).cuboid(7.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(32, 24).cuboid(-2.0F, -1.0F, 7.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 24).cuboid(-2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData joint = base.addChild("joint", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.2182F));
		ModelPartData cube_r1 = joint.addChild("cube_r1", ModelPartBuilder.create().uv(0, 39).cuboid(-1.0F, -8.0F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		ModelPartData upperjoint = joint.addChild("upperjoint", ModelPartBuilder.create(), ModelTransform.of(3.0F, -7.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
		ModelPartData cube_r2 = upperjoint.addChild("cube_r2", ModelPartBuilder.create().uv(16, 39).cuboid(-2.0F, -2.0F, -2.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.0F, 1.0F, 0.0F, 0.0F, -0.3927F));
		ModelPartData cube_r3 = upperjoint.addChild("cube_r3", ModelPartBuilder.create().uv(8, 39).cuboid(-1.0F, -8.0F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		ModelPartData conechen = upperjoint.addChild("conechen", ModelPartBuilder.create().uv(30, 35).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.2182F));
		ModelPartData gun = conechen.addChild("gun", ModelPartBuilder.create().uv(0, 27).cuboid(-3.0F, -6.0F, -3.0F, 9.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
		ModelPartData barrel = gun.addChild("barrel", ModelPartBuilder.create().uv(30, 31).cuboid(-12.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -3.0F, 0.0F));
		ModelPartData cube_r4 = barrel.addChild("cube_r4", ModelPartBuilder.create().uv(32, 20).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -0.8727F, 0.0F, 0.0F));
		ModelPartData cube_r5 = barrel.addChild("cube_r5", ModelPartBuilder.create().uv(32, 16).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		ModelPartData cube_r6 = barrel.addChild("cube_r6", ModelPartBuilder.create().uv(32, 12).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));
		ModelPartData cube_r7 = barrel.addChild("cube_r7", ModelPartBuilder.create().uv(32, 8).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 2.3998F, 0.0F, 0.0F));
		ModelPartData cube_r8 = barrel.addChild("cube_r8", ModelPartBuilder.create().uv(32, 4).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));
		ModelPartData cube_r9 = barrel.addChild("cube_r9", ModelPartBuilder.create().uv(32, 4).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 1.6144F, 0.0F, 0.0F));
		ModelPartData cube_r10 = barrel.addChild("cube_r10", ModelPartBuilder.create().uv(32, 0).cuboid(-11.0F, 1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	};
	@Override
	public void setAngles(LaserTurretEntityRenderState state) {
	};
};
