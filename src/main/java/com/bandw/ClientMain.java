package com.bandw;

import com.bandw.render;
import com.bandw.registry.ClientRegistry;
import com.bandw.utils.ElectricArcUtils;
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
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world != null) {
            Vec3d start = new Vec3d(0, 64, 0);
            Vec3d end = new Vec3d(10, 64, 10);
            ElectricArcUtils.createElectricArc(client.world, start, end, 0.5f, 1.0f);
        };
    };
};