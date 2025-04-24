package com.bandw.registry;

import com.bandw.Main;
import com.bandw.effect.*;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.damage.DamageType;

public class ModDamageSources {
    public static final RegistryKey<DamageType> CASSHEN_EXPLOSION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Main.MOD_ID, "casshen_explode"));
    public static final RegistryKey<DamageType> CASSHEN_BEAM = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Main.MOD_ID, "casshen_beam"));
    public static final RegistryKey<DamageType> FRACTURED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Main.MOD_ID, "fractured"));
    public static void registerDamageSources() {
        Main.LOGGER.info("Registering damage types",Main.MOD_ID);
    };
};