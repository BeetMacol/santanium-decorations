package com.beetmacol.santaniumdecorations;

import com.beetmacol.santaniumdecorations.blocks.Blocks;
import com.beetmacol.santaniumdecorations.entities.Entities;
import com.beetmacol.santaniumdecorations.items.Items;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {

	public static final String MOD_ID = "santaniumdecorations";
	public static final Logger LOGGER = LogManager.getLogger(SantaniumDecorations.class);

	@Override
	public void onInitialize() {
		LOGGER.info("HO HO HO!");
		Items.registerItems();
		Blocks.registerBlocks();
		Entities.registerEntities();
	}
}
