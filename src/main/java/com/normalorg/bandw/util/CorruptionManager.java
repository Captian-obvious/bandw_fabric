package com.normalorg.bandw.util;

import net.minecraft.block.Block;
import java.util.HashMap;
import java.util.Map;

public class CorruptionManager {
    private static Map<Block, Block> replacementMap;
    
    public CorruptionManager() {
        this.replacementMap = new HashMap<>();
    };
    public static void addReplacement(Block original, Block corrupted) {
        replacementMap.put(original,corrupted);
    };
    public static Block getReplacement(Block original) {
        return replacementMap.getOrDefault(original,original); // Return the original if no replacement is found
    };
};