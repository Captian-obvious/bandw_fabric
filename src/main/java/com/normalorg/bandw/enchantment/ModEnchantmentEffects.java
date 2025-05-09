package com.normalorg.bandw.enchantment;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.enchantment.effect.SunderbeamEnchantmentEffect
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final RegistryKey<Enchantment> SUNDERBEAM=of("sunderbeam");
    public static MapCodec<SunderbeamEnchantmentEffect> SUNDERBEAM_EFFECT=register("sunderbeam_effect", SunderbeamEnchantmentEffect.CODEC);
    private static RegistryKey<Enchantment> of(String path) {
		Identifier id = Identifier.of(Defiance.MOD_ID,path);
		return RegistryKey.of(RegistryKeys.ENCHANTMENT,id);
	};
    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE,Identifier.of(Defiance.MOD_ID, id),codec);
	};
    public static void registerEnchantmentEffects(){
        Defiance.LOGGER.info("Registering EnchantmentEffects...");
    };
};