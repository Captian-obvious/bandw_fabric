package com.bandw.effects;

import com.bandw.registry.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class CleansingStatusEffect extends StatusEffect {
    public CleansingStatusEffect(StatusEffectCategory category, int color) {
        super(category,color);
    };
    // Override methods to define the custom effect behavior
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration,amplifier);
    };
    @Override
    public boolean applyUpdateEffect(ServerWorld world,LivingEntity entity, int amplifier) {
        if (entity instanceof LivingEntity){
            if (entity.hasStatusEffect(ModEffects.CORRUPTION)){
                StatusEffectInstance instance = new StatusEffectInstance(ModEffects.CORRUPTION,0,0);
                StatusEffectInstance instance2 = new StatusEffectInstance(ModEffects.DARKENING,200,0);
                StatusEffectInstance instance3 = new StatusEffectInstance(StatusEffects.NAUSEA,200,0);
                boolean success=livingEntity.addStatusEffect(instance);
                boolean success2=livingEntity.addStatusEffect(instance2);
                boolean success3=livingEntity.addStatusEffect(instance3);
                if (!success){
                    Main.LOGGER.info("Failed to remove effect 'bandw:corruption' from entity, ignoring and continuing");
                };
                if (!success2){
                    Main.LOGGER.info("Failed to add effect 'bandw:darkening' to entity, ignoring and continuing");
                };
                if (!success3){
                    Main.LOGGER.info("Failed to add effect 'minecraft:nausea' to entity, ignoring and continuing");
                };
            };
        };
        return super.applyUpdateEffect(world,entity, amplifier);
    };
};