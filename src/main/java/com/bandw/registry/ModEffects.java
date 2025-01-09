package com.bandw.registry;

import com.bandw.effects.CorruptionStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModEffects {
    public static final StatusEffect CORRUPTION_EFFECT = new CorruptionStatusEffect(StatusEffectCategory.HARMFUL, 0x98D982);
    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, Identifier.of("bandw", "corruption"), CORRUPTION_EFFECT);
    };
};