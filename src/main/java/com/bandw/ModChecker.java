package com.bandw;

public class ModChecker { 
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    };
};