package com.bandw.registry;

import com.bandw.blocks;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block DARK_BRICKS = new blocks.DarkBricksBlock();
    public static final Block LIGHT_BRICKS = new blocks.LightBricksBlock();
    public static final Block DARK_LOG = new blocks.DarkLogBlock();
    public static final Block DARK_BARK = new DarkBarkBlock();
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("bandw", "dark_bricks"), DARK_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("bandw", "light_bricks"), LIGHT_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("bandw", "dark_log"), DARK_LOG);
        Registry.register(Registry.BLOCK, new Identifier("bandw", "dark_bark"
    };
};
