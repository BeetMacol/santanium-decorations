package com.beetmacol.santaniumdecorations.entities;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.util.Identifier;

public class SantaMassEntityRender extends MobEntityRenderer<SantaMassEntity, SlimeEntityModel<SantaMassEntity>> {
	public SantaMassEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
		super(entityRenderDispatcher, new SlimeEntityModel<>(1), 1.0F);
	}

	@Override
	public Identifier getTexture(SantaMassEntity entity) {
		return new Identifier("santaniumdecorations", "textures/entity/santa_mass.png");
	}
}
