package com.normalorg.bandw.block;

import net.minecraft.block.FallingBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock.Settings;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class CustomFallingBlock implements FallingBlock {
    public static final MapCodec<CustomFallingBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->instance.group(Settings.CODEC.fieldOf("settings").forGetter(block -> block.settings)).apply(instance, CustomFallingBlock::new));
    public CustomFallingBlock(Settings settings) {
        super(settings);
    };
    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return CODEC.cast();
    };
};