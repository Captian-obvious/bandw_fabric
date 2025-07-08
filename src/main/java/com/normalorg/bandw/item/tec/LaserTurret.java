package com.normalorg.bandw.item.tec;

//h
import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.normalorg.bandw.entity.LaserTurretEntity;
import com.normalorg.bandw.entity.ModEntities;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.util.ActionResult;
import net.minecraft.text.Text;
import java.util.List;

public class LaserTurret extends Item {
    public LaserTurret(Settings settings){
        super(settings);
    };
    public ActionResult useOnBlock(ItemUsageContext context){
        if (!context.getWorld().isClient()){
            ServerWorld world=(ServerWorld) context.getWorld();
            Vec3d pos=context.getHitPos();
            // Item stack
            ItemStack stack=context.getStack();
            //PLACEHOLDER ENTITY
            LaserTurretEntity entity=new LaserTurretEntity(ModEntities.LASER_TURRET,world);
            entity.refreshPositionAfterTeleport(pos);
            world.spawnEntity(entity);
            // Decrement the stack
            if (!(context.getPlayer() instanceof ServerPlayerEntity serverPlayer && serverPlayer.isCreative())) { 
                stack.decrement(1);
            };
        };
        return ActionResult.SUCCESS;
    };
};