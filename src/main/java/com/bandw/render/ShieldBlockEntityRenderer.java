package com.bandw.render;

import com.bandw.ClientMain;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.util.math.Direction;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
public class ShieldBlockEntityRenderer extends BlockEntityRenderer<ShieldBlockEntity> {
    private static final Identifier TEXTURE = Identifier.of(ClientMain.MOD_ID,"textures/entity/shield.png");
    public ShieldBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
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
        // Corresponding UV coordinates for the vertices of each face
        float[][] uvs = {
            {0, 0, 1, 0, 1, 1, 0, 1}, // Back
            {0, 0, 1, 0, 1, 1, 0, 1}, // Front
            {0, 0, 1, 0, 1, 1, 0, 1}, // Bottom
            {0, 0, 1, 0, 1, 1, 0, 1}, // Top
            {0, 0, 1, 0, 1, 1, 0, 1}, // Left
            {0, 0, 1, 0, 1, 1, 0, 1}  // Right
        };
        for (int faceIndex = 0; faceIndex < faces.length; faceIndex++) {
            int[] face = faces[faceIndex];
            float[] uv = uvs[faceIndex];
            for (int i = 0; i < 4; i++) {
                vec3f vertex = vertices[face[i]];
                vertexConsumer.vertex(matrices.peek().getPositionMatrix(), vertex.getX(), vertex.getY(), vertex.getZ())
                    .color(255, 255, 255, 255)
                    .texture(uv[i * 2], uv[i * 2 + 1]) // Set the texture coordinates
                    .overlay(overlay)
                    .light(light)
                    .normal(0, 1, 0)
                    .next();
            };
        };
        // Pop the transformation matrix
        matrices.pop();
    };
};
