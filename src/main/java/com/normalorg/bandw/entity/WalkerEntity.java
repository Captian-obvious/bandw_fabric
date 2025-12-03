package com.normalorg.bandw.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class WalkerEntity extends PathAwareEntity {
    public WalkerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    };
    public static DefaultAttributeContainer.Builder createWalkerAttributes() {
        return PathAwareEntity.createMobAttributes()
            .add(EntityAttributes.MAX_HEALTH, 80.0d)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.25d)
            .add(EntityAttributes.ATTACK_DAMAGE, 6.0d);
    };
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true)); // Attack targets
        this.goalSelector.add(2, new ActiveTargetGoal<LivingEntity>(this,LivingEntity.class,10,true,true,null)); // Follow targets
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0)); // Wander behavior
        this.goalSelector.add(4, new LookAroundGoal(this)); // Optional: look around randomly
    };
};