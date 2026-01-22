package com.normalorg.bandw.particle;

import com.normalorg.bandw.Defiance;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType EXAMPLE_PARTICLE = register("example_particle", true);
    public static SimpleParticleType register(String name,boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Defiance.MOD_ID, name), FabricParticleTypes.simple());
    };
    public static void registerParticles() {
        Defiance.LOGGER.info("Registering Mod Particles for " + Defiance.MOD_ID);
    };
};