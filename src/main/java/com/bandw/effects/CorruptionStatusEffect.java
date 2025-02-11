package com.bandw.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class CorruptionStatusEffect extends StatusEffect {
    public CorruptionStatusEffect(StatusEffectCategory category, int color) {
        super(category,color);
    };
    // Override methods to define the custom effect behavior
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    };
    @Override
    public boolean applyUpdateEffect(ServerWorld world,LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world,entity, amplifier);
    };
};
