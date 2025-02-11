package com.bandw;

//Mod Checker Utility
import com.bandw.ModChecker;
//end Mod Checker
import com.bandw.registry.ModBlocks;
import com.bandw.registry.ModEntities;
import com.bandw.registry.ModEffects;
import com.bandw.registry.ModBlocks;
import com.bandw.registry.ModItems;
import com.bandw.registry.ModEntityAttributes;
import com.bandw.registry.ModPotions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static boolean isCharterLoaded;
    public static final String MOD_ID = "bandw";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean judgmentEnabled=false;
    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        //ModBlocks.registerBlockEntities();
        ModEntities.registerEntities();
        ModEntityAttributes.registerAttributes();
        ModItems.registerItems();
        ModEffects.registerEffects();
        ModPotions.registerPotions();
        isCharterLoaded = ModChecker.isModLoaded("charter");
        if (isCharterLoaded) {
            LOGGER.info("Charter mod is loaded! Enabling additional features.");
            judgmentEnabled=true;
        }else{
            LOGGER.info("Charter mod is not loaded.");
        };
    };
};