package com.bandw.registry;

import com.bandw.Main;
import com.bandw.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;

public class ModEntityAttributes {
    public static void registerAttributes() {
        Main.LOGGER.info("Registering Entity Attributes...");
        FabricDefaultAttributeRegistry.register(ModEntities.DARK_ENDERMAN,DarkEndermanEntity.createEndermanAttributes());
    };
};
