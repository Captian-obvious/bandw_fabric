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
    public void render(DrawContext context,int mouseX,int mouseY,float delta, CallbackInfo ci){
        MinecraftClient client=MinecraftClient.getInstance();
        int screenWidth=client.getWindow().getScaledWidth();
        int screenHeight=client.getWindow().getScaledHeight();
    };
};