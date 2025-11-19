package com.normalorg.bandw.item.magic;

import com.normalorg.bandw.Defiance;
import com.normalorg.bandw.sound.ModSounds;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import com.normalorg.bandw.world.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.TeleportTarget;
import net.minecraft.sound.SoundCategory;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import java.util.List;
import java.util.Set;

public class ScrollItem extends Item {
    public ScrollItem(Settings settings) {
        super(settings);
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("itemTooltip.bandw.scroll").formatted(Formatting.GRAY));
        super.appendTooltip(stack, context, tooltip, type);
    };
};