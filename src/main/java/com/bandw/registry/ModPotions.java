package com.bandw.registry;

import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModPotions {
    public static final Potion CORRUPTION_POTION = new Potion(new StatusEffectInstance(ModEffects.CORRUPTION_EFFECT,3600));
    public static void registerPotions() {
        Registry.register(Registries.POTION, Identifier.of("bandw", "corruption_potion"), CORRUPTION_POTION);
    };
};