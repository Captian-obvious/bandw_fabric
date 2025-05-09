package com.normalorg.bandw.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public record SunderbeamEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {
	public static final MapCodec<SunderbeamEnchantmentEffect> CODEC=RecordCodecBuilder.mapCodec(instance ->instance.group(EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(LightningEnchantmentEffect::amount)).apply(instance, SunderbeamEnchantmentEffect::new));
    public void apply(ServerWorld world,int level,EnchantmentEffectContext context,Entity target,Vec3d pos){
        if (target instanceof LivingEntity victim){
        };
    };
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    };
};