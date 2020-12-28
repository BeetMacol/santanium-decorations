package com.beetmacol.santaniumdecorations;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class SantaniumHoe extends HoeItem {
    protected SantaniumHoe() {
        super(SantaniumToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP));
    }
}
