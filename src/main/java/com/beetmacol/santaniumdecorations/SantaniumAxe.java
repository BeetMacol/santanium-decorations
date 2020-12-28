package com.beetmacol.santaniumdecorations;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class SantaniumAxe extends AxeItem {
    protected SantaniumAxe() {
        super(SantaniumToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP));
    }
}
