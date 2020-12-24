package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SantaniumDecorationsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(SantaniumDecorations.SANTA_SLIME, (entityRenderDispatcher, context) -> {
            return new SantaSlimeEntityRender(entityRenderDispatcher);
        });
    }
}
