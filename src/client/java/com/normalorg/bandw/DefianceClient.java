package com.normalorg.bandw;

import com.normalorg.bandw.render.entity.ModEntityRenderers;
import com.normalorg.bandw.render.block.entity.ModBlockEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DefianceClient implements ClientModInitializer {
    public static final String MOD_ID = "bandw";
    public static final String VERSION="2.7.6";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitializeClient() {
        LOGGER.info("Client Initializing...");
        ModBlockEntityRenderers.registerBlockEntityRenderers();
        ModEntityRenderers.registerEntityRenderers();
        LOGGER.info("Client Initialized (Defiance v"+VERSION+")");
    };
};