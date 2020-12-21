package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {

	public static final String MOD_ID = "santaniumdecorations";
	public static final Logger LOGGER = LogManager.getLogger(SantaniumDecorations.class);

	public static final Block SANTANIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

	@Override
	public void onInitialize() {
		LOGGER.info("HO HO HO!");
		Items.registerItems();

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "santanium_ore"), SANTANIUM_ORE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "santanium_ore"), new BlockItem(SANTANIUM_ORE, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP)));
	}
}
