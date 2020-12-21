package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {
	Logger logger = LogManager.getLogger(SantaniumDecorations.class);

	@Override
	public void onInitialize() {
		logger.info("HO HO HO!");
	}
}
