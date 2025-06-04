package com.normalorg.bandw.item;

// Imports
import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.item.tec.TecItems;
import com.normalorg.bandw.block.ModBlocks;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.normalorg.bandw.component.ModComponents;
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
import net.minecraft.block.Block;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModItems {
    //public static final ToolMaterial INFINITE_SORROW_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22);
    public static final RegistryKey<ItemGroup> bandw_items_group_key = RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Defiance.MOD_ID, "bandw_items"));
    public static final ItemGroup bandw_items_group=FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.dark_bone)).displayName(Text.translatable("itemGroup.bandw_items")).build();
    public static final RegistryKey<ItemGroup> bandw_blocks_group_key = RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Defiance.MOD_ID, "bandw_blocks"));
    public static final ItemGroup bandw_blocks_group=FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CORRUPTED_GRASS_BLOCK.asItem())).displayName(Text.translatable("itemGroup.bandw_blocks")).build();
    public static final RegistryKey<ItemGroup> bandw_tec_group_key = RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Defiance.MOD_ID, "bandw_tec"));
    public static final ItemGroup bandw_tec_group=FabricItemGroup.builder().icon(() -> new ItemStack(TecItems.TEC_DUST)).displayName(Text.translatable("itemGroup.bandw_tec")).build();
    public static final RegistryKey<Item> raw_light_ore_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"raw_light_ore"));
    public static final Item raw_light_ore=new Item(new Item.Settings().maxCount(64).registryKey(raw_light_ore_key));
    public static final RegistryKey<Item> light_shard_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"light_shard"));
    public static final Item light_shard=new Item(new Item.Settings().maxCount(64).registryKey(light_shard_key));
    public static final RegistryKey<Item> light_iron_ingot_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"light_iron_ingot"));
    public static final Item light_iron_ingot=new Item(new Item.Settings().maxCount(64).registryKey(light_iron_ingot_key));
    public static final RegistryKey<Item> light_stick_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"light_stick"));
    public static final Item light_stick=new Item(new Item.Settings().maxCount(64).registryKey(light_stick_key));
    public static final RegistryKey<Item> light_rod_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"light_rod"));
    public static final Item light_rod=new Item(new Item.Settings().maxCount(64).registryKey(light_rod_key));
    public static final RegistryKey<Item> burnt_flesh_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_rotten_flesh"));
    public static final ConsumableComponent dark_rotten_flesh_consumable_component=ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.DARKENING,80,1),1.0f)).build();
    public static final FoodComponent dark_rotten_flesh_food_component=new FoodComponent.Builder().build();
    public static final Item burnt_flesh=new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().nutrition(2).saturationModifier(2.0f).build()).registryKey(burnt_flesh_key));
    //.food(dark_rotten_flesh_food_component,dark_rotten_flesh_consumable_component)
    public static final RegistryKey<Item> dark_bone_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_bone"));
    public static final Item dark_bone=new Item(new Item.Settings().maxCount(64).registryKey(dark_bone_key));
    public static final RegistryKey<Item> dark_bonemeal_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_bonemeal"));
    public static final Item dark_bonemeal=new Item(new Item.Settings().maxCount(64).registryKey(dark_bonemeal_key));
    public static final RegistryKey<Item> dark_shard_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_shard"));
    public static final Item dark_shard=new Item(new Item.Settings().maxCount(64).registryKey(dark_shard_key));
    public static final RegistryKey<Item> dark_spider_eye_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_spider_eye"));
    public static final Item dark_spider_eye=new Item(new Item.Settings().maxCount(63).registryKey(dark_spider_eye_key));
    public static final RegistryKey<Item> dark_pouch_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_pouch"));
    public static final Item dark_pouch=new Item(new Item.Settings().maxCount(63).registryKey(dark_pouch_key));
    public static final RegistryKey<Item> dark_string_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_string"));
    public static final Item dark_string=new Item(new Item.Settings().maxCount(64).registryKey(dark_string_key));
    public static final RegistryKey<Item> dark_leather_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_leather"));
    public static final Item dark_leather=new Item(new Item.Settings().maxCount(64).registryKey(dark_leather_key));
    public static final RegistryKey<Item> halfshade_ingot_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"halfshade_ingot"));
    public static final Item halfshade_ingot=new HalfshadeIngot(new Item.Settings().maxCount(64).registryKey(halfshade_ingot_key));
    public static final RegistryKey<Item> halfshade_nugget_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"halfshade_nugget"));
    public static final Item halfshade_nugget=new Item(new Item.Settings().maxCount(64).registryKey(halfshade_nugget_key));
    public static final RegistryKey<Item> halfshade_stick_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"halfshade_stick"));
    public static final Item halfshade_stick=new Item(new Item.Settings().maxCount(64).registryKey(halfshade_stick_key));
    public static final RegistryKey<Item> mark_of_the_banished_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"banished_mark"));
    public static final Item mark_of_the_banished=new MarkOfTheBanished(new Item.Settings().maxCount(1).registryKey(mark_of_the_banished_key));
    public static final RegistryKey<Item> reality_warper_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"reality_warper"));
    public static final Item reality_warper=new RealityWarper(new Item.Settings().maxCount(1).registryKey(reality_warper_key));
    public static final RegistryKey<Item> mark_of_the_guardian_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"guardian_mark"));
    public static final Item mark_of_the_guardian=new MarkOfTheGuardian(new Item.Settings().maxCount(1).registryKey(mark_of_the_guardian_key));
    public static final RegistryKey<Item> dark_ender_pearl_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"dark_ender_pearl"));
    public static final EnderPearlItem dark_ender_pearl=new DarkEnderPearl(new Item.Settings().maxCount(1).registryKey(dark_ender_pearl_key));
    public static final RegistryKey<Item> blade_of_infinite_sorrow_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"blade_of_infinite_sorrow"));
    public static final SwordItem blade_of_infinite_sorrow=new BladeOfInfiniteSorrow(ToolMaterial.DIAMOND,15,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_infinite_sorrow_key));
    public static final RegistryKey<Item> halfshade_blade_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"halfshade_blade"));
    public static final SwordItem halfshade_blade=new HalfshadeBlade(ToolMaterial.DIAMOND,6,-2.4F,new Item.Settings().enchantable(10).registryKey(halfshade_blade_key));
    public static final RegistryKey<Item> blade_of_light_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"blade_of_light"));
    public static final SwordItem blade_of_light=new BladeOfLight(ToolMaterial.DIAMOND,6,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_light_key));
    public static final RegistryKey<Item> blade_of_darkness_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"blade_of_darkness"));
    public static final SwordItem blade_of_darkness=new BladeOfDarkness(ToolMaterial.DIAMOND,6,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_darkness_key));
    public static final RegistryKey<Item> blade_of_karma_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"blade_of_karma"));
    public static final SwordItem blade_of_karma=new BladeOfKarma(ToolMaterial.DIAMOND,10,-2.4F,new Item.Settings().enchantable(10).registryKey(blade_of_karma_key));
    public static final RegistryKey<Item> casshen_key=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,"casshen"));
    public static final SwordItem casshen=new Casshen(ToolMaterial.DIAMOND,10,-2.4F,new Item.Settings().enchantable(10).component(ModComponents.CHARGE_COMPONENT,0).registryKey(casshen_key));
    public static void initialize(){
        System.out.println("Mod Items Initialized!");
        registerItems();
    };
    /*public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,name));
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
        Defiance.LOGGER.info("Registering items...");
        Registry.register(Registries.ITEM_GROUP,bandw_items_group_key,bandw_items_group);
        Registry.register(Registries.ITEM_GROUP,bandw_blocks_group_key,bandw_blocks_group);
        Registry.register(Registries.ITEM_GROUP,bandw_tec_group_key,bandw_tec_group);
        register(blade_of_infinite_sorrow,blade_of_infinite_sorrow_key);
        register(casshen,casshen_key);
        register(blade_of_karma,blade_of_karma_key);
        register(blade_of_light,blade_of_light_key);
        register(blade_of_darkness,blade_of_darkness_key);
        register(halfshade_blade,halfshade_blade_key);
        register(halfshade_stick,halfshade_stick_key);
        register(light_stick,light_stick_key);
        register(light_rod,light_rod_key);
        register(light_shard,light_shard_key);
        register(light_iron_ingot,light_iron_ingot_key);
        register(raw_light_ore,raw_light_ore_key);
        register(burnt_flesh,burnt_flesh_key);
        register(dark_bone,dark_bone_key);
        register(dark_spider_eye,dark_spider_eye_key);
        register(dark_string,dark_string_key);
        register(dark_bonemeal,dark_bonemeal_key);
        register(dark_pouch,dark_pouch_key);
        register(dark_leather,dark_leather_key);
        register(halfshade_ingot,halfshade_ingot_key);
        register(halfshade_nugget,halfshade_nugget_key);
        register(mark_of_the_banished,mark_of_the_banished_key);
        register(reality_warper,reality_warper_key);
        register(mark_of_the_guardian,mark_of_the_guardian_key);
        register(dark_ender_pearl,dark_ender_pearl_key);
        register(dark_shard,dark_shard_key);
        TecItems.registerTecItems();
        Defiance.LOGGER.info("Registering Item Group Contents...");
        Block[] blocks={
            ModBlocks.DARK_LOG,
            ModBlocks.DEAD_DARK_LOG,
            ModBlocks.DARK_BARK,
            ModBlocks.DARK_BRICKS,
            ModBlocks.LIGHT_PLANKS,
            ModBlocks.LIGHT_BRICKS,
            ModBlocks.LIGHT_CHISELED_BRICKS,
            ModBlocks.CRACKED_LIGHT_BRICKS,
            ModBlocks.CORRUPTED_COBBLESTONE,
            ModBlocks.CORRUPTED_STONE,
            ModBlocks.CONDENSED_CORRUPTION,
            ModBlocks.CORRUPTED_DIRT,
            ModBlocks.CORRUPTED_GRASS_BLOCK,
            ModBlocks.SHIELD_OF_LIGHT_BLOCK
        };
        Item[] items={
            ModItems.blade_of_infinite_sorrow,
            ModItems.halfshade_blade,
            ModItems.casshen,
            ModItems.blade_of_karma,
            ModItems.blade_of_light,
            ModItems.blade_of_darkness,
            ModItems.mark_of_the_banished,
            ModItems.reality_warper,
            ModItems.mark_of_the_guardian,
            ModItems.dark_ender_pearl,
            ModItems.halfshade_ingot,
            ModItems.halfshade_nugget,
            ModItems.halfshade_stick,
            ModItems.light_stick,
            ModItems.light_rod,
            ModItems.light_shard,
            ModItems.light_iron_ingot,
            ModItems.raw_light_ore,
            ModItems.burnt_flesh,
            ModItems.dark_bone,
            ModItems.dark_bonemeal,
            ModItems.dark_pouch,
            ModItems.dark_spider_eye,
            ModItems.dark_string,
            ModItems.dark_leather,
            ModItems.dark_shard
        };
        Item[] tec_items={
            TecItems.TEC_DUST
        };
        ItemGroupEvents.modifyEntriesEvent(bandw_items_group_key).register(itemGroup -> {
            for (Item item : items) {
                itemGroup.add(item);
            };
        });
        ItemGroupEvents.modifyEntriesEvent(bandw_tec_group_key).register(itemGroup -> {
            for (Item item : tec_items) {
                itemGroup.add(item);
            };
        });
        ItemGroupEvents.modifyEntriesEvent(bandw_blocks_group_key).register(itemGroup -> {
            for (Block block : blocks) {
                itemGroup.add(block.asItem());
            };
        });
    };
};