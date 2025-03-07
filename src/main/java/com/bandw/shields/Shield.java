package com.bandw.shields;

import net.minecraft.util.math.Vec3d;
import java.util.function.Function;

public class Shield {
    private Vec3d position;
    private float size;
    private float strength;
    private float maxStrength;
    private boolean isActive;
    private Function<float,float,float> on_change=null;
    public Shield(Vec3d position, float size, float strength) {
        this.position = position;
        this.size = size;
        this.maxStrength=strength;
        this.strength = strength;
        this.isActive = true;
    };
    public void setChangeHandler(Function<float,float,float> handler){
        if (handler!=null){
            this.on_change=handler;
        };
    };
    public void expand(float amount) {
        if (isActive) {
            this.size += amount;
            this.on_change.apply(this.size,this.strength,this.maxStrength);
        };
    };
    public void contract(float amount) {
        if (isActive) {
            this.size = Math.max(0, this.size - amount);
            this.on_change.apply(this.size,this.strength,this.maxStrength);
        };
    };
    public void weaken(float amount) {
        if (isActive) {
            this.strength = Math.max(0, this.strength - amount);
            this.on_change.apply(this.size,this.strength,this.maxStrength);
            if (this.strength<=0) {
                this.collapse();
            };
        };
    };
    public void collapse(){
        new Thread(()->{
            float decrement=this.size*.05;
            float original_size=this.size;
            while (this.size>0) {
                //this.size-=this.size*.05;
                this.size-=decrement;
                decrement+=this.original_size*.05;
                this.on_change.apply(this.size,this.strength,this.maxStrength);
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
        this.on_change.apply(this.size,this.strength,this.maxStrength);
    };
    public void setStrength(float val) {
        this.strength=val;
        this.on_change.apply(this.size,this.strength,this.maxStrength);
    };
    public void setMaxStrength(float val) {
        this.maxStrength=val;
        this.on_change.apply(this.size,this.strength,this.maxStrength);
    };
};
