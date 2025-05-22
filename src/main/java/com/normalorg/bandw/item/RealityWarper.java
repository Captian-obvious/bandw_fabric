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
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import java.util.List;
import java.util.Set;

public class RealityWarper extends Item {
    int effectDelay=160; //delay in ticks before playing the sound again (its length, in this case 8 seconds)
    int effectAcc=0;
    public RealityWarper(Settings settings){
        super(settings);
    };
    public void inventoryTick(ItemStack stack,World world,Entity entity,int slot,boolean selected) {
        if (!world.isClient()){
            if (entity instanceof LivingEntity && selected){
                if (effectAcc==0){
                    effectAcc=0;
                    LivingEntity livingEntity=(LivingEntity) entity;
                    // Play the sound
                    // hey Doctor4t, you found my secret signature - Superduperdev2
                    Vec3d pos=Vec3d.ofBottomCenter(livingEntity.getBlockPos());
                    world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),ModSounds.REALITY_WARPER_HUM,SoundCategory.PLAYERS,0.25F,1.0F);
                }else if(effectAcc>=effectDelay){
                    effectAcc=0;
                };
            };
            effectAcc++;
        };
        super.inventoryTick(stack, world, entity, slot, selected); // Call the super method to retain default behavior
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.bandw.reality_warper").formatted(Formatting.LIGHT_PURPLE,Formatting.ITALIC));
    };
    private void teleportPlayer(ServerWorld world, Entity entity) {
        if (entity instanceof PlayerEntity player) {
            ServerWorld targetWorld = world.getServer().getWorld(ModDimensions.THE_VOID);
            if (targetWorld != null) {
                //TeleportTarget teleportTarget = new TeleportTarget(targetWorld,entity.getPos(),TeleportTarget.NO_OP);
                Set<PositionFlag> flags=Set.of(PositionFlag.X, PositionFlag.Y, PositionFlag.Z);
                player.teleport(targetWorld,player.getX(),player.getY(),player.getZ(),flags,player.getYaw(),player.getPitch(),false);
                player.sendMessage(Text.of("You feel reality shift around you...").formatted(Formatting.GOLD,Formatting.ITALIC), false);
            };
        };
    };
};