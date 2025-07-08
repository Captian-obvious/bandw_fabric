package com.normalorg.bandw.client.render.entity;

import com.normalorg.bandw.client.DefianceClient;
import com.normalorg.bandw.client.render.entity.model.ModEntityModelLayers;
import com.normalorg.bandw.client.render.entity.state.LaserTurretEntityRenderState;
import com.normalorg.bandw.client.render.entity.model.LaserTurretEntityModel;
import com.normalorg.bandw.entity.LaserTurretEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class LaserTurretEntityRenderer extends MobEntityRenderer<LaserTurretEntity,LaserTurretEntityRenderState,LaserTurretEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(DefianceClient.MOD_ID, "textures/entity/laser_turret.png");
    public LaserTurretEntityRenderer(EntityRendererFactory.Context context) {
        super(context,new LaserTurretEntityModel(context.getPart(ModEntityModelLayers.LASER_TURRET)),1.0f);
    };
    @Override
    public Identifier getTexture(LaserTurretEntityRenderState state){
        return TEXTURE;
    };
    @Override
    public LaserTurretEntityRenderState createRenderState() {
        return new LaserTurretEntityRenderState(); // You can flesh this out later
    };
};
