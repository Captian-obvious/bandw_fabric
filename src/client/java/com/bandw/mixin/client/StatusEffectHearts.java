package com.bandw.mixin.client;

import com.bandw.ClientMain.MOD_ID;
import com.bandw.registry.ModEffects;
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
public class StatusEffectHearts {
    @Unique
    private static final Identifier DARKENING_HEARTS=Identifier.of(MOD_ID,"textures/gui/darkening_hearts.png")
    @Inject(method="drawHeart",at=@At("HEAD"),cancellable=true)
    private void bandw$drawEffectHearts(DrawContext ctx,InGameHud.HeartType type,int x,int y,boolean hardcore,boolean blinking,boolean half,CallbackInfo info){
        if (!blinking && type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player && (player.hasStatusEffect(ModEffects.DARKENING))){
            Identifier the_texture;
            if (player.hasStatusEffect(ModEffects.DARKENING)){
                the_texture=DARKENING_HEARTS;
            }else{
                return;
            };
            ctx.drawTexture(RenderLayer::getGuiTextured,the_texture,x,y,half ? 9 : 0,0,9,9);
            info.cancel();
        };
    };
};