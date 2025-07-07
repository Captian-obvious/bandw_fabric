package com.normalorg.bandw.world.dimension;

// Imports
import com.normalorg.bandw.Defiance;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import java.util.function.Function;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> THE_VOID_TYPE=RegistryKey.of(RegistryKeys.DIMENSION_TYPE,Identifier.of(Defiance.MOD_ID,"the_void_type"));
    public static void registerDimensionTypes(){
        Defiance.LOGGER.info("Registering dimension types for " + Defiance.MOD_ID);
    };
};