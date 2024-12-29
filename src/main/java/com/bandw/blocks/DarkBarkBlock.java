package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;

public class DarkBarkBlock extends Block {
    public DarkBarkBlock() {
        super(Settings.of(Material.WOOD).strength(2.0F, 2.0F));
    };
};