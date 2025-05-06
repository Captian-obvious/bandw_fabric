package com.normalorg.bandw.entity.effect;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.block.ModBlocks;
import com.normalorg.bandw.util.CorruptionManager;
import com.normalorg.bandw.sound.ModSounds;
import net.minecraft.sound.SoundCategory;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CorruptionStatusEffect extends StatusEffect {
    public CorruptionStatusEffect(StatusEffectCategory category, int color) {
        super(category,color);
    };
    // Override methods to define the custom effect behavior
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int interval = 60 >> amplifier;
        return interval > 0 && duration % interval == 0;
    };
    @Override
    public boolean applyUpdateEffect(ServerWorld world,LivingEntity entity, int amplifier) {
        if (entity instanceof LivingEntity){
            LivingEntity livingEntity=(LivingEntity) entity;
            BlockPos entityPos=livingEntity.getBlockPos();
            Vec3d sound_pos=Vec3d.ofBottomCenter(entityPos);
            world.playSound(null,sound_pos.getX(),sound_pos.getY(),sound_pos.getZ(),ModSounds.CORRUPT,SoundCategory.PLAYERS,1.0F,1.0F);
            int range=2+amplifier;
            CorruptionManager corruptionManager=ModBlocks.corruptionManager;
            for (BlockPos pos : BlockPos.iterate(entityPos.add(-range,-range,-range),entityPos.add(range,range,range))){
                BlockState currentState=world.getBlockState(pos);
                Block corruptBlock=corruptionManager.getReplacement(currentState.getBlock());
                if (corruptBlock!=currentState.getBlock()){
                    world.setBlockState(pos,corruptBlock.getDefaultState());
                };
            };
        };
        return super.applyUpdateEffect(world,entity, amplifier);
    };
};