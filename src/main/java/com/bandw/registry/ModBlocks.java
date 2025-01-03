package com.bandw.registry;

import com.bandw.Main;
import com.bandw.blocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.entity.BlockEntityType;

public class ModBlocks {
    public static final Block DARK_BRICKS = new blocks.DarkBricksBlock();
    public static final Block LIGHT_BRICKS = new blocks.LightBricksBlock();
    public static final Block DARK_LOG = new blocks.DarkLogBlock();
    public static final Block DARK_BARK = new blocks.DarkBarkBlock();
    public static final Block LIGHT_CHISELED_BRICKS = new blocks.LightChiseledBricksBlock();
    public static final Block LIGHT_PLANKS = new blocks.LightPlanksBlock();
    public static final Block SHIELD_OF_LIGHT_BLOCK = new block.ShieldOfLightBlock(FabricBlockSettings.of(Material.STONE).strength(4.0F, 12.0F));
    public static BlockEntityType<ShieldBlockEntity> SHIELD_OF_LIGHT_BLOCK_ENTITY;
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "dark_bricks"), DARK_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "light_bricks"), LIGHT_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "dark_log"), DARK_LOG);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "dark_bark"), DARK_BARK);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "light_chiseled_bricks"), LIGHT_CHISELED_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "light_planks"), LIGHT_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "shield_of_light"), SHIELD_OF_LIGHT_BLOCK);
    };
    public static void registerBlockEntities() {
        SHIELD_OF_LIGHT_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier("yourmod", "shield_of_light_block_entity"),
            FabricBlockEntityTypeBuilder.create(blocks.ShieldBlockEntity::new, SHIELD_OF_LIGHT_BLOCK).build()
        );
    };
};
