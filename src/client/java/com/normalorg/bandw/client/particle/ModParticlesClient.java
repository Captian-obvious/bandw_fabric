package com.normalorg.bandw.client.particle;

import com.normalorg.bandw.client.DefianceClient;
import com.normalorg.bandw.particle.ModParticles;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class ModParticlesClient {
    public static void registerParticleFactories() {
        DefianceClient.LOGGER.info("Registering particle factories for "+DefianceClient.MOD_ID);
        //ParticleFactoryRegistry.getInstance().register(ModParticles.CUSTOM_PARTICLE, CustomParticle.Factory::new);
    }
}