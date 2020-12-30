package com.beetmacol.santaniumdecorations.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SantaMassEntityRender extends MobEntityRenderer<SantaMassEntity, SlimeEntityModel<SantaMassEntity>> {
	public SantaMassEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
		super(entityRenderDispatcher, new SlimeEntityModel(16), 0.25F);
		this.addFeature(new SlimeOverlayFeatureRenderer(this));
	}

	@Override
	public Identifier getTexture(SantaMassEntity entity) {
		return new Identifier("santaniumdecorations", "textures/entity/santa_mass.png");
	}
}
