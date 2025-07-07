package com.normalorg.bandw.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class WalkerEntity extends PathAwareEntity {
    public WalkerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    };
    public static DefaultAttributeContainer.Builder createWalkerAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.MAX_HEALTH, 80.0d)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.25d)
            .add(EntityAttributes.ATTACK_DAMAGE, 6.0d);
    };
};