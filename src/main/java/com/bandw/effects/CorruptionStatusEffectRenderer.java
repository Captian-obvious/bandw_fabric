package com.bandw.effects.client;

import com.bandw.ClientMain;
import com.bandw.effects.CorruptionStatusEffect;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import net.minecraft.potion.PotionEffect;

public class CorruptionStatusEffectRenderer {
    private static final Identifier ICON = new Identifier(ClientMain.MOD_ID, "textures/mob_effect/corruption.png");
    public void renderInventoryEffect(int x, int y, PotionEffect effect, MinecraftClient mc) {
        mc.getTextureManager().bindTexture(SpriteAtlasTexture.STATUS_EFFECT_TEXTURE);
        Sprite sprite = mc.getSpriteAtlas(SpriteAtlasTexture.STATUS_EFFECT_TEXTURE).apply(ICON);
        mc.inGameHud.drawSprite(x + 6, y + 7, mc.getZOffset(), 18, 18, sprite);
    };
    public void renderHUDEffect(int x, int y, PotionEffect effect, MinecraftClient mc, float alpha) {
        mc.getTextureManager().bindTexture(SpriteAtlasTexture.STATUS_EFFECT_TEXTURE);
        Sprite sprite = mc.getSpriteAtlas(SpriteAtlasTexture.STATUS_EFFECT_TEXTURE).apply(ICON);
        mc.inGameHud.drawSprite(x + 3, y + 3, mc.getZOffset(), 18, 18, sprite);
    };
};