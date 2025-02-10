package com.bandw.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CorruptionStatusEffect extends StatusEffect {
    public CorruptionStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    };
    // Override methods to define the custom effect behavior
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Define when the effect should be applied
        return true;
    };
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Define the effect on the entity
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1); // Example: Grant experience points
        };
    };
};
