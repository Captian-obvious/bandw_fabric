package com.normalorg.bandw.mixin;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.item.PureDivinity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin{
    @Inject(method = "damage", at = @At("HEAD"))
    private void onDamage(ServerWorld world,DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if ((Object)this instanceof LivingEntity target && !target.getWorld().isClient) {
            float resultingHealth = target.getHealth() - amount;
            if (resultingHealth <= 0.0F && source.getAttacker() instanceof PlayerEntity attacker) {
                ItemStack used = attacker.getMainHandStack();
                if (!(used.getItem() instanceof PureDivinity)) {
                    for (ItemStack stack : attacker.getInventory().main) {
                        if (stack.getItem() instanceof PureDivinity pureDivinity) {
                            if (pureDivinity.isEnabled()) {
                                pureDivinity.onKill(target, attacker);
                                break;
                            };
                        };
                    };
                };
            };
        };
    };
};