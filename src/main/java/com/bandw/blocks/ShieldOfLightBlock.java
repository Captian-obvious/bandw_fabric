package com.bandw.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ShieldOfLightBlock extends Block {
    public ShieldOfLightBlock(Settings settings) {
        super(settings);
    };

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ShieldBlockEntity();
    };

    @Override
    public boolean hasBlockEntity() {
        return true;
    };
};