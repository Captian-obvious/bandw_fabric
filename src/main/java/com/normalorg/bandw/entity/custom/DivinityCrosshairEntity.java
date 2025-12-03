package com.normalorg.bandw.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class DivinityCrosshairEntity extends HostileEntity { //this is odd but, lets us do things like spam damage
    public DivinityCrosshairEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    };
    public static DefaultAttributeContainer.Builder createDivinityCrosshairAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.MAX_HEALTH, 40.0D)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.25D)
            .add(EntityAttributes.ATTACK_DAMAGE, 8.0D)
            .add(EntityAttributes.FOLLOW_RANGE, 32.0D);
    };
};