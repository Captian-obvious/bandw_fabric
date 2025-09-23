package com.normalorg.bandw.sound;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

public class ModSounds {
    public static final SoundEvent CORRUPT=registerSound("corrupt");
    public static final SoundEvent SHOCKWAVE=registerSound("shockwave");
    public static final SoundEvent REALITY_WARPER_HUM=registerSound("reality_warper_hum");
    public static final SoundEvent LIGHT_REPULSOR_CHARGE=registerSound("light_repulsor_charge");
    public static final SoundEvent LIGHT_REPULSOR_FIRE=registerSound("light_repulsor_fire");
    public static final SoundEvent LIGHT_REPULSOR_OVERHEAT=registerSound("light_repulsor_overheat");
    //public static final SoundEvent REALITY_WARPER_TELEPORT=registerSound("reality_warper_teleport");
    private static SoundEvent registerSound(String id){
        Identifier identifier=Identifier.of(Defiance.MOD_ID,id);
        return Registry.register(Registries.SOUND_EVENT,identifier,SoundEvent.of(identifier));
    };
    public static void registerSounds() {
        Defiance.LOGGER.info("Registering Sounds for " + Defiance.MOD_ID);
    };
};