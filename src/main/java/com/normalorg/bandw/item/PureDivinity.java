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
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import java.util.List;

public class PureDivinity extends Item {
    public PureDivinity(Settings settings) {
        super(settings);
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("itemTooltip.bandw.pure_divinity").formatted(Formatting.GOLD));
    };
    public boolean isEnabled() {
        return true;
    };
    public void onKill(LivingEntity target, LivingEntity attacker) {
        if (attacker.getWorld() instanceof ServerWorld world) {
            target.setHealth(target.getMaxHealth());
            new Thread(()->{
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                };
                DamageSource damageSource=new DamageSource(world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getEntry(ModDamageSources.PURE_DIVINITY_STRIKE.getValue()).get());
                BlockPos pos=target.getBlockPos();
                LightningEntity bolt=new LightningEntity(EntityType.LIGHTNING_BOLT,world);
                bolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
                world.spawnEntity(bolt);
                target.damage(world,damageSource,target.getMaxHealth());
            }).start();
        };
    };
};
