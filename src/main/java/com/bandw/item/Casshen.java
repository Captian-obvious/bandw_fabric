package com.bandw.item;

import com.bandw.Main;
import com.bandw.registry.ModComponents;
import com.bandw.item.SwordItemWithEffect;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Casshen extends SwordItemWithEffect {
    public Casshen(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
    };
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target != null && attacker != null) {
            // Retrieve current charge value
            int currentCharge = getCharge(stack);
            // Calculate new charge value (e.g., incrementing by 1 for each hit)
            setCharge(stack, currentCharge + 5);
        };
        // Call the super method to ensure standard behavior
        return super.postHit(stack, target, attacker);
    };
    @Override
    public void weapon_effect(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (target!=null && attacker!=null){
            target.setHealth(target.getMaxHealth());
            ServerWorld world=(ServerWorld) target.getWorld();
            BlockPos pos=target.getBlockPos();
            LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
            bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(bolt);
            target.setHealth(0.0F);
        }else{
            Main.LOGGER.info("ERROR: target and attacker must not be null!");
        };
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        int charge=this.getCharge(stack);
        if (charge>=30){
            tooltip.add(Text.translatable("item.bandw.casshen.charge",charge).formatted(Formatting.RED));
        }else{
            tooltip.add(Text.translatable("item.bandw.casshen.charge",charge).formatted(Formatting.GOLD));
        };
    };
    public void setCharge(ItemStack stack, int charge) {
        int oldValue=stack.set(ModComponents.CHARGE_COMPONENT,charge);
    };
    public int getCharge(ItemStack stack) {
        int charge=stack.getOrDefault(ModComponents.CHARGE_COMPONENT,0);
        return charge;
    };
};