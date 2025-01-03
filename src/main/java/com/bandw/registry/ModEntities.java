package com.bandw.registry;

import com.bandw.entities;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<DarkEndermanEntity> DARK_ENDERMAN = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("bandw", "dark_enderman"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, entities.DarkEndermanEntity::new)
            .dimensions(EntityDimensions.fixed(0.6F, 2.9F)) // Adjust dimensions as needed
            .build()
    );
    public static void registerEntities() {
        System.out.println("Entities registered");
    };
};