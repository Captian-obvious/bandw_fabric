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
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import java.util.List;

public class PureDivinity extends Item {
    int effectDelay=20; //delay in ticks before applying effect
    int effectAcc=0;
    public PureDivinity(Settings settings) {
        super(settings);
    };
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if (entity instanceof LivingEntity livingEntity) {
            effectAcc+=1;
            if (!livingEntity.hasStatusEffect(StatusEffects.INVISIBILITY)){
                // apply resistance to the player (they are immortal)
                StatusEffectInstance instance = new StatusEffectInstance(StatusEffects.INVISIBILITY,100,5,false,true,true);
                boolean success=livingEntity.addStatusEffect(instance);
                if (!success){
                    Defiance.LOGGER.info("Failed to apply effect 'minecraft:resistance' to entity, ignoring and continuing");
                };
                effectAcc=0;
            };
        };
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("itemTooltip.bandw.pure_divinity").formatted(Formatting.GOLD));
    };
};
