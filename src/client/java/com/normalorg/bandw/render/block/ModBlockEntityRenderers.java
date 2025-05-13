package com.normalorg.bandw.render.block;

import com.normalorg.bandw.DefianceClient;
import com.normalorg.bandw.block.entity.ModBlockEntities;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRenderers {
    public static void registerBlockEntityRenderers(){
        BlockEntityRendererFactories.register(ModBlockEntities.SHIELD_BLOCK_ENTITY,ShieldBlockEntityRenderer::new);
    };
};