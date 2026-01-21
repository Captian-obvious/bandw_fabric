package com.normalorg.bandw.particle;

import com.normalorg.bandw.Defiance;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static void registerParticles() {
        Defiance.LOGGER.info("Registering Mod Particles for " + Defiance.MOD_ID);
    };
};