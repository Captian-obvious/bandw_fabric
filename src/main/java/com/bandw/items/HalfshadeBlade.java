package com.bandw.items;

import com.bandw.Main;
import com.bandw.registry.ModEffects;
import com.bandw.items.SwordItemWithEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class HalfshadeBlade extends SwordItemWithEffect {
    public HalfshadeBlade(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
    };
    @Override
    public void weapon_effect(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (target!=null && attacker!=null){
            StatusEffectInstance instance = new StatusEffectInstance(ModEffects.HALFSHADE_POISONING,200,1,false,true,true);
            boolean success=target.addStatusEffect(instance);
            if (!success){
                Main.LOGGER.info("Failed to apply effect 'bandw:halfshade_poisoning' to entity, ignoring and continuing");
            };
        }else{
            Main.LOGGER.info("ERROR: target and attacker must not be null!");
        };
    };
};