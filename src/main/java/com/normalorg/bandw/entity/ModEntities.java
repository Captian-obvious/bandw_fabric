package com.normalorg.bandw.entity;

import com.normalorg.bandw.Defiance;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public class ModEntities {
    public static final RegistryKey<EntityType<?>> DARK_ENDERMAN_KEY=RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Defiance.MOD_ID,"dark_enderman"));
    public static final EntityType<DarkEndermanEntity> DARK_ENDERMAN=Registry.register(Registries.ENTITY_TYPE,DARK_ENDERMAN_KEY,EntityType.Builder.create(DarkEndermanEntity::new,SpawnGroup.MONSTER).dimensions(0.6f,2.9f).build(DARK_ENDERMAN_KEY));
    public static final RegistryKey<EntityType<?>> DARK_ZOMBIE_KEY=RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Defiance.MOD_ID,"dark_zombie"));
    public static final EntityType<DarkZombieEntity> DARK_ZOMBIE=Registry.register(Registries.ENTITY_TYPE,DARK_ZOMBIE_KEY,EntityType.Builder.create(DarkZombieEntity::new,SpawnGroup.MONSTER).dimensions(0.6f,2.9f).build(DARK_ZOMBIE_KEY));
    public static final RegistryKey<EntityType<?>> WALKER_KEY=RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Defiance.MOD_ID,"walker"));
    public static final EntityType<WalkerEntity> WALKER=Registry.register(Registries.ENTITY_TYPE,WALKER_KEY,EntityType.Builder.create(WalkerEntity::new,SpawnGroup.MONSTER).dimensions(0.6f,2.9f).build(WALKER_KEY));
    public static final RegistryKey<EntityType<?>> LASER_TURRET_KEY=RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Defiance.MOD_ID,"laser_turret"));
    public static final EntityType<LaserTurretEntity> LASER_TURRET=Registry.register(Registries.ENTITY_TYPE,WALKER_KEY,EntityType.Builder.create(LaserTurretEntity::new,SpawnGroup.CREATURE).dimensions(0.6f,2.9f).build(LASER_TURRET_KEY));
    public static void registerEntities() {
        Defiance.LOGGER.info("Registering Entities for " + Defiance.MOD_ID);
    };
};