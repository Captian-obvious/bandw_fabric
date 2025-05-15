package com.normalorg.shockwave.api;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.Particle;

public class ParticleHandler {
    // Placeholder instance to be managed by ShockwaveAPI
    private static final ParticleHandler INSTANCE=new ParticleHandler();
    // Private constructor to enforce singleton usage through ShockwaveAPI
    private ParticleHandler() {};
    public static ParticleHandler getInstance(){
        return INSTANCE;
    };
    // Placeholder method for spawning particles (will be expanded later)
    public void spawnParticle(ClientWorld world, Particle particle, double x, double y, double z){
        // Implementation will be refined as Shockwave evolves
    };
};