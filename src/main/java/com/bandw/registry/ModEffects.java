package com.bandw.registry;

import com.bandw.Main;
import com.bandw.effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

public class ModEffects {
    public static final StatusEffect CORRUPTION_EFFECT = new CorruptionStatusEffect(StatusEffectCategory.HARMFUL, 0x015032);
    public static final StatusEffect DARKENED_EFFECT = new DarkeningStatusEffect(StatusEffectCategory.HARMFUL, 0x111111);
    public static final StatusEffect CLEANSING_EFFECT = new CleansingStatusEffect(StatusEffectCategory.BENEFICIAL, 0x111111);
    public static RegistryEntry<StatusEffect> CORRUPTION;
    public static RegistryEntry<StatusEffect> DARKENING;
    public static RegistryEntry<StatusEffect> CLEANSING;
    public static void registerEffects() {
        Main.LOGGER.info("Registering effects...");
        CORRUPTION=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Main.MOD_ID, "corruption"), CORRUPTION_EFFECT);
        DARKENING=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Main.MOD_ID, "darkening"), DARKENED_EFFECT);
        CLEANSING=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Main.MOD_ID, "cleansing"), CLEANSING_EFFECT);
    };
};