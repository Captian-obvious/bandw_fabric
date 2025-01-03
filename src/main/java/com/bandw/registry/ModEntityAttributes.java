package com.bandw.registry;

import com.bandw.entities;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;

public class ModEntityAttributes {
    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.DARK_ENDERMAN, entities.DarkEndermanEntity.createEndermanAttributes());
    };
};