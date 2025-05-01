package com.normalorg.bandw.block;

import com.normalorg.bandw.shields.Shield;
import com.normalorg.bandw.block.ModBlocks;
import com.normalorg.bandw.block.entity.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.nbt.NbtCompound;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ShieldBlockEntity extends BlockEntity {
    private Shield shield;
    private float size=0;
    private float strength=0;
    private float max_strength=0;
    private boolean active=true;
    public ShieldBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHIELD_BLOCK_ENTITY,pos,state);
        this.shield=new Shield(new Vec3d(pos.getX(),pos.getY(),pos.getZ()),100.0f,1.0f);
    };
    public void initialize(){
        BiFunction<Float, Float, Void> changeHandler = (newSize, newStrength) -> {
            this.size=newSize;
            this.strength=newStrength;
            this.max_strength=this.shield.getMaxStrength();
            this.markDirty();
            return null;
        };
        Function<Float, Void> collapseHandler = (newSize) -> {
            
            this.markDirty();
            return null;
        };
        Function<Boolean, Void> activeChangedHandler = (isActive) -> {
            this.active=isActive;
            this.markDirty();
            return null;
        };
        this.shield.setChangeHandler(changeHandler);
        this.shield.setCollapseHandler(collapseHandler);
        this.shield.setActiveChangedHandler(activeChangedHandler);
    };
    @Override
    protected void writeNbt(NbtCompound nbt,RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putFloat("size",this.size);
        nbt.putFloat("strength",this.strength);
        nbt.putBoolean("active",this.active);
        super.writeNbt(nbt,registryLookup);
    };
    @Override
    protected void readNbt(NbtCompound nbt,RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.shield.setSize(nbt.getFloat("size"));
        this.shield.setStrength(nbt.getFloat("strength"));
        this.shield.setIsActive(nbt.getBoolean("active"));
    };
    public void tick() {
        if (this.shield != null) {
            this.shield.expand(0.05f); // Example: Expand shield gradually
            this.shield.weaken(0.005f); // Example: Weaken shield gradually
        };
    };
    public Shield getShield(){
        return this.shield;
    };
};