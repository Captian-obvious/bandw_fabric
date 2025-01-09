package com.bandw.registry;

import com.bandw.Main;
import com.bandw.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.block.entity.BlockEntityType;

public class ModBlocks {
    public static final Block DARK_BRICKS = new DarkBricksBlock();
    public static final Block LIGHT_BRICKS = new LightBricksBlock();
    public static final Block DARK_LOG = new DarkLogBlock();
    public static final Block DARK_BARK = new DarkBarkBlock();
    public static final Block LIGHT_CHISELED_BRICKS = new LightChiseledBricksBlock();
    public static final Block LIGHT_PLANKS = new LightPlanksBlock();
    public static final Block SHIELD_OF_LIGHT_BLOCK = new ShieldOfLightBlock(FabricBlockSettings.of(Material.STONE).strength(4.0F, 12.0F));
    public static BlockEntityType<ShieldBlockEntity> SHIELD_OF_LIGHT_BLOCK_ENTITY;
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Ensure block and name are not null
        if (block == null || name == null) {
            throw new IllegalArgumentException("Block and name must not be null");
        };
        // Create the identifier for the block
        Identifier id = Identifier.of(Main.MOD_ID,name);
        // Register the block item if needed
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        };
        // Register the block
        return Registry.register(Registries.BLOCK, id, block);
    };
    public static void registerBlocks() {
        register(DARK_BRICKS,"dark_bricks",true);
        register(LIGHT_BRICKS,"light_bricks",true);
        register(DARK_LOG,"dark_log",true);
        register(DARK_BARK,"dark_bark",true);
        register(LIGHT_CHISELED_BRICKS,"light_chiseled_bricks",true);
        register(LIGHT_PLANKS,"light_planks",true);
        register(SHIELD_OF_LIGHT_BLOCK,"shield_of_light",true);
    };
    public static void registerBlockEntities() {
        SHIELD_OF_LIGHT_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(Main.MOD_ID, "shield_of_light_block_entity"),
            FabricBlockEntityTypeBuilder.create(ShieldBlockEntity::new, SHIELD_OF_LIGHT_BLOCK).build()
        );
    };
};