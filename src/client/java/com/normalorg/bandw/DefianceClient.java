package com.normalorg.bandw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ClientModInitializer;
import com.normalorg.bandw.render.entity.ModEntityRenderers;
import com.normalorg.bandw.render.block.entity.ModBlockEntityRenderers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class DefianceClient implements ClientModInitializer {
    public static final String MOD_ID = "bandw";
    public static final String VERSION="2.7.6";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitializeClient() {
        LOGGER.info("Client Initializing...");
        registerClientModules();
        LOGGER.info("Client Initialized (Defiance v"+VERSION+")");
    };
    public static void registerClientModules(){
        ModBlockEntityRenderers.registerBlockEntityRenderers();
        ModEntityRenderers.registerEntityRenderers();
    };
};