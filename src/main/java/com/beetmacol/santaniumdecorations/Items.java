package com.beetmacol.santaniumdecorations;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.beetmacol.santaniumdecorations.SantaniumDecorations.SANTA_MASS;

public class Items {

	public static final ItemGroup SANTANIUM_DECORATIONS_ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier(SantaniumDecorations.MOD_ID, "items")).icon(() -> new ItemStack(Items.SANTANIUM_INGOT)).build();
	public static final Item SANTANIUM_INGOT = register("santanium_ingot");
	public static final Item SANTANIUM_ESSENCE = register("santanium_essence");
	public static final Item SANTANIUM_GEL = register("santanium_gel");
	public static final Item SANTA_MASS_SPAWN_EGG = register("santa_mass_spawn_egg", new SpawnEggItem(SANTA_MASS, 0x0DA70B, 0x73420E, getItemSettings()));


	private static Item.Settings getItemSettings() {
		return new FabricItemSettings().group(SANTANIUM_DECORATIONS_ITEM_GROUP);
	}

	private static Item register(String id) {
		return register(id, new Item(getItemSettings()));
	}

	private static Item register(String id, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(SantaniumDecorations.MOD_ID, id), item);
	}

	public static void registerItems() {}
}
