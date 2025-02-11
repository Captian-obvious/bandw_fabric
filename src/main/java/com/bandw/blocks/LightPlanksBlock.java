package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;

public class LightPlanksBlock extends Block {
    public LightPlanksBlock() {
        super(Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F));
    }
}