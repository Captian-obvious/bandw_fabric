package com.normalorg.bandw.registry;

import net.minecraft.block.Block;
import java.util.HashMap;
import java.util.Map;

public class CorruptionRegistry {
    private static Map<Block, Block> replacementMap=new HashMap<>();
    public static void register(Block original, Block corrupted) {
        replacementMap.put(original,corrupted);
    };
    public static Block getReplacement(Block original) {
        return replacementMap.getOrDefault(original,original); // Return the original if no replacement is found
    };
};