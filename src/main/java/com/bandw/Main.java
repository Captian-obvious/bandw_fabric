package com.bandw;

import com.bandw.ModChecker;
import com.bandw.registry.ModBlocks;
import com.bandw.registry.ModEntities;
import com.bandw.registry.ModBlocks;
import com.bandw.registry.ModItems;
import com.bandw.registry.ModEntityAttributes;
import com.bandw.registry.ModPotions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
// mod checker utility
public class Main implements ModInitializer {
    public static boolean isCharterLoaded;
    public static final String MOD_ID = "bandw";
    public static boolean judgmentEnabled=false;
    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModBlocks.registerBlockEntities();
        ModEntities.registerEntities();
        ModEntityAttributes.registerAttributes();
        ModItems.registerItems();
        ModEffects.registerEffects();
        ModPotions.registerPotions();
        isCharterLoaded = ModChecker.isModLoaded("charter");
        if (isCharterLoaded) {
            System.out.println("Charter mod is loaded! Enabling additional features.");
            judgmentEnabled=true;
        }else{
            System.out.println("Charter mod is not loaded.");
        };
    };
};