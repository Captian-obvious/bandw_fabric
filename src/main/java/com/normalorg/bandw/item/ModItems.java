package com.normalorg.bandw.item;

// Imports
import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.item.tec.TecItems;
import com.normalorg.bandw.item.magic.MagicItems;
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
import net.minecraft.item.BowItem;
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
    //public static final ToolMaterial INFINITE_SORROW_MATERIAL=new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22);
    public static final RegistryKey<ItemGroup> bandw_items_group_key=RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Defiance.MOD_ID, "bandw_items"));
    public static final ItemGroup bandw_items_group=FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DARK_BONE)).displayName(Text.translatable("itemGroup.bandw_items")).build();
    public static final RegistryKey<ItemGroup> bandw_blocks_group_key=RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Defiance.MOD_ID, "bandw_blocks"));
    public static final ItemGroup bandw_blocks_group=FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CORRUPTED_GRASS_BLOCK.asItem())).displayName(Text.translatable("itemGroup.bandw_blocks")).build();
    public static final RegistryKey<ItemGroup> bandw_tec_group_key=RegistryKey.of(Registries.ITEM_GROUP.getKey(),Identifier.of(Defiance.MOD_ID, "bandw_tec"));
    public static final ItemGroup bandw_tec_group=FabricItemGroup.builder().icon(() -> new ItemStack(TecItems.TEC_DUST)).displayName(Text.translatable("itemGroup.bandw_tec")).build();
    public static final Item PURE_DIVINITY=register("pure_divinity",PureDivinity::new,new Item.Settings().maxCount(1));
    public static final Item HALFSHADE_STICK=register("halfshade_stick", Item::new, new Item.Settings().maxCount(64));
    public static final Item LIGHT_STICK=register("light_stick", Item::new, new Item.Settings().maxCount(64));
    public static final Item LIGHT_ROD=register("light_rod", Item::new, new Item.Settings().maxCount(64));
    public static final Item LIGHT_PLATE=register("light_plate", Item::new, new Item.Settings().maxCount(64));
    public static final Item LIGHT_SHARD=register("light_shard", Item::new, new Item.Settings().maxCount(64));
    public static final Item LIGHT_IRON_INGOT=register("light_iron_ingot", Item::new, new Item.Settings().maxCount(64));
    public static final Item RAW_LIGHT_ORE=register("raw_light_ore", Item::new, new Item.Settings().maxCount(64));
    public static final Item BURNT_FLESH=register("dark_rotten_flesh",Item::new,new Item.Settings()
        .maxCount(64)
        .food(new FoodComponent.Builder().nutrition(2).saturationModifier(2.0f).build())
    );
    public static final Item WORM_MEAT=register("worm_meat",WormMeat::new,new Item.Settings()
        .maxCount(64)
        .food(new FoodComponent.Builder().nutrition(5).saturationModifier(10.0f).build())
    );
    public static final Item COOKED_WORM_MEAT=register("cooked_worm_meat",Item::new,new Item.Settings()
        .maxCount(64)
        .food(new FoodComponent.Builder().nutrition(8).saturationModifier(15.0f).build())
    );
    public static final Item DARK_BONE=register("dark_bone", Item::new, new Item.Settings().maxCount(64));
    public static final Item DARK_SPIDER_EYE=register("dark_spider_eye", Item::new, new Item.Settings().maxCount(63));
    public static final Item DARK_SHARD=register("dark_shard",Item::new,new Item.Settings().maxCount(64));
    public static final Item DARK_STRING=register("dark_string", Item::new, new Item.Settings().maxCount(64));
    public static final Item DARK_BONEMEAL=register("dark_bonemeal", Item::new, new Item.Settings().maxCount(64));
    public static final Item DARK_POUCH=register("dark_pouch", DarkPouch::new, new Item.Settings().maxCount(63));
    public static final Item DARK_LEATHER=register("dark_leather", Item::new, new Item.Settings().maxCount(64));
    public static final Item HALFSHADE_INGOT=register("halfshade_ingot", HalfshadeIngot::new, new Item.Settings().maxCount(64));
    public static final Item HALFSHADE_NUGGET=register("halfshade_nugget", Item::new, new Item.Settings().maxCount(64));
    public static final Item BANISHED_MARK=register("banished_mark",MarkOfTheBanished::new,new Item.Settings().maxCount(1));
    public static final Item GUARDIAN_MARK=register("guardian_mark",MarkOfTheGuardian::new,new Item.Settings().maxCount(1));
    public static final Item REALITY_WARPER=register("reality_warper",RealityWarper::new,new Item.Settings().maxCount(1));
    public static final Item EMBERS_FLAME=register("embers_flame",EmbersFlame::new,new Item.Settings().maxCount(1));
    public static final Item KYPERITE_BOW=register("kyperite_bow",KyperiteBow::new,new Item.Settings().maxCount(1).enchantable(1));
    public static final Item DARK_ENDER_PEARL=register("dark_ender_pearl",DarkEnderPearl::new,new Item.Settings().maxCount(1));
    public static final RegistryKey<Item> BLADE_OF_INFINITE_SORROW_KEY=RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, "blade_of_infinite_sorrow"));
    public static final SwordItem BLADE_OF_INFINITE_SORROW=new BladeOfInfiniteSorrow(ToolMaterial.DIAMOND, 15, -2.4F, new Item.Settings().enchantable(10).registryKey(BLADE_OF_INFINITE_SORROW_KEY));
    public static final RegistryKey<Item> HALFSHADE_BLADE_KEY=RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, "halfshade_blade"));
    public static final SwordItem HALFSHADE_BLADE=new HalfshadeBlade(ToolMaterial.DIAMOND, 6, -2.4F, new Item.Settings().enchantable(10).registryKey(HALFSHADE_BLADE_KEY));
    public static final RegistryKey<Item> BLADE_OF_LIGHT_KEY=RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, "blade_of_light"));
    public static final SwordItem BLADE_OF_LIGHT=new BladeOfLight(ToolMaterial.DIAMOND, 6, -2.4F, new Item.Settings().enchantable(10).registryKey(BLADE_OF_LIGHT_KEY));
    public static final RegistryKey<Item> BLADE_OF_DARKNESS_KEY=RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, "blade_of_darkness"));
    public static final SwordItem BLADE_OF_DARKNESS=new BladeOfDarkness(ToolMaterial.DIAMOND, 6, -2.4F, new Item.Settings().enchantable(10).registryKey(BLADE_OF_DARKNESS_KEY));
    public static final RegistryKey<Item> BLADE_OF_KARMA_KEY=RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, "blade_of_karma"));
    public static final SwordItem BLADE_OF_KARMA=new BladeOfKarma(ToolMaterial.DIAMOND, 10, -2.4F, new Item.Settings().enchantable(10).registryKey(BLADE_OF_KARMA_KEY));
    public static final RegistryKey<Item> CASSHEN_KEY=RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Defiance.MOD_ID, "casshen"));
    public static final SwordItem CASSHEN=new Casshen(ToolMaterial.DIAMOND, 10, -2.4F, new Item.Settings().enchantable(10).component(ModComponents.CHARGE_COMPONENT, 0).registryKey(CASSHEN_KEY));
    public static void initialize(){
        System.out.println("Mod Items Initialized!");
        registerItems();
    };
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,name));
        // Create the item instance.
        Item item=itemFactory.apply(settings.registryKey(itemKey));
        // Register the item.
        Registry.register(Registries.ITEM,itemKey,item);
        return item;
    };
    public static Item register(Item item,RegistryKey key){
        return Registry.register(Registries.ITEM,key,item);
    };
    public static void registerItems(){
        Defiance.LOGGER.info("Registering items for " + Defiance.MOD_ID);
        Registry.register(Registries.ITEM_GROUP,bandw_items_group_key,bandw_items_group);
        Registry.register(Registries.ITEM_GROUP,bandw_blocks_group_key,bandw_blocks_group);
        Registry.register(Registries.ITEM_GROUP,bandw_tec_group_key,bandw_tec_group);
        register(BLADE_OF_INFINITE_SORROW,BLADE_OF_INFINITE_SORROW_KEY);
        register(CASSHEN,CASSHEN_KEY);
        register(BLADE_OF_KARMA,BLADE_OF_KARMA_KEY);
        register(BLADE_OF_LIGHT,BLADE_OF_LIGHT_KEY);
        register(BLADE_OF_DARKNESS,BLADE_OF_DARKNESS_KEY);
        register(HALFSHADE_BLADE,HALFSHADE_BLADE_KEY);
        TecItems.registerTecItems();
        MagicItems.registerMagicItems();
        Defiance.LOGGER.info("Registering Item Group Contents for " + Defiance.MOD_ID);
        Block[] blocks={
            ModBlocks.DARK_LOG,
            ModBlocks.DEAD_DARK_LOG,
            ModBlocks.DARK_BARK,
            ModBlocks.DARK_PLANKS,
            ModBlocks.DARK_BRICKS,
            ModBlocks.LIGHT_PLANKS,
            ModBlocks.LIGHT_PLANK_SLAB,
            ModBlocks.LIGHT_PLANK_STAIRS,
            ModBlocks.LIGHT_BRICKS,
            ModBlocks.LIGHT_BRICK_SLAB,
            ModBlocks.LIGHT_BRICK_STAIRS,
            ModBlocks.LIGHT_BRICK_WALL,
            ModBlocks.PURE_LIGHT_BRICKS,
            ModBlocks.LIGHT_CHISELED_BRICKS,
            ModBlocks.CRACKED_LIGHT_BRICKS,
            ModBlocks.CRACKED_LIGHT_BRICK_SLAB,
            ModBlocks.CRACKED_LIGHT_BRICK_STAIRS,
            ModBlocks.CRACKED_LIGHT_BRICK_WALL,
            ModBlocks.LIGHT_TILES,
            ModBlocks.LIGHT_TILE_SLAB,
            ModBlocks.LIGHT_TILE_STAIRS,
            ModBlocks.LIGHT_TILE_WALL,
            ModBlocks.CRACKED_LIGHT_TILES,
            ModBlocks.CRACKED_LIGHT_TILE_SLAB,
            ModBlocks.CRACKED_LIGHT_TILE_STAIRS,
            ModBlocks.CRACKED_LIGHT_TILE_WALL,
            ModBlocks.LIGHT_IRON_BLOCK,
            ModBlocks.PURIFIED_COBBLESTONE,
            ModBlocks.PURIFIED_STONE,
            ModBlocks.PURIFIED_SAND,
            ModBlocks.PURIFIED_GRAVEL,
            ModBlocks.PURIFIED_DIRT,
            ModBlocks.PURIFIED_GRASS_BLOCK,
            ModBlocks.CORRUPTED_COBBLESTONE,
            ModBlocks.CORRUPTED_STONE,
            ModBlocks.CORRUPTED_SAND,
            ModBlocks.CORRUPTED_GRAVEL,
            ModBlocks.CONDENSED_CORRUPTION,
            ModBlocks.CORRUPTED_DIRT,
            ModBlocks.CORRUPTED_GRASS_BLOCK,
            ModBlocks.SHIELD_OF_LIGHT_BLOCK
        };
        Item[] items={
            ModItems.BLADE_OF_INFINITE_SORROW,
            ModItems.HALFSHADE_BLADE,
            ModItems.CASSHEN,
            ModItems.KYPERITE_BOW,
            ModItems.BLADE_OF_KARMA,
            ModItems.BLADE_OF_LIGHT,
            ModItems.BLADE_OF_DARKNESS,
            ModItems.BANISHED_MARK,
            ModItems.EMBERS_FLAME,
            ModItems.REALITY_WARPER,
            ModItems.GUARDIAN_MARK,
            ModItems.DARK_ENDER_PEARL,
            ModItems.PURE_DIVINITY,
            ModItems.HALFSHADE_INGOT,
            ModItems.HALFSHADE_NUGGET,
            ModItems.HALFSHADE_STICK,
            ModItems.LIGHT_STICK,
            ModItems.LIGHT_ROD,
            ModItems.LIGHT_PLATE,
            ModItems.LIGHT_SHARD,
            ModItems.LIGHT_IRON_INGOT,
            ModItems.RAW_LIGHT_ORE,
            ModItems.BURNT_FLESH,
            ModItems.WORM_MEAT,
            ModItems.COOKED_WORM_MEAT,
            ModItems.DARK_BONE,
            ModItems.DARK_BONEMEAL,
            ModItems.DARK_POUCH,
            ModItems.DARK_SPIDER_EYE,
            ModItems.DARK_STRING,
            ModItems.DARK_LEATHER,
            ModItems.DARK_SHARD
        };
        Item[] tec_items={
            TecItems.TEC_DUST,
            TecItems.TEC_GEARBOX,
            TecItems.TEC_CHIP_BASE,
            TecItems.TEC_COMPUTER_CHIP,
            TecItems.TEC_COMPUTER_BOX,
            TecItems.IRON_ROD,
            TecItems.IRON_HOOK,
            TecItems.IRON_BASE,
            TecItems.LASER_TURRET,
            TecItems.LASER_TURRET_HEAD,
            TecItems.TURRET_BASE,
            TecItems.TURRET_BOX,
            TecItems.TURRET_JOINTS,
            TecItems.LIGHT_REPULSOR
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
