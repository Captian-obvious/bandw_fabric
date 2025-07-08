package com.normalorg.bandw.entity;

import com.normalorg.bandw.Defiance;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;

public class ModEntityAttributes {
    public static void registerAttributes() {
        Defiance.LOGGER.info("Registering Entity Attributes for " + Defiance.MOD_ID);
        FabricDefaultAttributeRegistry.register(ModEntities.DARK_ENDERMAN,DarkEndermanEntity.createEndermanAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DARK_ZOMBIE,DarkZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.WALKER,WalkerEntity.createWalkerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.WALKER,LaserTurretEntity.createLaserTurretAttributes());
    };
};
