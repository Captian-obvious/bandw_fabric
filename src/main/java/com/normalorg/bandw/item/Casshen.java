package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.sound.ModSounds;
import com.normalorg.bandw.component.ModComponents;
import com.normalorg.bandw.entity.damage.ModDamageSources;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Casshen extends SwordItemWithEffect {
    private int oldCharge=0;
    private boolean isLaserEnabled=false;
    private ScheduledExecutorService timed_effect_executor;
    public Casshen(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
    };
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target != null && attacker != null) {
            // Retrieve current charge value
            int currentCharge=this.getCharge(stack);
            if (currentCharge<30){
                // Calculate new charge value (e.g., incrementing by 1 for each hit)
                this.setCharge(stack,currentCharge + 5);
            }else{
                // Trigger the explosion if charge is above or at 30
                World world=target.getWorld();
                // this.isLaserEnabled = stack.hasEnchantments() && stack.getEnchantmentLevel(ModEnchantments.SUNDERBEAM) > 0;
                if (!world.isClient()){
                    Vec3d pos=Vec3d.ofBottomCenter(target.getBlockPos());
                    world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),SoundEvents.ITEM_TRIDENT_THUNDER,SoundCategory.PLAYERS,1.0F,1.0F);
                    ServerWorld serverworld=(ServerWorld) world;
                    // Superduperdev2 was here - 2025-10-5
                    if (this.isLaserEnabled){
                        DamageSource damageSource=new DamageSource(serverworld.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(ModDamageSources.CASSHEN_BEAM.getValue()).get());
                        
                    }else{
                        Entity entityAttacker=(Entity) attacker;
                        DamageSource damageSource=new DamageSource(serverworld.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(ModDamageSources.CASSHEN_EXPLOSION.getValue()).get());
                        world.createExplosion(entityAttacker,damageSource,null,pos.getX(),pos.getY(),pos.getZ(),8.0F,false,World.ExplosionSourceType.NONE);
                    };
                };
                // Reset the charge
                this.setCharge(stack,0);
            };
        };
        // Call the super method to ensure standard behavior
        return super.postHit(stack, target, attacker);
    };
    @Override
    public void weapon_effect(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (target!=null && attacker!=null){
            target.setHealth(target.getMaxHealth());
            ServerWorld world=(ServerWorld) target.getWorld();
            if (this.timed_effect_executor != null && !this.timed_effect_executor.isShutdown()) {
                this.timed_effect_executor.shutdown();
            };
            this.timed_effect_executor=Executors.newSingleThreadScheduledExecutor(); // little more safe than a random new thread
            this.timed_effect_executor.schedule(() -> {
                DamageSource damageSource=new DamageSource(world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(ModDamageSources.NONSEVERING_STRIKE.getValue()).get());
                BlockPos pos=target.getBlockPos();
                Vec3d particlePos=Vec3d.ofBottomCenter(pos);
                LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
                /*int charter_color=16762880;
                // Create dust effect with RGB (255,200,0) in floating-point format
                DustParticleEffect charterSeverEffect=new DustParticleEffect(charter_color, 1.0F);
                // Spawn particles in an outward expanding effect
                for (int i = 0; i < 5;i++) {
                    world.spawnParticles(charterSeverEffect,
                        particlePos.getX() + (Math.random() - 0.5) * i,
                        particlePos.getY() + (Math.random() - 0.5) * i,
                        particlePos.getZ() + (Math.random() - 0.5) * i,
                        20, 0.5 * i, 0.5 * i, 0.5 * i, 0.05);
                };
                */
                world.spawnEntity(bolt);
                target.damage(world,damageSource,target.getMaxHealth());
                this.timed_effect_executor.shutdown();
            },(long) 500,TimeUnit.MILLISECONDS);
        }else{
            Defiance.LOGGER.info("ERROR: target and attacker must not be null!");
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
        super.appendTooltip(stack, context, tooltip, type);
    };
    public void setCharge(ItemStack stack, int charge) {
        this.oldCharge=stack.set(ModComponents.CHARGE_COMPONENT,charge);
    };
    public int getCharge(ItemStack stack) {
        int charge=stack.getOrDefault(ModComponents.CHARGE_COMPONENT,0);
        return charge;
    };
};