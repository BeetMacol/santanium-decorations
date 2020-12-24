package com.beetmacol.santaniumdecorations;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.util.Identifier;

public class SantaSlimeEntityRender extends MobEntityRenderer<SantaSlimeEntity, SlimeEntityModel<SantaSlimeEntity>> {

    public SantaSlimeEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new SlimeEntityModel<SantaSlimeEntity>(1), 1.0f);
    }

    @Override
    public Identifier getTexture(SantaSlimeEntity entity) {
        return new Identifier("santaniumdecorations", "textures/entity/santa_slime.png");
    }
}
