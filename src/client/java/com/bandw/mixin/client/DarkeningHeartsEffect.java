package com.bandw.mixin.client;

import com.bandw.registry.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class DarkeningHeartsEffect {
    @Inject(method = "renderHealthBar", at = @At("HEAD"), cancellable = true)
    private void onRenderHealthBar(DrawContext context,PlayerEntity player,int x,int y,int lines,int regeneratingHeartIndex,float maxHealth,int lastHealth,int health,int absorption,boolean blinking,CallbackInfo info) {
        if (player != null && player.hasStatusEffect(ModEffects.DARKENING)) {
            // Custom rendering logic to make the health bar black
            RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F); // Set to black
        }else{
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F); // Reset shader to default color
        };
    };
};