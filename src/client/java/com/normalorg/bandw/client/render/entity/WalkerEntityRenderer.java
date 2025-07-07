package com.normalorg.bandw.client.render.entity;

import com.normalorg.bandw.client.DefianceClient;
import com.normalorg.bandw.client.model.ModModelLayers;
import com.normalorg.bandw.client.render.entity.state.WalkerEntityRenderState;
import com.normalorg.bandw.client.render.entity.model.WalkerEntityModel;
import com.normalorg.bandw.entity.WalkerEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class WalkerEntityRenderer extends MobEntityRenderer<WalkerEntity,WalkerEntityRenderState,WalkerEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(DefianceClient.MOD_ID, "textures/entity/walker.png");
    public WalkerEntityRenderer(EntityRendererFactory.Context context) {
        super(context,new WalkerEntityModel(context.getModelLoader().getModelPart(ModModelLayers.WALKER)),0.6f);
    };
    @Override
    public Identifier getTexture(WalkerEntityRenderState state){
        return TEXTURE;
    };
};