package com.normalorg.bandw.block;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.BlockState;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.AbstractBlock.Settings;

public class CustomFallingBlock extends Block {
    public CustomFallingBlock(Settings settings){
        super(settings);
    };
    public static void spawnFallingBlock(World world, BlockPos pos, BlockState state) {
        if (!world.isClient()){
            ServerWorld serverWorld = (ServerWorld) world;
            FallingBlockEntity fallingBlock = FallingBlockEntity.spawnFromBlock(serverWorld, pos, state);
            serverWorld.spawnEntity(fallingBlock);
        };
    };
    @Override
    protected void neighborUpdate(BlockState state,World world,BlockPos pos,Block sourceBlock,WireOrientation wireOrientation,boolean notify) {
        if (world.isAir(pos.down())) {
            CustomFallingBlock.spawnFallingBlock(world, pos, state);
            world.removeBlock(pos, false);
        };
    };
};