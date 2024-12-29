package com.bandw.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class DarkEndermanEntity extends EndermanEntity {
    public DarkEndermanEntity(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
    };
	public static DefaultAttributeContainer.Builder createEndermanAttributes() {
    	return EndermanEntity.createEndermanAttributes()
        	.add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
        	.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
	};
};