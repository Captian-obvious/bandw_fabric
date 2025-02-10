package com.bandw.registry;

import com.bandw.Main;
import com.bandw.effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModEffects {
    public static final StatusEffect CORRUPTION_EFFECT = new CorruptionStatusEffect(StatusEffectCategory.HARMFUL, 0x98D982);
    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(Main.MOD_ID, "corruption"), CORRUPTION_EFFECT);
    };
};