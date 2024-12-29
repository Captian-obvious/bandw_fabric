package com.bandw;

import com.bandw.registry.ModEntities;
import com.bandw.registry.ModEntityAttributes;
import com.bandw.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
// mod checker utility
public class ModChecker { public static boolean isModLoaded(String modId) { return FabricLoader.getInstance().isModLoaded(modId);};};
public class Main implements ModInitializer {public static boolean isCharterLoaded;@Overridepublic void onInitialize() {ModEntities.registerEntities();ModEntityAttributes.registerAttributes();ModItems.registerItems();isCharterLoaded = ModChecker.isModLoaded("charter");if (isCharterLoaded) {System.out.println("Charter mod is loaded! Enabling additional features.");}else{ System.out.println("Charter mod is not loaded.");};};
};
