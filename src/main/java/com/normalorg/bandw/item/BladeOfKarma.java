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
import java.util.List;

public class BladeOfKarma extends SwordItemWithEffect {
    public BladeOfKarma(ToolMaterial material,int attackDamage,float attackSpeed,Settings settings){
        super(material,attackDamage,attackSpeed,settings);
    };
    @Override
    public void weapon_effect(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (target!=null && attacker!=null){
            DamageSource damageSource=new DamageSource(serverworld.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(ModDamageSources.NONSEVERING_STRIKE.getValue()).get());
            target.setHealth(target.getMaxHealth());
            ServerWorld world=(ServerWorld) target.getWorld();
            BlockPos pos=target.getBlockPos();
            LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
            bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(bolt);
            target.damage(world,damageSource,target.getMaxHealth());
        }else{
            Defiance.LOGGER.info("ERROR: target and attacker must not be null!");
        };
    };
};