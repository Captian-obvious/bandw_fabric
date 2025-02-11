package com.bandw.blocks;

import net.minecraft.block.Block;
import net.fabricmc.fabric.api.block.Material;
import net.minecraft.block.AbstractBlock.Settings;

public class LightChiseledBricksBlock extends Block {
    public LightChiseledBricksBlock() {
        super(Settings.of(Material.STONE).strength(3.0F, 3.0F));
    }
}
