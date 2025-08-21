package com.normalorg.bandw.item.tec;

//h
import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.normalorg.bandw.entity.LaserTurretEntity;
import com.normalorg.bandw.entity.ModEntities;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.BowItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import java.util.List;

public class LightRepulsor extends BowItem {
    private boolean isActive = false; // is the user "pulling" the repulsor
    private int activeTime = 0; // how long the user has been "pulling" the repulsor
    private final int maxActiveTime = 20; // max time
    public LightRepulsor(Settings settings) {
        super(settings);
    };
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand){
        if (!world.isClient){
            this.isActive=true;
        };
        return super.use(world, user, hand); // preserve bow functionality
    };
    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks){
        if (!world.isClient && user instanceof ServerPlayerEntity){
            this.isActive=false;
        };
        return super.onStoppedUsing(stack, world, user, remainingUseTicks);
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("itemTooltip.bandw.light_repulsor_L1").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.translatable("itemTooltip.bandw.light_repulsor_L2").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.translatable("itemTooltip.bandw.light_repulsor_L3").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    };
};