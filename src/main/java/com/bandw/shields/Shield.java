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
        };
    };
    public void toggleActive() {
        isActive = !isActive;
    };
    public void boolean getIsActive() {
        return isActive;
    };
    public void boolean getSize() {
        return size;
    };
    public void boolean getStrength() {
        return strength;
    };
    public void boolean setIsActive(boolean val) {
        isActive=val;
    };
    public void boolean setSize(int val) {
        size=val;
    };
    public void boolean setStrength(int val) {
        strength=val;
    };
}