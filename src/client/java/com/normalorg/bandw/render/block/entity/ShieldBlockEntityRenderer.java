package com.normalorg.bandw.render.block.entity;

import com.normalorg.bandw.DefianceClient;
import com.normalorg.bandw.block.ShieldBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.systems.RenderSystem;
public class ShieldBlockEntityRenderer implements BlockEntityRenderer<ShieldBlockEntity> {
    private static final Identifier TEXTURE = Identifier.of(DefianceClient.MOD_ID,"textures/block/shield.png");
    public ShieldBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super();
    };
    @Override
    public void render(ShieldBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        BlockPos pos = entity.getPos();
        double camX = MinecraftClient.getInstance().gameRenderer.getCamera().getPos().x;
        double camY = MinecraftClient.getInstance().gameRenderer.getCamera().getPos().y;
        double camZ = MinecraftClient.getInstance().gameRenderer.getCamera().getPos().z;
        matrices.translate((pos.getX()-(float) camX) + 0.5, (pos.getY()-(float) camY) + 0.5, (pos.getZ()-(float) camZ) + 0.5);
        float size = MathHelper.clamp(entity.getShield().getSize(), 1.0F, 200.0F);
        matrices.scale(size, size, size);
        renderCube(matrices, vertexConsumers, light, overlay, TEXTURE, size);
        matrices.pop();
    };
    public void renderCube(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Identifier texture, float cube_size) {
        matrices.push();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(texture));
        float size = 0.5f;
        Vec3d[] vertices = {
            new Vec3d(-size, -size, -size), // Bottom-left-back
            new Vec3d(size, -size, -size),  // Bottom-right-back
            new Vec3d(size, size, -size),   // Top-right-back
            new Vec3d(-size, size, -size),  // Top-left-back
            new Vec3d(-size, -size, size),  // Bottom-left-front
            new Vec3d(size, -size, size),   // Bottom-right-front
            new Vec3d(size, size, size),    // Top-right-front
            new Vec3d(-size, size, size)    // Top-left-front
        };
        int[][] faces = {
            {0, 1, 2, 3}, // Back
            {4, 5, 6, 7}, // Front
            {0, 1, 5, 4}, // Bottom
            {2, 3, 7, 6}, // Top
            {0, 4, 7, 3}, // Left
            {1, 5, 6, 2}  // Right
        };
        float tileFactor=cube_size; // Number of texture tiles per block unit.
        float uMin=0.0F;
        float uMax=size*tileFactor;
        float[][] uvs = {
            {uMin, uMin, uMax, uMin, uMax, uMax, uMin, uMax}, // Back face
            {uMin, uMin, uMax, uMin, uMax, uMax, uMin, uMax}, // Front face
            {uMin, uMin, uMax, uMin, uMax, uMax, uMin, uMax}, // Bottom face
            {uMin, uMin, uMax, uMin, uMax, uMax, uMin, uMax}, // Top face
            {uMin, uMin, uMax, uMin, uMax, uMax, uMin, uMax}, // Left face
            {uMin, uMin, uMax, uMin, uMax, uMax, uMin, uMax}  // Right face
        };
        for (int faceIndex = 0; faceIndex < faces.length; faceIndex++) {
            int[] face = faces[faceIndex];
            float[] uv = uvs[faceIndex];
            for (int i = 0; i < 4; i++) {
                Vec3d vertex = vertices[face[i]];
                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), (float) vertex.getX(), (float) vertex.getY(), (float) vertex.getZ())
                    .color(255, 255, 255, 255)
                    .texture(uv[i * 2], uv[i * 2 + 1])
                    .overlay(overlay)
                    .light(light)
                    .normal(0, 1, 0);
            };
        };
        matrices.pop();
    };
};