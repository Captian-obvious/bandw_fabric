package com.normalorg.bandw.fluid;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public abstract class PureLight extends FlowableFluid {
    @Override
    protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
        super.appendProperties(builder);
        builder.add(Properties.LEVEL_1_8); // Add the fluid level property
    };
    /*@Override
    public boolean matchesType(Fluid fluid) {
        return fluid == STILL || fluid == FLOWING;
    };*/
};