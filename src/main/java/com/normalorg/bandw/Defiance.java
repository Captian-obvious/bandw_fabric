package com.normalorg.bandw;

//Imports
import com.normalorg.bandw.block.ModBlocks;
import com.normalorg.bandw.entity.ModEntities;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.normalorg.bandw.fluid.ModFluids;
import com.normalorg.bandw.sound.ModSounds;
import com.normalorg.bandw.block.entity.ModBlockEntities;
import com.normalorg.bandw.component.ModComponents;
import com.normalorg.bandw.entity.damage.ModDamageSources;
import com.normalorg.bandw.world.dimension.ModDimensions;
import com.normalorg.bandw.item.ModItems;
import com.normalorg.bandw.entity.ModEntityAttributes;
import com.normalorg.bandw.util.CharterContractManager;
import com.normalorg.bandw.util.ModChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Defiance implements ModInitializer {
    public static boolean isCharterLoaded;
    // Charter hooks
    public static CharterContractManager contract_manager;
    public static Identifier LesserDvinityIdentifier;
    public static Item LESSER_DIVINITY;
    // End Charter Hooks
    public static final String MOD_ID = "bandw";
    public static final String VERSION="2.7.6";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean judgmentEnabled=false;
    @Override
    public void onInitialize() {
        LOGGER.info("Server Initializing...");
        registerModules();
        isCharterLoaded=ModChecker.isModLoaded("charter");
        LOGGER.info(isCharterLoaded ? "Charter mod is loaded! Enabling additional features." : "Charter mod is not loaded.");
        if (isCharterLoaded) registerCharterHooks();
        judgmentEnabled=isCharterLoaded;
        LOGGER.info("Server Initialized (Defiance v"+VERSION+")");
    };
    public static void registerModules(){
        ModBlocks.registerBlocks();
        ModBlocks.registerCorruptableBlocks();
        ModBlockEntities.registerBlockEntities();
        ModFluids.registerFluids();
        ModEntities.registerEntities();
        ModEntityAttributes.registerAttributes();
        ModComponents.registerComponents();
        ModDamageSources.registerDamageSources();
        // and so it begins!
        ModDimensions.registerDimensions();
        // (dimensions registered)
        ModItems.registerItems();
        ModEffects.registerEffects();
        ModSounds.registerSounds();
    };
    public static void registerCharterHooks(){
        LOGGER.info("Registering Charter Hooks (contract severing functionality)...");
        contract_manager=new CharterContractManager(isCharterLoaded);
        LesserDvinityIdentifier=Identifier.of("charter","lesser_divinity");
        LOGGER.info("Registered Charter Hooks successfully.");
    };
};