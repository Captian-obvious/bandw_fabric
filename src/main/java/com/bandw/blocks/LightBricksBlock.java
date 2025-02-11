package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;

public class LightBricksBlock extends Block {
    public LightBricksBlock() {
        super(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F));
    }
}
