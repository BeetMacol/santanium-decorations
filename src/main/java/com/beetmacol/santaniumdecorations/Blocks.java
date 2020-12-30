package com.beetmacol.santaniumdecorations;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static final Block BAUBLE_RED = register("bauble_red", new BaubleBlock());

    private static Block register(String id, Block block) {
        Registry.register(Registry.ITEM, new Identifier(SantaniumDecorations.MOD_ID, id),
                new BlockItem(block, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP)));
        return Registry.register(Registry.BLOCK, new Identifier(SantaniumDecorations.MOD_ID, id), block);
    }

    public static void registerBlocks() {}
}
