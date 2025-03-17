package com.bandw.registry;

import com.bandw.Main;
import com.bandw.entities.*;
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
    public static final RegistryKey<EntityType<DarkEndermanEntity>> DARK_ENDERMAN_KEY=RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Main.MOD_ID,"dark_enderman"));
    public static final EntityType<DarkEndermanEntity> DARK_ENDERMAN=Registry.register(Registries.ENTITY_TYPE,DARK_ENDERMAN_KEY,EntityType.Builder.create(DarkEndermanEntity::new,SpawnGroup.CREATURE).dimensions(0.6f,2.9f).build(DARK_ENDERMAN_KEY));
    public static void registerEntities() {
        Main.LOGGER.info("Registering Entities...");
    };
};
