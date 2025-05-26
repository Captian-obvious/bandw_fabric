package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class HalfshadeIngot extends Item {
    int effectDelay=20; //delay in ticks before applying effect
    int effectAcc=0;
    public HalfshadeIngot(Settings settings){
        super(settings);
    };
    @Override
    public void inventoryTick(ItemStack stack,World world,Entity entity,int slot,boolean selected) {
        if (!world.isClient()){
            if (entity instanceof LivingEntity && selected){
                effectAcc+=1;
                LivingEntity livingEntity=(LivingEntity) entity;
                if (!livingEntity.hasStatusEffect(ModEffects.DARKENING)){
                    // apply darkening to the player
                    StatusEffectInstance instance = new StatusEffectInstance(ModEffects.HALFSHADE_POISONING,100,0,false,true,true);
                    boolean success=livingEntity.addStatusEffect(instance);
                    if (!success){
                        Defiance.LOGGER.info("Failed to apply effect 'bandw:halfshade_poisoning' to entity, ignoring and continuing");
                    };
                    effectAcc=0;
                };
            };
        };
        super.inventoryTick(stack, world, entity, slot, selected); // Call the super method to retain default behavior
    };
};