package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;

public class DarkBarkBlock extends Block {
    public DarkBarkBlock() {
        super(Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F));
    };
};