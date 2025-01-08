package com.bandw.registry;

import com.bandw.render.DarkEndermanRenderer;
import com.bandw.render.ShieldRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class ClientRegistry {
    public static void registerClientRenderers() {
        // Register entity renderer
        EntityRendererRegistry.register(ClientReferences.DARK_ENDERMAN, DarkEndermanRenderer::new);

        // Register block entity renderer
        BlockEntityRendererRegistry.INSTANCE.register(ClientReferences.SHIELD_OF_LIGHT_BLOCK_ENTITY, ShieldRenderer::new);
    };
};