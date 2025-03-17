package com.bandw.items;

import com.bandw.Main;
import net.minecraft.item.SwordItem;
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

public class SwordItemWithEffect extends SwordItem {
    public int attack_damage;
    public SwordItemWithEffect(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
        attack_damage=attackDamage;
    };
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (!target.getWorld().isClient){
            float targetHealth=target.getHealth();
            if (targetHealth<attack_damage){
                weapon_effect(stack,target,attacker);
            };
        };
        return super.postHit(stack,target,attacker);
    };
    public void weapon_effect(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (target!=null && attacker!=null){
            Main.LOGGER.info("Method must be overridden");
        }else{
            Main.LOGGER.info("ERROR: target and attacker must not be null!");
        };
    };
};