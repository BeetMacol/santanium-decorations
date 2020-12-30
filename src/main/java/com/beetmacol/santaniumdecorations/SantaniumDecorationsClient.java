package com.beetmacol.santaniumdecorations;

import com.beetmacol.santaniumdecorations.entities.Entities;
import com.beetmacol.santaniumdecorations.entities.SantaMassEntityRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SantaniumDecorationsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This should be moved from here later but i am too lazy to make it clientside only there and etc
        EntityRendererRegistry.INSTANCE.register(Entities.SANTA_MASS, (entityRenderDispatcher, context) -> {
            return new SantaMassEntityRender(entityRenderDispatcher);
        });
    }
}
