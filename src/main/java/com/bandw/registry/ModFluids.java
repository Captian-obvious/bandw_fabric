package com.normalorg.bandw.registry;

import com.normalorg.bandw.Main;
import com.normalorg.bandw.blocks.*;
import java.util.function.Function;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;

public class ModFluids {
    /*
    public static final FlowableFluid STILL_PURE_LIGHT = new MyFluid.Still();
    public static final FlowableFluid FLOWING_PURE_LIGHT = new MyFluid.Flowing();
    public static final Block PURE_LIGHT_BLOCK = new FluidBlock(STILL_MY_FLUID, Block.Settings.copy(Blocks.WATER));
    */
    public static void registerFluids(){
        Main.LOGGER.info("Registering fluids...");
    };
};