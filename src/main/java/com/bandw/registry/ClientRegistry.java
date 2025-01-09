package com.bandw.registry;

import com.bandw.render.DarkEndermanRenderer;
import com.bandw.render.ShieldBlockEntityRenderer;
import com.bandw.effects.client.CorruptionStatusEffectRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Identifier;

public class ClientRegistry {
    public static void registerClientRenderers() {
        // Register entity renderer
        EntityRendererRegistry.register(ClientReferences.DARK_ENDERMAN, DarkEndermanRenderer::new);

        // Register block entity renderer
        BlockEntityRendererRegistry.INSTANCE.register(ClientReferences.SHIELD_OF_LIGHT_BLOCK_ENTITY, ShieldBlockEntityRenderer::new);

        // Register custom status effect renderer
    };
};