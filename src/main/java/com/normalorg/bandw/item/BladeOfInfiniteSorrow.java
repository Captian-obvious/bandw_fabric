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

public class BladeOfInfiniteSorrow extends SwordItemWithEffect {
    private ScheduledExecutorService timed_effect_executor;
    public BladeOfInfiniteSorrow(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
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
                LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
                world.spawnEntity(bolt);
                target.damage(world,damageSource,target.getMaxHealth());
                this.timed_effect_executor.shutdown();
            },(long) 500.0,TimeUnit.MILLISECONDS);
        }else{
            Defiance.LOGGER.info("ERROR: target and attacker must not be null!");
        };
    };
};
//wcwcc?