package com.bandw.registry;

import com.bandw.entities.DarkEndermanModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers implements ClientModInitializer {
    public static final EntityModelLayer DARK_ENDERMAN_LAYER = new EntityModelLayer(new Identifier("bandw", "dark_enderman"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(DARK_ENDERMAN_LAYER, DarkEndermanModel::getTexturedModelData);
    }
};