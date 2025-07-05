package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.sound.ModSounds;
import com.normalorg.bandw.block.ModBlocks;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.normalorg.bandw.component.ModComponents;
import com.normalorg.bandw.entity.damage.ModDamageSources;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.item.Item;
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
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.util.ActionResult;
import net.minecraft.text.Text;
import java.util.List;

public class EmbersFlame extends Item {
    public EmbersFlame(Settings settings) {
        super(settings);
    };
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
                    StatusEffectInstance effect=new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,100,1);
                    boolean success= livingEntity.addStatusEffect(effect);
                    if (!success) {
                        Defiance.LOGGER.info("Embers Flame: Failed to apply minecraft:fire_resistance to " + livingEntity.getName().getString());
                    };
                };
            };
        };
        super.inventoryTick(stack, world, entity, slot, selected);
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("itemTooltip.bandw.embers_flame").formatted(Formatting.LIGHT_PURPLE));
        super.appendTooltip(stack, context, tooltip, type);
    };
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (!world.isClient()) {
            if (world instanceof ServerWorld serverWorld){
                BlockState blockState = serverWorld.getBlockState(pos);
                // If the block is the portal block, we initiate its activation;
                if (blockState.isOf(ModBlocks.PURE_LIGHT_BRICKS)) {
                    Defiance.LOGGER.info("Embers Flame: Activating portal at " + pos);
                    // Decrement the stack
                    if (!(context.getPlayer() instanceof ServerPlayerEntity serverPlayer && serverPlayer.isCreative())) { 
                        stack.decrement(1);
                    };
                    // For now we do nothing, when the portal is finished, it will activate it.
                };
            };
        };
        return ActionResult.SUCCESS;
    };
};