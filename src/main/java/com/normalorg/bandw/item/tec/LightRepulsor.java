package com.normalorg.bandw.item.tec;

//h
import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.normalorg.bandw.sound.ModSounds;
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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class LightRepulsor extends BowItem {
    private boolean isActive = false; // is the user "pulling" the repulsor
    private float activeTime = 0.0f; // how long the user has been "pulling" the repulsor
    private ScheduledExecutorService executor;
    private ScheduledExecutorService overheated_executor;
    private boolean isCharging = false; // is the repulsor charging
    private boolean wasOverheated = false; // was the repulsor overheated
    private float chargeLevel=0.0f; // current charge level
    private float soundPitch=0.0f; // sound pitch (increases with charge level)
    private float overheatedAccumulator=0.0f; // accumulator for overheat time, this does drop over time
    private final float overheatedAccumulatorDropRate=0.1f; // rate at which the overheat accumulator drops (per second)
    private final float overheatedAccumulatorOverheatedValue=3.0f; // basically a usage counter, if it reaches this value the repulsor overheats
    private final float chargeMaxLevel=30.0f; // max charge level
    private final float minChargeToRepulse=1.0f; // min charge level to repulse
    private final float maxSoundPitch=5.0f; // max sound pitch
    private final float maxActiveTime = 10.0f; // max time (seconds)
    private final float overheatTime = 5.0f; // overheat time (seconds) (this is basically a cooldown)
    public LightRepulsor(Settings settings) {
        super(settings);
    };
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand){
        if (!world.isClient){
            if (this.wasOverheated) return ActionResult.FAIL; // prevent use if overheated
            if (this.isActive) return ActionResult.PASS; // prevent re-activation if already active
            this.isActive=true;
            this.activeTime=0.0f;
            this.chargeLevel=0.0f;
            this.soundPitch=1.0f;
            this.startCharging();
        };
        return super.use(world, user, hand); // preserve bow functionality
    };
    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks){
        if (!world.isClient && user instanceof ServerPlayerEntity){
            this.isActive=false;
            this.stopCharging();
            Vec3d pos=Vec3d.ofBottomCenter(user.getBlockPos());
            if (this.chargeLevel >= this.minChargeToRepulse){
                //repulse effect
                world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),ModSounds.LIGHT_REPULSOR_FIRE,SoundCategory.PLAYERS,1.0F,1.0F);
                this.overheatedAccumulator+=this.chargeLevel/10.0f; // increase accumulator
                // handle overheating
                if (this.overheated_executor == null || this.overheated_executor.isShutdown()){
                    this.decrease_thread(); //start decrease thread if not already running
                };
                if (this.overheatedAccumulator >= this.overheatedAccumulatorOverheatedValue){
                    this.overheatedAccumulator=0.0f;
                    world.playSound(null,pos.getX(),pos.getY(),pos.getZ(),ModSounds.LIGHT_REPULSOR_OVERHEAT,SoundCategory.PLAYERS,1.0F,1.0F);
                    this.overheatedTimer(); // trigger overheat
                };
            };
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
    public float getChargeLevel(){
        return this.chargeLevel;
    };
    public boolean getWasOverheated(){
        return this.wasOverheated;
    };
    public boolean getIsOverheated(){
        return this.wasOverheated;
    };
    public float getSoundPitch(){
        return this.soundPitch;
    };
    public float getMaxSoundPitch(){
        return this.maxSoundPitch;
    };
    public float getMaxChargeLevel(){
        return this.chargeMaxLevel;
    };
    public float getMaxActiveTime(){
        return this.maxActiveTime;
    };
    // number manipulation thread 
    // ( safe in this context since its only changing numbers, 
    // which dont *directly* affect game state
    // and the thread is killed when the user stops using the item )
    // (or when the max time is reached)
    public void startCharging() {
        if (this.isCharging || (this.executor != null && !this.executor.isShutdown())) return;
        this.isCharging = true;
        this.executor = Executors.newSingleThreadScheduledExecutor();
        int toconverttoseconds=20; // 0.02 seconds
        this.executor.scheduleAtFixedRate(() -> {
            if (!this.isActive || !this.isCharging || activeTime >= maxActiveTime) {
                this.stopCharging();
                return;
            };
            this.activeTime += ((float) toconverttoseconds)/1000.0f; // convert to seconds
            // increase sound pitch
            this.soundPitch = Math.min(this.maxSoundPitch,1.0f+(this.activeTime*((maxSoundPitch-1.0f)/this.maxActiveTime)));
            this.chargeLevel = Math.min(this.chargeMaxLevel,this.activeTime*(this.chargeMaxLevel/this.maxActiveTime));
        },0,toconverttoseconds,TimeUnit.MILLISECONDS);
    };
    public void overheatedTimer(){
        if (this.wasOverheated) return;
        this.wasOverheated=true;
        this.chargeLevel=0.0f;
        this.soundPitch=1.0f;
        if (this.executor != null && !this.executor.isShutdown()) {
            this.executor.shutdown();
        };
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.schedule(() -> {
            this.wasOverheated=false;
            if (this.executor != null && !this.executor.isShutdown()) {
                this.executor.shutdown();
            };
        },(long)(this.overheatTime*1000),TimeUnit.MILLISECONDS);
    };
    public void decrease_overheated_accumulator(float amount){
        this.overheatedAccumulator=Math.max(0.0f,this.overheatedAccumulator-amount);
    };
    public void decrease_thread(){
        if (this.overheated_executor != null && !this.overheated_executor.isShutdown()) return;
        this.overheated_executor = Executors.newSingleThreadScheduledExecutor();
        int toconverttoseconds=1000; // 1 second
        this.overheated_executor.scheduleAtFixedRate(() -> {
            if (this.wasOverheated) return;
            this.decrease_overheated_accumulator(this.overheatedAccumulatorDropRate);
            if (this.overheatedAccumulator <= 0.0f){
                if (this.overheated_executor != null && !this.overheated_executor.isShutdown()) {
                    this.overheated_executor.shutdown();
                };
            };
        },0,toconverttoseconds,TimeUnit.MILLISECONDS);
    };
    private void stopCharging() {
        this.isCharging = false;
        if (this.executor != null && !this.executor.isShutdown()) {
            this.executor.shutdown();
        };
    };
};
