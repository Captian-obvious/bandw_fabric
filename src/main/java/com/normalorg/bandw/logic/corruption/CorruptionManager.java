package com.normalorg.bandw.logic.corruption;

import com.normalorg.bandw.registry.CorruptionRegistry;
import com.normalorg.bandw.sound.ModSounds;
import net.minecraft.sound.SoundCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import java.util.Random;

public class CorruptionManager {
    private static final Random random = new Random();
    public static void corruptArea(ServerWorld world, BlockPos center, int range) {
        Vec3d soundPos = Vec3d.ofBottomCenter(center);
        world.playSound(null, soundPos.getX(), soundPos.getY(), soundPos.getZ(),
            ModSounds.CORRUPT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        // Primary cube corruption
        for (BlockPos pos : BlockPos.iterate(center.add(-range, -range, -range), center.add(range, range, range))) {
            corruptBlock(world, pos);
        };
        // Spawn tendrils outward
        int tendrilCount = 3 + random.nextInt(3); // 3 to 5 tendrils
        for (int i = 0; i < tendrilCount; i++) {
            spawnTendril(world, center, range + 5 + random.nextInt(4));
        };
    };
    private static void spawnTendril(ServerWorld world, BlockPos origin, int length) {
        for (int i = 0; i < length; i++) {
            int dx = random.nextInt(3) - 1;
            int dy = random.nextInt(2); // Prefer horizontal spread
            int dz = random.nextInt(3) - 1;
            if (dx == 0 && dz == 0) dx = 1; // Avoid null direction
            BlockPos pos = origin;
            pos = pos.add(dx, dy, dz);
            corruptBlock(world, pos);
        };
    };
    private static void corruptBlock(ServerWorld world, BlockPos pos) {
        BlockState currentState = world.getBlockState(pos);
        Block corruptBlock = CorruptionRegistry.getReplacement(currentState.getBlock());
        if (corruptBlock != currentState.getBlock()) {
            world.setBlockState(pos, corruptBlock.getDefaultState());
        };
    };
};
