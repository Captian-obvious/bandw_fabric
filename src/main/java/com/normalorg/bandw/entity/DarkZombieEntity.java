package com.normalorg.bandw.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class DarkZombieEntity extends ZombieEntity {
    public DarkZombieEntity(EntityType<? extends DarkZombieEntity> entityType, World world) {
        super(entityType, world);
    };
};