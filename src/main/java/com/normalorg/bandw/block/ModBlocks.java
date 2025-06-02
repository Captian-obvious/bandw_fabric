package com.normalorg.bandw.block;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.block.entity.ShieldBlockEntity;
import com.normalorg.bandw.util.CorruptionManager;
import java.util.function.Function;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.FallingBlock;
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

public class ModBlocks {
    public static final CorruptionManager corruptionManager=new CorruptionManager();
    public static final RegistryKey<Block> DARK_BRICKS_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"dark_bricks"));
    public static final Block DARK_BRICKS = new Block(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F).registryKey(DARK_BRICKS_KEY));
    public static final RegistryKey<Block> DARK_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"dark_log"));
    public static final PillarBlock DARK_LOG = new PillarBlock(Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F).registryKey(DARK_LOG_KEY));
    public static final RegistryKey<Block> DEAD_DARK_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"dead_dark_log"));
    public static final PillarBlock DEAD_DARK_LOG = new PillarBlock(Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F).registryKey(DEAD_DARK_LOG_KEY));
    public static final RegistryKey<Block> DARK_BARK_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"dark_bark"));
    public static final Block DARK_BARK = new Block(Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F).registryKey(DARK_BARK_KEY));
    public static final RegistryKey<Block> LIGHT_BRICKS_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"light_bricks"));
    public static final Block LIGHT_BRICKS = new Block(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F).registryKey(LIGHT_BRICKS_KEY));
    public static final RegistryKey<Block> LIGHT_CHISELED_BRICKS_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"light_chiseled_bricks"));
    public static final Block LIGHT_CHISELED_BRICKS = new Block(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F).registryKey(LIGHT_CHISELED_BRICKS_KEY));
    public static final RegistryKey<Block> CRACKED_LIGHT_BRICKS_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"cracked_light_bricks"));
    public static final Block CRACKED_LIGHT_BRICKS = new Block(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F).registryKey(CRACKED_LIGHT_BRICKS_KEY));
    public static final RegistryKey<Block> LIGHT_PLANKS_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"light_planks"));
    public static final Block LIGHT_PLANKS = new Block(Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F).registryKey(LIGHT_PLANKS_KEY));
    public static final RegistryKey<Block> CORRUPTED_STONE_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"corrupted_stone"));
    public static final Block CORRUPTED_STONE = new Block(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F).registryKey(CORRUPTED_STONE_KEY));
    public static final RegistryKey<Block> CORRUPTED_COBBLESTONE_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"corrupted_cobblestone"));
    public static final Block CORRUPTED_COBBLESTONE = new Block(Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0F, 3.0F).registryKey(CORRUPTED_COBBLESTONE_KEY));
    public static final RegistryKey<Block> CONDENSED_CORRUPTION_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"condensed_corruption"));
    public static final Block CONDENSED_CORRUPTION = new CondensedCorruptionBlock(Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F).registryKey(CONDENSED_CORRUPTION_KEY));
    public static final RegistryKey<Block> CORRUPTED_DIRT_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"corrupted_dirt"));
    public static final Block CORRUPTED_DIRT = new Block(Settings.create().sounds(BlockSoundGroup.GRAVEL).strength(2.0F, 1.0F).registryKey(CORRUPTED_DIRT_KEY));
    public static final RegistryKey<Block> CORRUPTED_GRASS_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"corrupted_grass_block"));
    public static final Block CORRUPTED_GRASS_BLOCK = new CorruptedGrassBlock(Settings.create().sounds(BlockSoundGroup.GRASS).strength(2.0F, 1.0F).registryKey(CORRUPTED_GRASS_BLOCK_KEY));
    public static final RegistryKey<Block> SHIELD_OF_LIGHT_KEY = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(Defiance.MOD_ID,"shield_of_light"));
    public static final Block SHIELD_OF_LIGHT_BLOCK = new ShieldOfLightBlock(Settings.create().sounds(BlockSoundGroup.STONE).strength(4.0F, 12.0F).registryKey(SHIELD_OF_LIGHT_KEY));
    private static RegistryKey<Block> keyOfBlock(String name){
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Defiance.MOD_ID, name));
    };
    private static RegistryKey<Item> keyOfItem(String name){
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, name));
    };
    private static Block register_new(String name,Function<Settings, Block> blockFactory,Settings settings,boolean shouldRegisterItem){
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
    public static Block register(Block block, RegistryKey key, boolean shouldRegisterItem) {
        // Ensure block and name are not null
        if (block == null || key == null) {
            throw new IllegalArgumentException("Block and key must not be null");
        };
        // Create the key for the block
        // Register the block item if needed
        if (shouldRegisterItem) {
            RegistryKey<Item> itemkey=RegistryKey.of(RegistryKeys.ITEM,key.getValue());
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemkey));
            Registry.register(Registries.ITEM, itemkey, blockItem);
        };
        // Register the block
        return Registry.register(Registries.BLOCK, key, block);
    };
    public static void registerBlocks() {
        Defiance.LOGGER.info("Registering blocks...");
        register(DARK_BRICKS,DARK_BRICKS_KEY,true);
        register(DARK_LOG,DARK_LOG_KEY,true);
        register(DEAD_DARK_LOG,DEAD_DARK_LOG_KEY,true);
        register(DARK_BARK,DARK_BARK_KEY,true);
        register(LIGHT_BRICKS,LIGHT_BRICKS_KEY,true);
        register(LIGHT_CHISELED_BRICKS,LIGHT_CHISELED_BRICKS_KEY,true);
        register(CRACKED_LIGHT_BRICKS,CRACKED_LIGHT_BRICKS_KEY,true);
        register(LIGHT_PLANKS,LIGHT_PLANKS_KEY,true);
        register(CORRUPTED_COBBLESTONE,CORRUPTED_COBBLESTONE_KEY,true);
        register(CORRUPTED_STONE,CORRUPTED_STONE_KEY,true);
        register(CONDENSED_CORRUPTION,CONDENSED_CORRUPTION_KEY,true);
        register(CORRUPTED_DIRT,CORRUPTED_DIRT_KEY,true);
        register(CORRUPTED_GRASS_BLOCK,CORRUPTED_GRASS_BLOCK_KEY,true);
        register(SHIELD_OF_LIGHT_BLOCK,SHIELD_OF_LIGHT_KEY,true);
    };
    public static void registerCorruptableBlocks(){
        Defiance.LOGGER.info("Setting up CorruptionManager...");
        // will eventually fix the falling blocks but for now they no more
        corruptionManager.addReplacement(Blocks.DIRT,CORRUPTED_DIRT);
        corruptionManager.addReplacement(Blocks.STONE,CORRUPTED_STONE);
        corruptionManager.addReplacement(Blocks.COBBLESTONE,CORRUPTED_COBBLESTONE);
        corruptionManager.addReplacement(Blocks.GRASS_BLOCK,CORRUPTED_GRASS_BLOCK);
        corruptionManager.addReplacement(LIGHT_BRICKS,DARK_BRICKS);
    };
    /*public static void registerBlockEntities() {
        SHIELD_OF_LIGHT_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,Identifier.of(Defiance.MOD_ID, "shield_of_light_block_entity"),FabricBlockEntityTypeBuilder.create(ShieldBlockEntity::new, SHIELD_OF_LIGHT_BLOCK).build()
        );
    };*/
};