package com.bandw;

//Mod Checker Utility
import com.bandw.util.ModChecker;
//end Mod Checker
import com.bandw.registry.ModBlocks;
import com.bandw.registry.ModEntities;
import com.bandw.registry.ModEffects;
import com.bandw.registry.ModFluids;
import com.bandw.registry.ModSounds;
import com.bandw.registry.ModBlockEntities;
import com.bandw.registry.ModItems;
import com.bandw.registry.ModEntityAttributes;
import com.bandw.util.CharterContractManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static boolean isCharterLoaded;
    public static CharterContractManager contract_manager;
    public static final String MOD_ID = "bandw";
    public static final String VERSION="2.7.4";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean judgmentEnabled=false;
    @Override
    public void onInitialize() {
        LOGGER.info("Server Initializing...");
        registerModules();
        isCharterLoaded=ModChecker.isModLoaded("charter");
        LOGGER.info(isCharterLoaded ? "Charter mod is loaded! Enabling additional features." : "Charter mod is not loaded.");
        if (isCharterLoaded) registerCharterHooks();
        judgmentEnabled=isCharterLoaded;
        LOGGER.info("Server Initialized (Defiance v"+VERSION+")");
    };
    public static void registerModules(){
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
        ModFluids.registerFluids();
        ModEntities.registerEntities();
        ModEntityAttributes.registerAttributes();
        ModItems.registerItems();
        ModEffects.registerEffects();
        ModSounds.registerSounds();
    };
    public static void registerCharterHooks(){
        LOGGER.info("Registering Charter Hooks (contract severing functionality)...");
        contract_manager=new CharterContractManager(isCharterLoaded);
        LOGGER.info("Registered Charter Hooks successfully.");
    };
};