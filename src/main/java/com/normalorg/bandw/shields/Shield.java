package com.normalorg.bandw.shields;

import net.minecraft.util.math.Vec3d;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Shield {
    private Vec3d position;
    private float size;
    private float strength;
    private float maxStrength;
    private boolean isActive;
    public BiFunction<Float, Float, Void> on_change=null;
    public Function<Float, Void> on_collapse=null;
    public Function<Boolean, Void> on_active_changed=null;
    public Shield(Vec3d position, float size, float strength) {
        this.position = position;
        this.size = size;
        this.maxStrength=strength;
        this.strength = strength;
        this.isActive = true;
    };
    public void setChangeHandler(BiFunction<Float, Float, Void> handler){
        if (handler!=null){
            this.on_change=handler;
            this.on_change.apply(this.size,this.strength);
        };
    };
    public void setCollapseHandler(Function<Float, Void> handler){
        if (handler!=null){
            this.on_collapse=handler;
        };
    };
    public void setActiveChangedHandler(Function<Boolean, Void> handler){
        if (handler!=null){
            this.on_active_changed=handler;
            this.on_active_changed.apply(this.isActive);
        };
    };
    public void expand(float amount) {
        if (isActive) {
            this.size += amount;
            this.on_change.apply(this.size,this.strength);
        };
    };
    public void contract(float amount) {
        if (isActive) {
            this.size = Math.max(0, this.size - amount);
            this.on_change.apply(this.size,this.strength);
        };
    };
    public void weaken(float amount) {
        if (isActive) {
            this.strength = Math.max(0, this.strength - amount);
            this.on_change.apply(this.size,this.strength);
            if (this.strength<=0) {
                this.collapse();
            };
        };
    };
    public void collapse(){
        this.on_collapse.apply(this.size);
        new Thread(()->{
            float decrement=this.size*(float) 0.05;
            float original_size=this.size;
            while (this.size>0) {
                //this.size-=this.size*.05;
                this.size-=decrement;
                decrement+=original_size*(float) 0.05;
                this.on_change.apply(this.size,this.strength);
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
        this.on_active_changed.apply(this.isActive);
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
        this.on_active_changed.apply(this.isActive);
    };
    public void setSize(float val) {
        this.size=val;
        this.on_change.apply(this.size,this.strength);
    };
    public void setStrength(float val) {
        this.strength=val;
        this.on_change.apply(this.size,this.strength);
    };
    public void setMaxStrength(float val) {
        this.maxStrength=val;
        this.on_change.apply(this.size,this.strength);
    };
};
