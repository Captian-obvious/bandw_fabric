package com.normalorg.bandw.client.render.entity;

import com.normalorg.bandw.client.DefianceClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.state.EndermanEntityRenderState;
import net.minecraft.util.Identifier;

public class DarkZombieEntityRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(DefianceClient.MOD_ID, "textures/entity/dark_enderman.png");
    public DarkZombieEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    };
};