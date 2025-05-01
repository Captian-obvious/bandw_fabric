package com.normalorg.bandw.entity;

import com.normalorg.bandw.Main;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;

public class ModEntityAttributes {
    public static void registerAttributes() {
        Main.LOGGER.info("Registering Entity Attributes...");
        FabricDefaultAttributeRegistry.register(ModEntities.DARK_ENDERMAN,DarkEndermanEntity.createEndermanAttributes());
    };
};