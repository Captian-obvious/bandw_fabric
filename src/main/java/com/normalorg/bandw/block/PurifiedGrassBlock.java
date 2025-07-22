package com.normalorg.bandw.block;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.block.GrassBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.AbstractBlock.Settings;

public class PurifiedGrassBlock extends GrassBlock {
    public PurifiedGrassBlock(Settings settings) {
        super(settings);
    };
};