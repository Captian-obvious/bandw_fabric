package com.bandw.registry;

import com.bandw.Main;
import com.bandw.entities.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer DARK_ENDERMAN_LAYER = new EntityModelLayer(new Identifier(Main.MOD_ID, "dark_enderman"), "main");
    @Override
    public void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(DARK_ENDERMAN_LAYER, DarkEndermanModel::getTexturedModelData);
    }
};