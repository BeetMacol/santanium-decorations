package com.beetmacol.santaniumdecorations;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class SantaniumPickaxe extends PickaxeItem {
    protected SantaniumPickaxe() {
        super(SantaniumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP));
    }
}
