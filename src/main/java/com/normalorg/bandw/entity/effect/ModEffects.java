package com.normalorg.bandw.entity.effect;

import com.normalorg.bandw.Defiance;
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
    public static final StatusEffect HALFSHADE_POISONING_EFFECT = new HalfshadePoisoningStatusEffect(StatusEffectCategory.HARMFUL,0x9f9999);
    public static RegistryEntry<StatusEffect> CORRUPTION;
    public static RegistryEntry<StatusEffect> DARKENING;
    public static RegistryEntry<StatusEffect> CLEANSING;
    public static RegistryEntry<StatusEffect> HALFSHADE_POISONING;
    public static void registerEffects() {
        Defiance.LOGGER.info("Registering effects for " + Defiance.MOD_ID);
        CORRUPTION=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Defiance.MOD_ID, "corruption"), CORRUPTION_EFFECT);
        DARKENING=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Defiance.MOD_ID, "darkening"), DARKENED_EFFECT);
        CLEANSING=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Defiance.MOD_ID, "cleansing"), CLEANSING_EFFECT);
        HALFSHADE_POISONING=Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Defiance.MOD_ID, "halfshade_poisoning"), HALFSHADE_POISONING_EFFECT);
    };
};