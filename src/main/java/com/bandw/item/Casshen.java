package com.bandw.item;

import com.bandw.Main;
import com.bandw.item.SwordItemWithEffect;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.nbt.NbtCompound;
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
            setCharge(stack, currentCharge + 1);
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
    public void setCharge(ItemStack stack, int charge) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt("Charge", charge);
    };
    public int getCharge(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        return nbt != null ? nbt.getInt("Charge") : 0; // Default to 0 if no charge is set
    };
};