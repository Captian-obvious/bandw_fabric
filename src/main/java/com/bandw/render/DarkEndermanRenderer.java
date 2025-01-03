package com.bandw.render;

import com.bandw.Main;
import com.bandw.entities.DarkEndermanEntity;
import com.bandw.entities.DarkEndermanModel;
import com.bandw.registry.ModModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class DarkEndermanRenderer extends MobEntityRenderer<DarkEndermanEntity, DarkEndermanModel> {
    private static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/dark_enderman.png");

    public DarkEndermanRenderer(EntityRendererFactory.Context context) {
        super(context, new DarkEndermanModel(context.getPart(ModModelLayers.DARK_ENDERMAN_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(DarkEndermanEntity entity) {
        return TEXTURE;
    };
};