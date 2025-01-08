package com.bandw.registry;

import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static final Potion CORRUPTION_POTION = new Potion(new StatusEffectInstance(ModEffects.CUSTOM_EFFECT,3600));

    public static void registerPotions() {
        Registry.register(Registry.POTION, new Identifier("bandw", "corruption_potion"), CORRUPTION_POTION);
    };
};