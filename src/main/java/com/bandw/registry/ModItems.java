package com.bandw.registry;

// Imports go below here
import com.bandw.Main;
import com.bandw.items.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;

public class ModItems {
    //public static final ToolMaterial INFINITE_SORROW_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22);
    public static final RegistryKey<Item> light_shard_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"light_shard"));
    public static final Item light_shard=new Item(new Item.Settings().maxCount(64).registryKey(light_shard_key));
    public static final RegistryKey<Item> burnt_flesh_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_rotten_flesh"));
    public static final Item burnt_flesh=new Item(new Item.Settings().maxCount(64).registryKey(burnt_flesh_key));
    public static final RegistryKey<Item> dark_bone_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_bone"));
    public static final Item dark_bone=new Item(new Item.Settings().maxCount(64).registryKey(dark_bone_key));
    public static final RegistryKey<Item> dark_shard_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_shard"));
    public static final Item dark_shard=new Item(new Item.Settings().maxCount(64).registryKey(dark_shard_key));
    public static final RegistryKey<Item> dark_spider_eye_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_spider_eye"));
    public static final Item dark_spider_eye=new Item(new Item.Settings().maxCount(63).registryKey(dark_spider_eye_key));
    public static final RegistryKey<Item> blade_of_infinite_sorrow_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"blade_of_infinite_sorrow"));
    public static final SwordItem blade_of_infinite_sorrow=new BladeOfInfiniteSorrow(ToolMaterial.DIAMOND,15,-2.4F,new Item.Settings().registryKey(blade_of_infinite_sorrow_key));
    public void initialize(){
        System.out.println("Mod Items Initialized!");
        registerItems();
    };
    public static Item register(Item item,RegistryKey key){
        return Registry.register(Registries.ITEM,key,item);
    };
    public static void registerItems(){
        register(blade_of_infinite_sorrow,blade_of_infinite_sorrow_key);
        register(light_shard,light_shard_key);
        register(burnt_flesh,burnt_flesh_key);
        register(dark_bone,dark_bone_key);
        register(dark_spider_eye,dark_spider_eye_key);
        register(dark_shard,dark_shard_key);
    };
};
