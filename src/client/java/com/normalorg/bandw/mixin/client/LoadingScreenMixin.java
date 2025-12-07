package com.normalorg.bandw.mixin.client;

import com.normalorg.bandw.client.DefianceClient;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.world.LevelLoadingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelLoadingScreen.class)
public class LoadingScreenMixin {
    @Inject(method = "render", at = @At("TAIL"), cancellable = true)
    public void onRender(DrawContext context,int mouseX,int mouseY,float delta, CallbackInfo ci){
        MinecraftClient client=MinecraftClient.getInstance();
        int screenWidth=client.getWindow().getScaledWidth();
        int screenHeight=client.getWindow().getScaledHeight();
        float alpha=((Math.sin((((float) System.currentTimeMillis())/500.0f))+1.0f)/2.0f);
        int baseColor=0xFF004F;
        int argbColor=((int)(alpha * 255) << 24) | baseColor;
    };
};