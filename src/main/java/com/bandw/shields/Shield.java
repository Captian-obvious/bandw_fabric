package com.bandw.shields;

import net.minecraft.util.math.Vec3d;

public class Shield {
    private Vec3d position;
    private float size;
    private float strength;
    private float maxStrength;
    private boolean isActive;

    public Shield(Vec3d position, float size, float strength) {
        this.position = position;
        this.size = size;
        this.maxStrength=strength;
        this.strength = strength;
        this.isActive = true;
    };
    public void expand(float amount) {
        if (isActive) {
            this.size += amount;
        };
    };
    public void contract(float amount) {
        if (isActive) {
            this.size = Math.max(0, this.size - amount);
        };
    };
    public void weaken(float amount) {
        if (isActive) {
            this.strength = Math.max(0, this.strength - amount);
            if (this.strength<=0) {
                this.collapse();
            };
        };
    };
    public void collapse(){
        new Thread(()->{
            while (this.size>0) {
                this.size-=this.size*.05;
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                };
            };
        }).start();
    };
    public void toggleActive() {
        this.isActive = !this.isActive;
    };
    public boolean getIsActive() {
        return this.isActive;
    };
    public float getSize() {
        return this.size;
    };
    public float getStrength() {
        return this.strength;
    };
    public float getMaxStrength() {
        return this.maxStrength;
    };
    public void setIsActive(boolean val) {
        this.isActive=val;
    };
    public void setSize(float val) {
        this.size=val;
    };
    public void setStrength(float val) {
        this.strength=val;
    };
    public void setMaxStrength(float val) {
        this.maxStrength=val;
    };
};
