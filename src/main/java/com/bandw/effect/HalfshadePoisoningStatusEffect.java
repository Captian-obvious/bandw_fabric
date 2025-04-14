package com.bandw.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;

public class HalfshadePoisoningStatusEffect extends StatusEffect {
    public HalfshadePoisoningStatusEffect(StatusEffectCategory category, int color) {
        super(category,color);
    };
    // Override methods to define the custom effect behavior
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int interval = 50 >> amplifier;
        return interval > 0 && duration % interval == 0;
    };
    @Override
    public boolean applyUpdateEffect(ServerWorld world,LivingEntity entity, int amplifier) {
        if (entity instanceof LivingEntity){
            DamageSource damageSource=new DamageSource(world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(DamageTypes.MAGIC.getValue()).get());
            float damage = 1.0F; // You can adjust this value as needed
            entity.damage(world,damageSource,damage);
        };
        return super.applyUpdateEffect(world,entity,amplifier);
    };
};