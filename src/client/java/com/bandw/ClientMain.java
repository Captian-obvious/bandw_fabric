package com.bandw;

import com.bandw.registry.ModBlockEntities;
import com.bandw.render.ShieldBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererFactories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ClientMain implements ClientModInitializer {
    public static final String MOD_ID = "bandw";
    public static final String VERSION="1.9.5";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitializeClient() {
        LOGGER.info("Client Initializing...");
        BlockEntityRendererFactories.register(ModBlockEntities.SHIELD_BLOCK_ENTITY,ShieldBlockEntityRenderer::new);
        LOGGER.info("Client Initialized (B&W v"+VERSION+")");
    };
};