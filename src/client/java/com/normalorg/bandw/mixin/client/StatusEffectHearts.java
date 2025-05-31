package com.normalorg.bandw.mixin.client;

import com.normalorg.bandw.DefianceClient;
import com.normalorg.bandw.entity.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class StatusEffectHearts {
    @Unique
    private static final Identifier DARKENING_HEARTS=Identifier.of(DefianceClient.MOD_ID,"textures/gui/darkening_hearts.png");
    @Unique
    private static final Identifier HALFSHADE_POISONING_HEARTS=Identifier.of(DefianceClient.MOD_ID,"textures/gui/halfshade_poisoning_hearts.png");
    /*@Inject(method = "drawHeart", at = @At("HEAD"), cancellable = true)
    private void drawEffectHeart(DrawContext ctx,InGameHud.HeartType type,int x,int y,boolean hardcore,boolean blinking,boolean half,CallbackInfo info){
        if (!blinking && type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player && (player.hasStatusEffect(ModEffects.DARKENING))){
            Identifier the_texture;
            if (player.hasStatusEffect(ModEffects.DARKENING)){
                the_texture=DARKENING_HEARTS;
            }else if (player.hasStatusEffect(ModEffects.HALFSHADE_POISONING)){
                the_texture=HALFSHADE_POISONING_HEARTS;
            }else{
                return;
            };
            ctx.drawTexture(RenderLayer::getGuiTextured,the_texture,x,y,half ? 9 : 0,0,9,9);
            info.cancel();
        };
    };*/
    @Inject(method = "renderHealthBar", at = @At("HEAD"), cancellable = true)
    private void onRenderHealthBar(DrawContext ctx,PlayerEntity player,int x,int y,int lines,int regeneratingHeartIndex,float maxHealth,int lastHealth,int health,int absorption,boolean blinking,CallbackInfo info) {
            if (player == null || !player.hasStatusEffect(ModEffects.DARKENING) && !player.hasStatusEffect(ModEffects.HALFSHADE_POISONING)) {
            // Default rendering logic (do nothing special)
            return;
        };
        Identifier heartTexture = null;
        // Determine which texture to use based on the effect
        if (player.hasStatusEffect(ModEffects.DARKENING)) {
            heartTexture = DARKENING_HEARTS;
        } else if (player.hasStatusEffect(ModEffects.HALFSHADE_POISONING)) {
            heartTexture = HALFSHADE_POISONING_HEARTS;
        };
        if (heartTexture != null) {
            // Begin custom rendering of hearts
            //ctx.bindTexture(heartTexture);
            double health_loop=Math.ceil((double) health / (double) 2);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F); // Ensure default coloring
            for (int i = 0; i < (int) health_loop; i++) {
                int heartX = x + (i % 10) * 8;
                int heartY = y - (i / 10) * 10;
                // (i==health_loop)
                boolean halfHeart = (((health % 2) == 1));
                // draw the heart
                ctx.drawTexture(RenderLayer::getGuiTextured,heartTexture,heartX,heartY,halfHeart ? 9.0F : 0.0F,0.0F,9,9,18,9);
            };
            // Cancel default rendering to use custom logic
            info.cancel();
        };
    };
};
