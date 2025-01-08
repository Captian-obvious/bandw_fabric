package com.bandw.render;

import com.bandw.Main;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class ShieldRenderer extends BlockEntityRenderer<ShieldBlockEntity> {
    private static final Identifier TEXTURE = new Identifier(Main.MOD_ID,"textures/entity/shield.png");
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

    private void renderCube(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Identifier texture) {
        // Bind the texture and render a cube (you'll need to define this part yourself)
    };
}