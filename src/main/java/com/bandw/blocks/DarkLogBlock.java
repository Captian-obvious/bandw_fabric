package com.bandw.blocks;

import net.minecraft.block.Block;
import net.fabricmc.fabric.api.block.Material;
import net.minecraft.block.AbstractBlock.Settings;

public class DarkLogBlock extends Block {
    public DarkLogBlock() {
        super(Settings.of(Material.WOOD).strength(2.0F, 2.0F));
    };
};