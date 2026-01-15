package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.sound.ModSounds;
import com.normalorg.bandw.component.ModComponents;
import com.normalorg.bandw.entity.damage.ModDamageSources;
import com.normalorg.bandw.entity.effect.ModEffects;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class PureDivinity extends Item {
    private ScheduledExecutorService timed_effect_executor;
    private int timeSinceLastSoundPlayed=0;
    private int timeBetweenSoundsTicks=10000;
    public PureDivinity(Settings settings) {
        super(settings);
    };
    @Override
    public void inventoryTick(ItemStack stack,World world,Entity entity,int slot,boolean selected){
        if (!world.isClient() && selected){
            if (entity instanceof LivingEntity livingEntity){
                Vec3d pos=Vec3d.ofBottomCenter(livingEntity.getBlockPos());
                this.timeSinceLastSoundPlayed+=1;
                if (this.timeSinceLastSoundPlayed>this.timeBetweenSoundsTicks){
                    this.timeSinceLastSoundPlayed=0;
                    world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),ModSounds.PURE_DIVINITY_AMBIENCE,SoundCategory.AMBIENT,1.0F,1.0F);
                };
            };
        };
        super.inventoryTick(stack,world,entity,slot,selected);
    };
    @Override
    public void onItemEntityDestroyed(ItemEntity entity){
        World world=entity.getWorld();
        if (!world.isClient() && world instanceof ServerWorld serverWorld){
            Vec3d pos=Vec3d.ofBottomCenter(entity.getBlockPos());
            // dramtic explosion
            float power=15.0F; // starting explosion power
            for (int i=0;i<6;i++){
                LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                bolt.refreshPositionAfterTeleport(pos);
                world.spawnEntity(bolt);
                //power+=3.0F;
            };
            serverWorld.createExplosion(entity,null,null,pos.getX(),pos.getY(),pos.getZ(),power,true,World.ExplosionSourceType.TNT);
            //power=0.0F;
            world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),SoundEvents.BLOCK_BEACON_DEACTIVATE,SoundCategory.AMBIENT,1.0F,1.0F);
        };
        super.onItemEntityDestroyed(entity);
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("itemTooltip.bandw.pure_divinity").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    };
    public boolean isEnabled() {
        return true;
    };
    public void onKill(LivingEntity target, LivingEntity attacker) {
        if (attacker.getWorld() instanceof ServerWorld world) {
            target.setHealth(target.getMaxHealth());
            // Temporary system for delay, it will be replaced with an entity soon
            if (this.timed_effect_executor != null && !this.timed_effect_executor.isShutdown()) {
                this.timed_effect_executor.shutdown();
            };
            this.timed_effect_executor=Executors.newSingleThreadScheduledExecutor(); // little more safe than a random new thread
            this.timed_effect_executor.schedule(() -> {
                DamageSource damageSource=new DamageSource(world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(ModDamageSources.PURE_DIVINITY_STRIKE.getValue()).get());
                BlockPos pos=target.getBlockPos();
                LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
                world.spawnEntity(bolt);
                target.damage(world,damageSource,target.getMaxHealth());
                this.timed_effect_executor.shutdown();
            },(long) 500,TimeUnit.MILLISECONDS);
        };
    };
};
