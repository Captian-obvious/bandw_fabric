package com.normalorg.bandw.potion;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion DARKENING_POTION=registerPotion("darkening_potion",new StatusEffectInstance(ModEffects.DARKENING, 200, 0));
    public static Potion registerPotion(String name, StatusEffectInstance effect) {
        Identifier id=Identifier.of(Defiance.MOD_ID,name);
        Potion potion=new Potion(name,effect);
        return Registry.register(Registries.POTION,id,potion);
    };
    public static void registerPotions() {
        Defiance.LOGGER.info("Registering potions...");
    };
};