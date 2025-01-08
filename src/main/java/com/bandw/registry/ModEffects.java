package com.bandw.registry;

import com.bandw.effects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect CORRUPTION_EFFECT = new effects.CorruptionStatusEffect(StatusEffectCategory.HARMFUL, 0x98D982);
    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("bandw", "corruption"), CORRUPTION_EFFECT);
    };
};