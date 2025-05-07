package com.normalorg.bandw.render.entity;

import com.normalorg.bandw.DefianceClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EndermanEntityRenderer;
import net.minecraft.util.Identifier;

public class DarkEndermanEntityRenderer extends EndermanEntityRenderer {
    private static final Identifier DARK_ENDERMAN_TEXTURE = Identifier.of(DefianceClient.MOD_ID, "textures/entity/dark_enderman.png");
    public DarkEndermanEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    };
    /*@Override
    public Identifier getTexture(EndermanEntity entity) {
        return DARK_ENDERMAN_TEXTURE;
    };
    */
};