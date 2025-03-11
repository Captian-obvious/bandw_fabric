package com.bandw.registry;

// Imports go below here
import com.bandw.Main;
import com.bandw.items.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModItems {
    //l
    //public static final ToolMaterial INFINITE_SORROW_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22);
    public static final RegistryKey<ItemGroup> bandw_group_key = RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Main.MOD_ID, "item_group"));
    public static final ItemGroup bandw_group=FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.dark_bone)).displayName(Text.translatable("itemGroup.bandw")).build();
    public static final RegistryKey<Item> light_shard_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"light_shard"));
    public static final Item light_shard=new Item(new Item.Settings().maxCount(64).registryKey(light_shard_key));
    public static final RegistryKey<Item> burnt_flesh_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_rotten_flesh"));
    public static final ConsumableComponent dark_rotten_flesh_consumable_component=ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.DARKENING,80,1),1.0f)).build();
    public static final FoodComponent dark_rotten_flesh_food_component=new FoodComponent.Builder().build();
    public static final Item burnt_flesh=new Item(new Item.Settings().maxCount(64).registryKey(burnt_flesh_key));
    //.food(dark_rotten_flesh_food_component,dark_rotten_flesh_consumable_component)
    public static final RegistryKey<Item> dark_bone_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_bone"));
    public static final Item dark_bone=new Item(new Item.Settings().maxCount(64).registryKey(dark_bone_key));
    public static final RegistryKey<Item> dark_shard_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_shard"));
    public static final Item dark_shard=new Item(new Item.Settings().maxCount(64).registryKey(dark_shard_key));
    public static final RegistryKey<Item> dark_spider_eye_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_spider_eye"));
    public static final Item dark_spider_eye=new Item(new Item.Settings().maxCount(63).registryKey(dark_spider_eye_key));
    public static final RegistryKey<Item> dark_string_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_string"));
    public static final Item dark_string=new Item(new Item.Settings().maxCount(64).registryKey(dark_string_key));
    public static final RegistryKey<Item> mark_of_the_banished_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"mark_of_the_banished"));
    public static final Item mark_of_the_banished=new MarkOfTheBanished(new Item.Settings().maxCount(1).registryKey(mark_of_the_banished_key));
    public static final RegistryKey<Item> mark_of_the_guardian_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"mark_of_the_guardian"));
    public static final Item mark_of_the_guardian=new MarkOfTheGuardian(new Item.Settings().maxCount(1).registryKey(mark_of_the_guardian_key));
    public static final RegistryKey<Item> dark_ender_pearl_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"dark_ender_pearl"));
    public static final EnderPearlItem dark_ender_pearl=new DarkEnderPearl(new Item.Settings().maxCount(1).registryKey(dark_ender_pearl_key));
    public static final RegistryKey<Item> blade_of_infinite_sorrow_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"blade_of_infinite_sorrow"));
    public static final SwordItem blade_of_infinite_sorrow=new BladeOfInfiniteSorrow(ToolMaterial.DIAMOND,15,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_infinite_sorrow_key));
    public static final RegistryKey<Item> halfshade_blade_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"halfshade_blade"));
    public static final SwordItem halfshade_blade=new HalfshadeBlade(ToolMaterial.DIAMOND,6,-2.4F,new Item.Settings().enchantable(10).registryKey(halfshade_blade_key));
    public static final RegistryKey<Item> blade_of_light_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"blade_of_light"));
    public static final SwordItem blade_of_light=new BladeOfLight(ToolMaterial.DIAMOND,6,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_light_key));
    public static final RegistryKey<Item> blade_of_karma_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,"blade_of_karma"));
    public static final SwordItem blade_of_karma=new BladeOfKarma(ToolMaterial.DIAMOND,10,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_karma_key));
    public static void initialize(){
        System.out.println("Mod Items Initialized!");
        registerItems();
    };
	/*public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Main.MOD_ID,name));
		// Create the item instance.
		Item item=itemFactory.apply(settings.registryKey(itemKey));
		// Register the item.
		Registry.register(Registries.ITEM,itemKey,item);
		return item;
	};*/
    public static Item register(Item item,RegistryKey key){
        return Registry.register(Registries.ITEM,key,item);
    };
    public static void registerItems(){
        Registry.register(Registries.ITEM_GROUP,bandw_group_key,bandw_group);
        register(blade_of_infinite_sorrow,blade_of_infinite_sorrow_key);
        register(blade_of_karma,blade_of_karma_key);
        register(blade_of_light,blade_of_light_key);
        register(halfshade_blade,halfshade_blade_key);
        register(light_shard,light_shard_key);
        register(burnt_flesh,burnt_flesh_key);
        register(dark_bone,dark_bone_key);
        register(dark_spider_eye,dark_spider_eye_key);
        register(dark_string,dark_string_key);
        register(mark_of_the_banished,mark_of_the_banished_key);
        register(mark_of_the_guardian,mark_of_the_guardian_key);
        register(dark_ender_pearl,dark_ender_pearl_key);
        register(dark_shard,dark_shard_key);
        Main.LOGGER.info("Registering Item Group Contents");
        ItemGroupEvents.modifyEntriesEvent(bandw_group_key).register(itemGroup -> {
            itemGroup.add(ModItems.blade_of_infinite_sorrow);
            itemGroup.add(ModItems.halfshade_blade);
            itemGroup.add(ModItems.blade_of_karma);
            itemGroup.add(ModItems.blade_of_light);
            itemGroup.add(ModItems.mark_of_the_banished);
            itemGroup.add(ModItems.mark_of_the_guardian);
            itemGroup.add(ModItems.dark_ender_pearl);
            itemGroup.add(ModItems.light_shard);
            itemGroup.add(ModItems.burnt_flesh);
            itemGroup.add(ModItems.dark_bone);
            itemGroup.add(ModItems.dark_spider_eye);
            itemGroup.add(ModItems.dark_string);
            itemGroup.add(ModItems.dark_shard);
            itemGroup.add(ModBlocks.DARK_LOG.asItem());
            itemGroup.add(ModBlocks.DARK_BARK.asItem());
            itemGroup.add(ModBlocks.DARK_BRICKS.asItem());
            itemGroup.add(ModBlocks.LIGHT_PLANKS.asItem());
            itemGroup.add(ModBlocks.LIGHT_BRICKS.asItem());
            itemGroup.add(ModBlocks.SHIELD_OF_LIGHT_BLOCK.asItem());
            itemGroup.add(ModBlocks.LIGHT_CHISELED_BRICKS.asItem());
        });
    };
};