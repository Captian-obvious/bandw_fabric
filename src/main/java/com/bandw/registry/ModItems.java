package com.bandw.registry;

import com.bandw.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
public class ModItems {
    public static final Item DARK_ENDERMAN_SPAWN_EGG = new SpawnEggItem(ModEntities.DARK_ENDERMAN, 0x000000, 0xFFFFFF, new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DARK_BRICKS_ITEM = new BlockItem(ModBlocks.DARK_BRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item LIGHT_BRICKS_ITEM = new BlockItem(ModBlocks.LIGHT_BRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item DARK_LOG_ITEM = new BlockItem(ModBlocks.DARK_LOG, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item DARK_BARK_ITEM = new BlockItem(ModBlocks.DARK_BARK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item LIGHT_CHISELED_BRICKS_ITEM = new BlockItem(ModBlocks.LIGHT_CHISELED_BRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item LIGHT_PLANKS_ITEM = new BlockItem(ModBlocks.LIGHT_PLANKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SHIELD_OF_LIGHT_ITEM = new BlockItem(ModBlocks.SHIELD_OF_LIGHT_BLOCK, new FabricItemSettings().group(ItemGroup.MISC));
    public static void registerItems() {
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "dark_enderman_spawn_egg"), DARK_ENDERMAN_SPAWN_EGG);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "dark_bricks"), DARK_BRICKS_ITEM);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "light_bricks"), LIGHT_BRICKS_ITEM);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "dark_log"), DARK_LOG_ITEM);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "dark_bark"), DARK_BARK_ITEM);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "light_chiseled_bricks"), LIGHT_CHISELED_BRICKS_ITEM);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "light_planks"), LIGHT_PLANKS_ITEM);
        Registry.register(Registry.ITEM, Identifier.of(Main.MOD_ID, "shield_of_light"), SHIELD_OF_LIGHT_ITEM);
    };
};
