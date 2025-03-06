package com.bandw.registry;

import com.bandw.Main;
import com.bandw.blocks.*;
import java.util.function.Function;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.AbstractBlock.Settings;

public class ModBlockEntities {
    public static final BlockEntityType<ShieldBlockEntity> SHIELD_BLOCK_ENTITY=register("shield",ShieldBlockEntity::new,ModBlocks.ShieldOfLightBlock);
    private static <T extends BlockEntity> BlockEntityType<T> register(String name,FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,Block... blocks) {
        Identifier id=Identifier.of(Main.MOD_ID,name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,id,FabricBlockEntityTypeBuilder.<T>create(entityFactory,blocks).build());
    };
};