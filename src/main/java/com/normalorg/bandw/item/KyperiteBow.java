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
import net.minecraft.item.BowItem;
import net.minecraft.text.Text;
import java.util.List;

public class KyperiteBow extends BowItem {
    public KyperiteBow(Settings settings) {
        super(settings);
    };
    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, LivingEntity target){
        super.shoot(shooter, projectile, index, speed, divergence, yaw, target);
        if (shooter.getWorld() instanceof ServerWorld serverWorld) {
            if (target != null && target instanceof LivingEntity) {
                // Apply Crystal Infestation effect to the target
                boolean success=target.addStatusEffect(new StatusEffectInstance(ModEffects.CRYSTAL_INFESTATION, 200, 1));
                if (!success){
                    Defiance.LOGGER.info("Failed to apply effect 'bandw:crystal_infestation' to entity, ignoring and continuing");
                };
            };
        };
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.bandw.kyperite_bow").formatted(Formatting.LIGHT_PURPLE,Formatting.ITALIC));
        super.appendTooltip(stack, context, tooltip, type);
    };
};