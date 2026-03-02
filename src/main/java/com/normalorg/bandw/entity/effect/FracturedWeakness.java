package com.normalorg.bandw.entity.effect;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.damage.ModDamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;

public class FracturedWeakness extends StatusEffect {
    public FracturedWeakness(StatusEffectCategory category, int color) {
        super(category,color);
    };
    // Override methods to define the custom effect behavior
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    };
    @Override
    public boolean applyUpdateEffect(ServerWorld world,LivingEntity entity, int amplifier) {
        if (entity instanceof LivingEntity){
            // effect soon
        };
        return super.applyUpdateEffect(world,entity,amplifier);
    };
};