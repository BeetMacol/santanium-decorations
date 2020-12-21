package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {
	Logger logger = LogManager.getLogger(SantaniumDecorations.class);

	public static String MODID = "santanium-decorations";

	public static final Block SANTANIUM_ORE = new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_ORE));

	@Override
	public void onInitialize() {
		logger.info("HO HO HO!");

		Registry.register(Registry.BLOCK, new Identifier(MODID, "santanium_ore"), SANTANIUM_ORE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "santanium_ore"), new BlockItem(SANTANIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
