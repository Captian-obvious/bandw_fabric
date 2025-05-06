package com.normalorg.bandw.world.dimension;

// Imports
import com.normalorg.bandw.Defiance;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import java.util.function.Function;

public class ModDimensions {
    public static final RegistryKey<World> THE_VOID=RegistryKey.of(RegistryKeys.WORLD,Identifier.of(Defiance.MOD_ID,"the_void"));
    public static void registerDimensions(){
        Defiance.LOGGER.info("Registering dimensions...");
    };
};