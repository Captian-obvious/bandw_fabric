package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ShieldOfLightBlock extends Block {
    public ShieldOfLightBlock() {
        super(Settings.create().sounds(BlockSoundGroup.STONE).strength(4.0F, 12.0F));
    };
    /*@Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ShieldBlockEntity(this.getPosition());
    };*/

    @Override
    public boolean hasBlockEntity() {
        return true;
    };
};