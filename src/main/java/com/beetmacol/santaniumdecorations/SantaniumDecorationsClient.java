package com.beetmacol.santaniumdecorations;

import com.beetmacol.santaniumdecorations.blocks.Blocks;
import com.beetmacol.santaniumdecorations.entities.Entities;
import com.beetmacol.santaniumdecorations.entities.SantaMassEntityRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class SantaniumDecorationsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This should be moved from here later but i am too lazy to make it clientside only there and etc
        EntityRendererRegistry.INSTANCE.register(Entities.SANTA_MASS, (entityRenderDispatcher, context) -> {
            return new SantaMassEntityRender(entityRenderDispatcher);
        });
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_OAK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_BIRCH_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_SPRUCE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_JUNGLE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_ACACIA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_DARK_OAK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_CRIMSON_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_WARPED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WREATH_IRON_DOOR, RenderLayer.getCutout());
    }
}
