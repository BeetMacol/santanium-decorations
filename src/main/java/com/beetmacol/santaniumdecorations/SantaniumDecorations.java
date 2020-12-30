package com.beetmacol.santaniumdecorations;

import com.beetmacol.santaniumdecorations.blocks.Blocks;
import com.beetmacol.santaniumdecorations.entities.Entities;
import com.beetmacol.santaniumdecorations.items.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.impl.biome.modification.BiomeModificationImpl;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SantaniumDecorations implements ModInitializer {

	public static final String MOD_ID = "santaniumdecorations";
	public static final Logger LOGGER = LogManager.getLogger(SantaniumDecorations.class);

	public static ConfiguredFeature<?, ?> SANTANIUM_ORE_SPAWNER = Feature.ORE.configure(new OreFeatureConfig(
			OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
			Blocks.SANTANIUM_ORE.getDefaultState(),
			9)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0, 0, 64))).spreadHorizontally().repeat(7);

	@Override
	public void onInitialize() {
		LOGGER.info("HO HO HO!");
		Items.registerItems();
		Blocks.registerBlocks();
		Entities.registerEntities();

		RegistryKey<ConfiguredFeature<?, ?>> santaniumOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(MOD_ID, "santanium_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, santaniumOreOverworld.getValue(), SANTANIUM_ORE_SPAWNER);
		List<RegistryKey<Biome>> snowy_biomes = new ArrayList<>();
		snowy_biomes.add(BiomeKeys.SNOWY_BEACH);
		snowy_biomes.add(BiomeKeys.SNOWY_MOUNTAINS);
		snowy_biomes.add(BiomeKeys.SNOWY_TAIGA);
		snowy_biomes.add(BiomeKeys.SNOWY_TAIGA_HILLS);
		snowy_biomes.add(BiomeKeys.SNOWY_TAIGA_MOUNTAINS);
		snowy_biomes.add(BiomeKeys.SNOWY_TUNDRA);
		snowy_biomes.add(BiomeKeys.ICE_SPIKES);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(snowy_biomes), GenerationStep.Feature.UNDERGROUND_STRUCTURES, santaniumOreOverworld);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(snowy_biomes), SpawnGroup.MONSTER, Entities.SANTA_MASS, 100, 2, 4);
	}
}
