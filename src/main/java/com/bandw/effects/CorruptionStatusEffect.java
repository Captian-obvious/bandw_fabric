package com.bandw.effects;

import com.bandw.Main;
import com.bandw.registry.ModSounds;
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
        int interval = 60 >> amplifier;
        return interval > 0 && duration % interval == 0;
    };
    @Override
    public boolean applyUpdateEffect(ServerWorld world,LivingEntity entity, int amplifier) {
        if (entity instanceof LivingEntity){
            entity.playSound(ModSounds.CORRUPT, 2f, 1f);
        };
        return super.applyUpdateEffect(world,entity, amplifier);
    };
};