package com.bandw.render;

import com.bandw.ClientMain;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
public class ShieldRenderer extends BlockEntityRenderer<ShieldBlockEntity> {
    private static final Identifier TEXTURE = new Identifier(ClientMain.MOD_ID,"textures/entity/shield.png");
    public ShieldRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    };
    @Override
    public void render(ShieldBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        // Push the current transformation matrix
        matrices.push();

        // Translate to the center of the block
        BlockPos pos = entity.getPos();
        matrices.translate(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);

        // Scale the cube based on the shield size
        float size = MathHelper.clamp(entity.getShield().getSize(), 1.0F, 100.0F); // Adjust the max size as needed
        matrices.scale(size, size, size);
        // Render the cube with your texture
        renderCube(matrices, vertexConsumers, light, overlay, TEXTURE);
        // Pop the transformation matrix
        matrices.pop();
    };
    public void renderCube(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Identifier texture) {
        matrices.push();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntitySolid(texture));
        float size = 0.5f;
        Vec3f[] vertices = {
            new Vec3f(-size, -size, -size), // Bottom-left-back
            new Vec3f(size, -size, -size),  // Bottom-right-back
            new Vec3f(size, size, -size),   // Top-right-back
            new Vec3f(-size, size, -size),  // Top-left-back
            new Vec3f(-size, -size, size),  // Bottom-left-front
            new Vec3f(size, -size, size),   // Bottom-right-front
            new Vec3f(size, size, size),    // Top-right-front
            new Vec3f(-size, size, size)    // Top-left-front
        };

        int[][] faces = {
            {0, 1, 2, 3}, // Back
            {4, 5, 6, 7}, // Front
            {0, 1, 5, 4}, // Bottom
            {2, 3, 7, 6}, // Top
            {0, 4, 7, 3}, // Left
            {1, 5, 6, 2}  // Right
        };

        for (int[] face : faces) {
            for (int i = 0; i < 4; i++) {
                Vec3f vertex = vertices[face[i]];
                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), vertex.getX(), vertex.getY(), vertex.getZ())
                    .color(255, 255, 255, 255)
                    .texture(0, 0)
                    .overlay(overlay)
                    .light(light)
                    .normal(0, 1, 0)
                    .next();
            };
        };
        matrices.pop();
    };
};