package com.bandw.shields;

import net.minecraft.util.math.Vec3d;

public class Shield {
    private Vec3d position;
    private float size;
    private float strength;
    private boolean isActive;

    public Shield(Vec3d position, float size, float strength) {
        this.position = position;
        this.size = size;
        this.strength = strength;
        this.isActive = true;
    };
    public void expand(float amount) {
        if (isActive) {
            size += amount;
        };
    };
    public void contract(float amount) {
        if (isActive) {
            size = Math.max(0, size - amount);
        };
    };
    public void weaken(float amount) {
        if (isActive) {
            strength = Math.max(0, strength - amount);
            if (strength<=0) {
                this.collapse();
            };
        };
    };
    public void collapse(){
        new Thread(()->{
            while (size>0) {
                size-=size*.05;
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                };
            };
        }).start();
    };
    public void toggleActive() {
        isActive = !isActive;
    };
    public boolean getIsActive() {
        return isActive;
    };
    public boolean getSize() {
        return size;
    };
    public boolean getStrength() {
        return strength;
    };
    public boolean setIsActive(boolean val) {
        isActive=val;
    };
    public boolean setSize(int val) {
        size=val;
    };
    public boolean setStrength(int val) {
        strength=val;
    };
};
