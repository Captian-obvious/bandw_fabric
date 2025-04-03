package com.bandw.items;

import com.bandw.Main;
import com.bandw.registry.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
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
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import java.util.List;

public class MarkOfTheBanished extends Item {
    int effectDelay=20; //delay in ticks before applying effect
    int effectAcc=0;
    public MarkOfTheBanished(Settings settings){
        super(settings);
    };
    @Override
    public void inventoryTick(ItemStack stack,World world,Entity entity,int slot,boolean selected) {
        if (!world.isClient()){
            if (entity instanceof LivingEntity && selected){
                effectAcc+=1;
                LivingEntity livingEntity=(LivingEntity) entity;
                if (effectAcc>=effectDelay){
                    // apply darkening to the player
                    StatusEffectInstance instance = new StatusEffectInstance(ModEffects.DARKENING,100,0,false,true,true);
                    boolean success=livingEntity.addStatusEffect(instance);
                    if (!success){
                        Main.LOGGER.info("Failed to apply effect 'bandw:darkening' to entity, ignoring and continuing");
                    };
                    effectAcc=0;
                };
            };
        };
        super.inventoryTick(stack, world, entity, slot, selected); // Call the super method to retain default behavior
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.bandw.banished_mark").formatted(Formatting.RED));
    };
};