package com.bandw.registry;

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
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("bandw", "dark_enderman_spawn_egg"), DARK_ENDERMAN_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier("bandw", "dark_bricks"), DARK_BRICKS_ITEM);
    }
};
