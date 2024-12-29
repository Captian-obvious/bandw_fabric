package com.bandw;

import com.bandw.registry.ModEntities;
import com.bandw.render.DarkEndermanRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BandWModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DARK_ENDERMAN, DarkEndermanRenderer::new);
    };
};