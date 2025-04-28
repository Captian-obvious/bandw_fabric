package com.normalorg.bandw.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ShieldOfLightBlock extends BlockWithEntity {
    public ShieldOfLightBlock(Settings settings) {
        super(settings);
    };
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(ShieldOfLightBlock::new);
    };
    @Override
    public BlockEntity createBlockEntity(BlockPos pos,BlockState state) {
        ShieldBlockEntity h=new ShieldBlockEntity(pos,state);
        h.initialize();
        return h;
    };
    public boolean hasBlockEntity() {
        return true;
    };
};