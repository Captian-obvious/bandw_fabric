package com.bandw;

import net.fabricmc.loader.api.FabricLoader;
//mod checker utility
public class ModChecker { 
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    };
};
