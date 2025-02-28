package com.bandw;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ClientMain implements ClientModInitializer {
    public static final String MOD_ID = "bandw";
    public static final String VERSION="1.9.5";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitializeClient() {
        LOGGER.info("Client Initializing...");
        LOGGER.info("Client Initialized (B&W v"+VERSION+")");
    };
};