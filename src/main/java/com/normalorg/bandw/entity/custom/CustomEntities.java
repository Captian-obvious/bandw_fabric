package com.normalorg.bandw.entity.custom;

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

public class CustomEntities {
    public static final RegistryKey<EntityType<?>> DIVINITY_CROSSHAIR_KEY=RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Defiance.MOD_ID,"divinty_crosshair"));
    public static final EntityType<DivinityCrosshairEntity> DIVINITY_CROSSHAIR=Registry.register(Registries.ENTITY_TYPE,DIVINITY_CROSSHAIR_KEY,EntityType.Builder.create(DivinityCrosshairEntity::new,SpawnGroup.AMBIENT).dimensions(0.6f,2.9f).build(DIVINITY_CROSSHAIR_KEY));
    public static void registerCustomEntities() {
        Defiance.LOGGER.info("Registering Custom Entities for " + Defiance.MOD_ID);
    };
};
