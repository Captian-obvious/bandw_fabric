package com.bandw.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class DarkEndermanEntity extends EndermanEntity {
    public DarkEndermanEntity(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
    };
};