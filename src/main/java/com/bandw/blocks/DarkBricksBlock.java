package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;

public class DarkBricksBlock extends Block {
    public DarkBricksBlock() {
        super(Settings.of(Material.STONE).strength(3.0F, 3.0F));
    }
};
