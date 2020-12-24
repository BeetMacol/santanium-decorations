package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {

	public static final String MOD_ID = "santaniumdecorations";
	public static final Logger LOGGER = LogManager.getLogger(SantaniumDecorations.class);

	@Override
	public void onInitialize() {
		LOGGER.info("HO HO HO!");
		Items.registerItems();
		SantaniumOre.registerItems();
	}
}
