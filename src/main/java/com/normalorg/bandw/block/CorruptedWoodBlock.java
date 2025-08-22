package com.normalorg.bandw.block;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.entity.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.AbstractBlock.Settings;

public class CorruptedWoodBlock extends Block {
    public CorruptedWoodBlock(Settings settings) {
        super(settings);
    };
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity){
        if (!world.isClient()){
            if (entity instanceof LivingEntity livingEntity){
                if (!livingEntity.hasStatusEffect(ModEffects.DARKENING)){
                    StatusEffectInstance instance = new StatusEffectInstance(ModEffects.DARKENING,100,1,false,true,true);
                    
                    boolean success=livingEntity.addStatusEffect(instance);
                    if (!success){
                        Defiance.LOGGER.info("Failed to apply effect 'bandw:darkening' to entity, ignoring and continuing");
                    };
                };
            };
        };
    };
};