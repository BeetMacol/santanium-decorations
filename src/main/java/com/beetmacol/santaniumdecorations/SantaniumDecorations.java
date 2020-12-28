package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {

	public static final String MOD_ID = "santaniumdecorations";
	public static final Logger LOGGER = LogManager.getLogger(SantaniumDecorations.class);

	public static final EntityType<SantaMassEntity> SANTA_MASS = Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "santa_mass"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SantaMassEntity::new).dimensions(EntityDimensions.fixed(1, 1)).build());

	@Override
	public void onInitialize() {
		LOGGER.info("HO HO HO!");
		Items.registerItems();
		SantaniumOre.registerItems();

		FabricDefaultAttributeRegistry.register(SANTA_MASS, SantaMassEntity.createMobAttributes());
	}
}
