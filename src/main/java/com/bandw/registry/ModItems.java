package com.bandw.registry;

import com.bandw.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
public class ModItems {
    public static final Item DARK_ENDERMAN_SPAWN_EGG = new SpawnEggItem(ModEntities.DARK_ENDERMAN, 0x000000, 0xFFFFFF, new FabricItemSettings().group(ItemGroup.MISC));
    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier("mymod", id);
        return Registry.register(Registries.ITEM, itemID, item);
    };
    public static void registerItems()
        register(DARK_ENDERMAN_SPAWN_EGG, "dark_enderman_spawn_egg");
    };
};
