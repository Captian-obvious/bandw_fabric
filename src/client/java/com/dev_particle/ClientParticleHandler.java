package com.dev_particle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;

public class ClientParticleHandler {
    public static void spawnParticle(Identifier id,double x,double y,double z,int color){
        ClientWorld world=MinecraftClient.getInstance().world;
        if (world == null) return;
    };
};