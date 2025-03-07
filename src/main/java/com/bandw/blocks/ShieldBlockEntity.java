package com.bandw.blocks;

import com.bandw.shields.Shield;
import com.bandw.registry.ModBlocks;
import com.bandw.registry.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.nbt.NbtCompound;

public class ShieldBlockEntity extends BlockEntity {
    private Shield shield;
    private float size=0;
    private float strength=0;
    private float max_strength=0;
    public ShieldBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHIELD_BLOCK_ENTITY,pos,state);
        this.shield=new Shield(new Vec3d(pos.getX(),pos.getY(),pos.getZ()),100.0f,1.0f);
        this.shield.setChangeHandler(onchange);
    };
    public void onchange(float size,float strength){
        this.size=size;
        this.strength=strength;
        this.max_strength=this.shield.getMaxStrength();
        this.markDirty();
    }
    @Override
    protected void writeNbt(NbtCompound nbt,RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putFloat("size",this.size);
        nbt.putFloat("strength",this.strength);
        super.writeNbt(nbt,registryLookup);
    };
    @Override
    protected void readNbt(NbtCompound nbt,RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.shield.setSize(nbt.getFloat("size"));
        this.shield.setStrength(nbt.getFloat("strength"));
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