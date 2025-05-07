package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.sound.ModSounds;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import com.normalorg.bandw.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.TeleportTarget;
import net.minecraft.sound.SoundCategory;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import java.util.List;

public class RealityWarper extends Item {
    int effectDelay=60; //delay in ticks before applying effect
    int effectAcc=0;
    public RealityWarper(Settings settings){
        super(settings);
    };
    public void inventoryTick(ItemStack stack,World world,Entity entity,int slot,boolean selected) {
        if (!world.isClient()){
            if (entity instanceof LivingEntity && selected){
                LivingEntity livingEntity=(LivingEntity) entity;
                Vec3d pos=Vec3d.ofBottomCenter(livingEntity.getBlockPos());
                //Play the hum sound
                //world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),ModSounds.REALITY_WARPER_HUM,SoundCategory.PLAYERS,1.0F,1.0F);
            };
        };
        super.inventoryTick(stack, world, entity, slot, selected); // Call the super method to retain default behavior
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.bandw.reality_warper").formatted(Formatting.GOLD,Formatting.ITALIC));
    };
    /*private void teleportPlayer(ServerWorld world, Entity entity) {
        if (entity instanceof PlayerEntity player) {
            ServerWorld targetWorld = world.getServer().getWorld(ModDimensions.THE_VOID);
            if (targetWorld != null) {
                //player.teleportCrossDimension(targetWorld)
                //player.sendMessage(Text.of("You feel reality shift around you..."), false);
            };
        };
    };
    */
};