package com.beetmacol.santaniumdecorations;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

	public static final ItemGroup SANTANIUM_DECORATIONS_ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier(SantaniumDecorations.MOD_ID, "items")).icon(() -> new ItemStack(Items.SANTANIUM_INGOT)).build();
	public static final Item SANTANIUM_INGOT = register("santanium_ingot");
	public static final Item SANTANIUM_ESSENCE = register("santanium_essence");
	public static final Item SANTANIUM_GEL = register("santanium_gel");

	private static Item register(String id) {
		return Registry.register(Registry.ITEM, new Identifier(SantaniumDecorations.MOD_ID, id),  new Item(new FabricItemSettings().group(SANTANIUM_DECORATIONS_ITEM_GROUP)));
	}

	public static void registerItems() {}
}
