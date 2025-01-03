package com.bandw.utils;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class ElectricArcUtil {
    private static final Random RANDOM = new Random();

    public static void createElectricArc(ClientWorld world, Vec3d start, Vec3d end, float offsetMultiplier, float arcWidth) {
        int steps = 20;
        Vec3d diff = end.subtract(start);
        Vec3d direction = diff.normalize();
        Vec3d perpendicular = direction.crossProduct(new Vec3d(0, 1, 0)).normalize();

        for (int i = 0; i < steps; i++) {
            double t = (double) i / (steps - 1);
            Vec3d point = start.lerp(end, t);
            double offset = (RANDOM.nextDouble() - 0.5) * offsetMultiplier;
            Vec3d offsetVector = perpendicular.multiply(offset * arcWidth);

            world.addParticle(ParticleTypes.ELECTRIC_SPARK, point.x + offsetVector.x, point.y + offsetVector.y, point.z + offsetVector.z, 0, 0, 0);
        };
    };
};