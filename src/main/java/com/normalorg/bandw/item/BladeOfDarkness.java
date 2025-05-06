package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.item.SwordItemWithEffect;
import com.normalorg.bandw.entity.effect.ModEffects;
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

public class BladeOfDarkness extends SwordItemWithEffect {
    public BladeOfDarkness(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
    };
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (!target.getWorld().isClient){
            if (target!=null && attacker!=null){
                StatusEffectInstance instance = new StatusEffectInstance(ModEffects.DARKENING,200,1,false,true,true);
                boolean success=target.addStatusEffect(instance);
                if (!success){
                    Defiance.LOGGER.info("Failed to apply effect 'bandw:darkening' to entity, ignoring and continuing");
                };
            }else{
                Defiance.LOGGER.info("ERROR: target and attacker must not be null!");
            };
        };
        return super.postHit(stack,target,attacker);
    };
    @Override
    public void weapon_effect(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (target!=null && attacker!=null){
            /*target.setHealth(target.getMaxHealth());
            ServerWorld world=(ServerWorld) target.getWorld();
            BlockPos pos=target.getBlockPos();
            LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
            bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(bolt);
            target.setHealth(0.0F);*/
        }else{
            Defiance.LOGGER.info("ERROR: target and attacker must not be null!");
        };
    };
};