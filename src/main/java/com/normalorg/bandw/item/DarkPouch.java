package com.normalorg.bandw.item;

import com.normalorg.bandw.Defiance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.Item.Settings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ThrowablePotionItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import java.util.List;

public class DarkPouch extends ThrowablePotionItem {
    public DarkPouch(Item.Settings settings){
        super(settings);
    };
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.bandw.dark_pouch").formatted(Formatting.GOLD,Formatting.ITALIC));
        super.appendTooltip(stack, context, tooltip, type);
    };
};