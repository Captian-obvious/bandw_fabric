package com.normalorg.bandw.render.entity;

import com.normalorg.bandw.entity.ModEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;

public class ModEntityRenderers {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.DARK_ENDERMAN, (EntityRendererFactory.Context context) -> new DarkEndermanEntityRenderer(context));
    };
};