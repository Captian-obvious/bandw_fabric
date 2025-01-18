package com.bandw.registry;

import com.bandw.Main;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class ModItems() {
    public static final Item burnt_flesh=new Item(new Item.Settings().maxCount(64));
    public static final Item dark_bone=new Item(new Item.Settings().maxCount(64));
    public static final Item dark_spider_eye=new Item(new Item.Settings().maxCount(63));
    public static final Item DARK_ENDERMAN_SPAWN_EGG = new SpawnEggItem(ModEntities.DARK_ENDERMAN, 0x000000, 0xFFFFFF, new Item.Settings().maxCount(64));
    public void initialize(){
        System.out.println("Mod Items Initialized!");
        registerItems();
    };
    public static Item register(Item item,String id){
        RegistryKey<Item> key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,id));
        return Registry.register(Registries.ITEM,key.getValue(),item);
    };
    public static void registerItems(){
        register(burnt_flesh,"dark_rotten_flesh");
        register(dark_bone,"dark_bone");
        register(dark_spider_eye,"dark_spider_eye");
        register(DARK_ENDERMAN_SPAWN_EGG, "dark_enderman_spawn_egg");
    };
};