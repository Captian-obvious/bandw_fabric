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
import net.minecraft.util.Identifier;

public class ModItems {
    //public static final ToolMaterial INFINITE_SORROW_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22);
    public static final Item light_shard=new Item(new Item.Settings().maxCount(64));
    public static final Item burnt_flesh=new Item(new Item.Settings().maxCount(64));
    public static final Item dark_bone=new Item(new Item.Settings().maxCount(64));
    public static final Item dark_shard=new Item(new Item.Settings().maxCount(64));
    public static final Item dark_spider_eye=new Item(new Item.Settings().maxCount(63));
    public static final SwordItem blade_of_infinite_sorrow=new BladeOfInfiniteSorrow(ToolMaterial.DIAMOND,15,-2.4F,new Item.Settings().group(ItemGroup.COMBAT));
    public void initialize(){
        System.out.println("Mod Items Initialized!");
        registerItems();
    };
    public static Item register(Item item,String id){
        RegistryKey<Item> key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,id));
        return Registry.register(Registries.ITEM,key.getValue(),item);
    };
    public static void registerItems(){
        register(blade_of_infinite_sorrow,"blade_of_infinite_sorrow");
        register(light_shard,"light_shard");
        register(burnt_flesh,"dark_rotten_flesh");
        register(dark_bone,"dark_bone");
        register(dark_spider_eye,"dark_spider_eye");
        register(dark_shard,"dark_shard");
    };
};