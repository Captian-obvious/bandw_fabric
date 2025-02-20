package com.bandw.items;

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

public class BladeOfInfiniteSorrow extends SwordItem {
    public int attack_damage;
    public BladeOfInfiniteSorrow(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
        attack_damage=attackDamage;
    };
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (!target.getWorld().isClient){
            float targetHealth=target.getHealth();
            if (targetHealth<attack_damage){
                target.setHealth(target.getMaxHealth());
                ServerWorld world=(ServerWorld) target.getWorld();
                BlockPos pos=target.getBlockPos();
                LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
                world.spawnEntity(bolt);
                target.setHealth(0.0F);
            };
        };
        return super.postHit(stack,target,attacker);
    };
};
//wcwcc?