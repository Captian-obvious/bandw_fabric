package com.normalorg.shockwave;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ClientModInitializer;

public class ShockwaveClient implements ClientModInitializer {
    public static final String MOD_ID = "shockwave";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitializeClient() {
        // This is the client-side initialization method.
        // You can register your client-side features here.
        LOGGER.info("Client Library for Shockwave initialized.");
    };
};