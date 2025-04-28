package com.normalorg.bandw.registry;

import com.normalorg.bandw.Main;
import com.normalorg.bandw.entity.effect.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

public class ModSounds {
    public static final SoundEvent CORRUPT=registerSound("corrupt");
    public static final SoundEvent SHOCKWAVE=registerSound("shockwave");
    private static SoundEvent registerSound(String id){
        Identifier identifier=Identifier.of(Main.MOD_ID,id);
        return Registry.register(Registries.SOUND_EVENT,identifier,SoundEvent.of(identifier));
    };
    public static void registerSounds() {
        Main.LOGGER.info("Registering Sounds...");
    };
};