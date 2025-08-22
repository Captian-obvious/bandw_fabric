package com.normalorg.bandw.block;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.block.entity.ShieldBlockEntity;
import com.normalorg.bandw.registry.CorruptionRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
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
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {
    public static final Block DARK_BRICKS=register("dark_bricks", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block DARK_LOG=register("dark_log", PillarBlock::new, Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F),true);
    public static final Block DEAD_DARK_LOG=register("dead_dark_log", PillarBlock::new, Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F),true);
    public static final Block DARK_BARK=register("dark_bark", Block::new, Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F),true);
    public static final Block PURE_LIGHT_BRICKS=register("pure_light_bricks", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_BRICKS=register("light_bricks", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_BRICK_SLAB=register("light_brick_slab", SlabBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_BRICK_STAIRS=registerStairs("light_brick_stairs", StairsBlock::new,LIGHT_BRICKS.getDefaultState(), Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_BRICK_WALL=register("light_brick_wall", WallBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_CHISELED_BRICKS=register("light_chiseled_bricks", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_DIVINITY_CHISELED_BRICKS=register("light_divinity_chiseled_bricks", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_BRICKS=register("cracked_light_bricks", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_BRICK_SLAB=register("cracked_light_brick_slab", SlabBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_BRICK_STAIRS=registerStairs("cracked_light_brick_stairs", StairsBlock::new,CRACKED_LIGHT_BRICKS.getDefaultState(), Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_BRICK_WALL=register("cracked_light_brick_wall", WallBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_TILES=register("light_tiles", Block::new, Settings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(2.0F, 3.0F),true);
    public static final Block LIGHT_TILE_SLAB=register("light_tile_slab", SlabBlock::new, Settings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(2.0F, 3.0F),true);
    public static final Block LIGHT_TILE_STAIRS=registerStairs("light_tile_stairs", StairsBlock::new, LIGHT_TILES.getDefaultState(), Settings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(2.0F, 3.0F),true);
    public static final Block LIGHT_TILE_WALL=register("light_tile_wall", WallBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_TILES=register("cracked_light_tiles", Block::new, Settings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(2.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_TILE_SLAB=register("cracked_light_tile_slab", SlabBlock::new, Settings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(2.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_TILE_STAIRS=registerStairs("cracked_light_tile_stairs", StairsBlock::new,CRACKED_LIGHT_TILES.getDefaultState(), Settings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(2.0F, 3.0F),true);
    public static final Block CRACKED_LIGHT_TILE_WALL=register("cracked_light_tile_wall", WallBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block LIGHT_PLANKS=register("light_planks", Block::new, Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F),true);
    public static final Block LIGHT_PLANK_SLAB=register("light_plank_slab", SlabBlock::new, Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F),true);
    public static final Block LIGHT_PLANK_STAIRS=registerStairs("light_plank_stairs", StairsBlock::new, LIGHT_PLANKS.getDefaultState(),Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F),true);
    public static final Block LIGHT_IRON_BLOCK=register("light_iron_block", Block::new, Settings.create().sounds(BlockSoundGroup.WOOD).strength(4.0F, 2.0F),true);
    public static final Block PURIFIED_STONE=register("purified_stone", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block PURIFIED_GRAVEL=register("purified_gravel", CustomFallingBlock::new, Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F),true);
    public static final Block PURIFIED_SAND=register("purified_sand", CustomFallingBlock::new, Settings.create().sounds(BlockSoundGroup.SAND).strength(2.0F, 1.0F),true);
    public static final Block PURIFIED_COBBLESTONE=register("purified_cobblestone", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block PURIFIED_DIRT=register("purified_dirt", Block::new, Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F),true);
    public static final Block PURIFIED_GRASS_BLOCK=register("purified_grass_block", PurifiedGrassBlock::new, Settings.create().sounds(BlockSoundGroup.GRASS).strength(2.0F, 1.0F),true);
    public static final Block CORRUPTED_STONE=register("corrupted_stone", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CORRUPTED_GRAVEL=register("corrupted_gravel", CustomFallingBlock::new, Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F),true);
    public static final Block CORRUPTED_SAND=register("corrupted_sand", CustomFallingBlock::new, Settings.create().sounds(BlockSoundGroup.SAND).strength(2.0F, 1.0F),true);
    public static final Block CORRUPTED_COBBLESTONE=register("corrupted_cobblestone", Block::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F),true);
    public static final Block CONDENSED_CORRUPTION=register("condensed_corruption", CondensedCorruptionBlock::new, Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F),true);
    public static final Block CORRUPTED_DIRT=register("corrupted_dirt", Block::new, Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F),true);
    public static final Block CORRUPTED_GRASS_BLOCK=register("corrupted_grass_block", CorruptedGrassBlock::new, Settings.create().sounds(BlockSoundGroup.GRASS).strength(2.0F, 1.0F),true);
    public static final Block SHIELD_OF_LIGHT_BLOCK=register("shield_of_light", ShieldOfLightBlock::new, Settings.create().sounds(BlockSoundGroup.STONE).strength(4.0F, 12.0F),true);
    private static RegistryKey<Block> keyOfBlock(String name){
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Defiance.MOD_ID, name));
    };
    private static RegistryKey<Item> keyOfItem(String name){
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, name));
    };
    private static Block register(String name,Function<Settings, Block> blockFactory,Settings settings,boolean shouldRegisterItem){
        RegistryKey<Block> blockKey=keyOfBlock(name);
        Block block=blockFactory.apply(settings.registryKey(blockKey));
        // Sometimes, you may not want to register an item for the block.
        // // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem){
            RegistryKey<Item> itemKey=keyOfItem(name);
            BlockItem blockItem=new BlockItem(block,new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM,itemKey,blockItem);
        };
        return Registry.register(Registries.BLOCK, blockKey, block);
    };
    private static Block registerStairs(String name,BiFunction<BlockState, Settings, Block> blockFactory,BlockState baseState,Settings settings,boolean shouldRegisterItem){
        RegistryKey<Block> blockKey=keyOfBlock(name);
        Block block=blockFactory.apply(baseState,settings.registryKey(blockKey));
        // Sometimes, you may not want to register an item for the block.
        // // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem){
            RegistryKey<Item> itemKey=keyOfItem(name);
            BlockItem blockItem=new BlockItem(block,new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM,itemKey,blockItem);
        };
        return Registry.register(Registries.BLOCK, blockKey, block);
    };
    private static Block register(Block block, RegistryKey key, boolean shouldRegisterItem) {
        // Ensure block and name are not null
        if (block == null || key == null) {
            throw new IllegalArgumentException("Block and key must not be null");
        };
        // Create the key for the block
        // Register the block item if needed
        if (shouldRegisterItem) {
            RegistryKey<Item> itemkey=RegistryKey.of(RegistryKeys.ITEM,key.getValue());
            BlockItem blockItem=new BlockItem(block, new Item.Settings().registryKey(itemkey));
            Registry.register(Registries.ITEM, itemkey, blockItem);
        };
        // Register the block
        return Registry.register(Registries.BLOCK, key, block);
    };
    public static void registerBlocks() {
        Defiance.LOGGER.info("Registering blocks for " + Defiance.MOD_ID);
    };
    public static void registerCorruptableBlocks(){
        Defiance.LOGGER.info("Setting up CorruptionRegistry...");
        CorruptionRegistry.register(Blocks.DIRT,CORRUPTED_DIRT);
        CorruptionRegistry.register(Blocks.STONE,CORRUPTED_STONE);
        CorruptionRegistry.register(Blocks.GRAVEL,CORRUPTED_GRAVEL);
        CorruptionRegistry.register(Blocks.SAND,CORRUPTED_SAND);
        CorruptionRegistry.register(Blocks.COBBLESTONE,CORRUPTED_COBBLESTONE);
        CorruptionRegistry.register(Blocks.GRASS_BLOCK,CORRUPTED_GRASS_BLOCK);
        CorruptionRegistry.register(Blocks.OAK_LOG,DARK_LOG);
        CorruptionRegistry.register(Blocks.OAK_WOOD,DARK_BARK);
        CorruptionRegistry.register(Blocks.MOSS_BLOCK,CONDENSED_CORRUPTION);
        CorruptionRegistry.register(LIGHT_BRICKS,DARK_BRICKS);
    };
};