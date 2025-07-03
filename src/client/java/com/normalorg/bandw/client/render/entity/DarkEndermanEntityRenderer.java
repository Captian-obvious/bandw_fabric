package com.normalorg.bandw.client.render.entity;

import com.normalorg.bandw.client.DefianceClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EndermanEntityRenderer;
import net.minecraft.client.render.entity.state.EndermanEntityRenderState;
import net.minecraft.util.Identifier;

public class DarkEndermanEntityRenderer extends EndermanEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(DefianceClient.MOD_ID, "textures/entity/dark_enderman.png");
    public DarkEndermanEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    };
    @Override
    public Identifier getTexture(EndermanEntityRenderState state){
        return TEXTURE;
    };
};