package com.normalorg.bandw.component;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.*;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

public class ModComponents {
    public static final ComponentType<Integer> CHARGE_COMPONENT=Registry.register(Registries.DATA_COMPONENT_TYPE,Identifier.of(Main.MOD_ID,"charge"),ComponentType.<Integer>builder().codec(Codec.INT).build());
    public static void registerComponents() {
        Defiance.LOGGER.info("Registering {} components",Main.MOD_ID);
    };
};