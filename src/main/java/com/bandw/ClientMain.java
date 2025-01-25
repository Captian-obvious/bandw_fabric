package com.bandw;

import com.bandw.render.*;
import com.bandw.registry.ClientRegistry;
import com.bandw.registry.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class ClientMain implements ClientModInitializer {
    public String MOD_ID="bandw";
    @Override
    public void onInitializeClient() {
        ClientRegistry.registerClientRenderers();
        ModModelLayers.registerModelLayers();
    };
};
