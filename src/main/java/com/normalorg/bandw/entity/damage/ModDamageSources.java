package com.normalorg.bandw.entity.damage;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.*;
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
    public static final RegistryKey<DamageType> CASSHEN_EXPLOSION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Defiance.MOD_ID, "casshen_explode"));
    public static final RegistryKey<DamageType> CASSHEN_BEAM = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Defiance.MOD_ID, "casshen_beam"));
    public static final RegistryKey<DamageType> FRACTURED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Defiance.MOD_ID, "fractured"));
    public static final RegistryKey<DamageType> DARKENED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Defiance.MOD_ID, "darkened"));
    public static void registerDamageSources() {
        Defiance.LOGGER.info("Registering damage types",Defiance.MOD_ID);
    };
};