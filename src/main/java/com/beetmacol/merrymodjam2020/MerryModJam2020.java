package com.beetmacol.merrymodjam2020;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MerryModJam2020 implements ModInitializer {
	Logger logger = LogManager.getLogger(MerryModJam2020.class);

	@Override
	public void onInitialize() {
		logger.info("HO HO HO!");
	}
}
