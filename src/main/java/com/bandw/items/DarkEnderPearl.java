package com.bandw.items;

import com.bandw.Main;
import com.bandw.registry.ModEffects;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DarkEnderPearl extends EnderPearlItem {
    public DarkEnderPearl(Item.Settings settings) {
        super(settings);
    };
    @Override
    public TypedActionResult<ItemStack> use(World world,PlayerEntity player,Hand hand) {
        if (!world.isClient()){
            if (player instanceof LivingEntity){
                LivingEntity livingEntity=(LivingEntity) player;
                // apply darkening to the player
                StatusEffectInstance instance = new StatusEffectInstance(ModEffects.DARKENING,100,1,false,true,true);
                boolean success=livingEntity.addStatusEffect(instance);
                if (!success){
                    Main.LOGGER.info("Failed to apply effect 'bandw:darkening' to entity, ignoring and continuing");
                };
            };
        };
        return super.use(world,player,hand);
    };
};