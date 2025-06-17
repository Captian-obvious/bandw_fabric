package com.normalorg.bandw.item.tec;

// Import necessary classes
import com.normalorg.bandw.Defiance;
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

public class TecItems {
    public static final Item TEC_DUST=register("tec_dust",Item::new,new Item.Settings().maxCount(64));
    public static final Item IRON_ROD=register("iron_rod",Item::new,new Item.Settings().maxCount(64));
    public static final Item IRON_HOOK=register("iron_hook",Item::new,new Item.Settings().maxCount(64));
    public static final Item IRON_BASE=register("iron_base",Item::new,new Item.Settings().maxCount(64));
    public static final Item TEC_CHIP_BASE=register("tec_chip_base",Item::new,new Item.Settings().maxCount(64));
    public static final Item TEC_COMPUTER_BOX=register("tec_computer_box",Item::new,new Item.Settings().maxCount(64));
    public static final Item TEC_COMPUTER_CHIP=register("tec_computer_chip",Item::new,new Item.Settings().maxCount(64));
    public static final Item TEC_GEARBOX=register("tec_gearbox",Item::new,new Item.Settings().maxCount(64));
    public static final Item TURRET_JOINTS=register("turret_joints",Item::new,new Item.Settings().maxCount(64));
    public static final Item TURRET_BASE=register("turret_base",Item::new,new Item.Settings().maxCount(64));
    public static final Item TURRET_BOX=register("turret_box",Item::new,new Item.Settings().maxCount(64));
    public static final Item LASER_TURRET_HEAD=register("laser_turret_head",Item::new,new Item.Settings().maxCount(64));
    public static final Item LASER_TURRET=register("laser_turret",LaserTurret::new,new Item.Settings().maxCount(64));
    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey=RegistryKey.of(RegistryKeys.ITEM,Identifier.of(Defiance.MOD_ID,name));
        Item item=itemFactory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM,itemKey,item);
    };
    public static void registerTecItems(){
        Defiance.LOGGER.info("Registering Tec Items for " + Defiance.MOD_ID);
    };
};