package com.normalorg.bandw.entity.custom;

import com.normalorg.bandw.Defiance;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;

public class CustomEntityAttributes {
    public static void registerCustomAttributes() {
        Defiance.LOGGER.info("Registering Custom Entity Attributes for " + Defiance.MOD_ID);
        FabricDefaultAttributeRegistry.register(CustomEntities.DIVINITY_CROSSHAIR,DivinityCrosshairEntity.createDivinityCrosshairAttributes());
    };
};