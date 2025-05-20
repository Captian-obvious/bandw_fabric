package com.normalorg.bandw.util;
// Imports
import net.fabricmc.loader.api.FabricLoader;
// mod checker utility
// This class checks if a mod is loaded and if given the version argument,that it has a specific version
// Superduperdev2 was here -- 2025-20-5
public class ModChecker { 
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    };
    public static boolean isModLoaded(String modId, String version) {
        return FabricLoader.getInstance().isModLoaded(modId) && FabricLoader.getInstance().getModContainer(modId).get().getMetadata().getVersion().getFriendlyString().equals(version);
    };
};