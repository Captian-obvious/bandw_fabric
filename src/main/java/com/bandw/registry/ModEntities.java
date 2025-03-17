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

public class ModEntities {
    public static final EntityType<DarkEndermanEntity> DARK_ENDERMAN=Registry.register(Registries.ENTITY_TYPE,Identifier.of(Main.MOD_ID, "dark_enderman"),EntityType.Builder.create(DarkEndermanEntity::new,SpawnGroup.CREATURE).dimensions(0.6f,2.9f).build("dark_enderman"));
    public static void registerEntities() {
        Main.LOGGER.info("Registering Entities...");
    };
};
