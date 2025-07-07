package com.normalorg.bandw.client.render.entity.model;

import com.normalorg.bandw.client.DefianceClient;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer WALKER = new EntityModelLayer(Identifier.of(DefianceClient.MOD_ID, "walker"),"main");
    public static void init() {
        EntityModelLayerRegistry.registerModelLayer(WALKER, WalkerEntityModel::getTexturedModelData);
    };
};