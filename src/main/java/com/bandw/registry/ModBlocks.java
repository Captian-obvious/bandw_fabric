package com.bandw.registry;

import com.bandw.blocks.DarkBricksBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block DARK_BRICKS = new DarkBricksBlock();
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("bandw", "dark_bricks"), DARK_BRICKS);
    };
};
