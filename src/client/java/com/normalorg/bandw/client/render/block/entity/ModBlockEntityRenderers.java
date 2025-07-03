package com.normalorg.bandw.client.render.block.entity;

import com.normalorg.bandw.client.DefianceClient;
import com.normalorg.bandw.block.entity.ModBlockEntities;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRenderers {
    public static void registerBlockEntityRenderers(){
        BlockEntityRendererFactories.register(ModBlockEntities.SHIELD_BLOCK_ENTITY,ShieldBlockEntityRenderer::new);
    };
};