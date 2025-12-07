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
    @Unique
    private float accumlator=0.0f;
    @Unique
    private float animationTime=2.0f;
    @Unique
    private final Identifier RUNES=Identifier.of(DefianceClient.MOD_ID,"textures/gui/runes/symbols_of_power.png");
    @Inject(method = "render", at = @At("TAIL"), cancellable = true)
    public void onRender(DrawContext context,int mouseX,int mouseY,float delta, CallbackInfo ci){
        MinecraftClient client=MinecraftClient.getInstance();
        int screenWidth=client.getWindow().getScaledWidth();
        int screenHeight=client.getWindow().getScaledHeight();
        accumlator=(accumlator+delta) % animationTime;
        float alpha=(float)((Math.sin((accumlator/animationTime)*(2.0*Math.PI))+1.0) / 2.0);
        int baseColor=0xFF004F;
        int argbColor=((int)(alpha * 255) << 24) | baseColor;
        // drawTexture(Function<Identifier,RenderLayer> renderLayers, Identifier sprite, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight, int color)
        context.drawTexture(RenderLayer::getGuiTextured,RUNES,0,0,0,0,48,48,48,192,argbColor);
        context.drawTexture(RenderLayer::getGuiTextured,RUNES,screenWidth-48,0,0,48,48,48,48,192,argbColor);
        context.drawTexture(RenderLayer::getGuiTextured,RUNES,0,screenHeight-48,0,96,48,48,48,192,argbColor);
        context.drawTexture(RenderLayer::getGuiTextured,RUNES,screenWidth-48,screenHeight-48,0,144,48,48,48,192,argbColor);
    };
};