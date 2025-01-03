package com.bandw.blocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

public class CustomBlockEntity extends BlockEntity {
    private boolean hasCollisions = true;

    public CustomBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.CUSTOM_BLOCK, pos, state);
    }

    public void setHasCollisions(boolean hasCollisions) {
        this.hasCollisions = hasCollisions;
    }

    public boolean hasCollisions() {
        return hasCollisions;
    }
    @Override
    public void tick() {
        if (!hasCollisions()) {
            // Disable collisions
            // Your logic to disable collisions
        } else {
            // Enable collisions
            // Your logic to enable collisions
        };
    };
};