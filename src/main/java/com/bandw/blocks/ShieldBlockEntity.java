package com.bandw.blocks;

import com.bandw.registry.ModBlocks;
import com.bandw.shields.Shield;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Vec3d;

public class ShieldBlockEntity extends BlockEntity {
    private Shield shield;
    public ShieldBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.SHIELD_OF_LIGHT_BLOCK_ENTITY, pos, state);
        shield = new Shield(new Vec3d(pos.getX(), pos.getY(), pos.getZ()), 10.0f, 1.0f);
    };
    public void tick() {
        if (shield != null) {
            shield.expand(0.05f); // Example: Expand shield gradually
            shield.weaken(0.005f); // Example: Weaken shield gradually
        };
    };
};