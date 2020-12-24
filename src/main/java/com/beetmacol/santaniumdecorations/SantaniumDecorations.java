package com.beetmacol.santaniumdecorations;

import net.fabricmc.api.ModInitializer;
<<<<<<< Updated upstream
=======
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
>>>>>>> Stashed changes
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SantaniumDecorations implements ModInitializer {

	public static final String MOD_ID = "santaniumdecorations";
	public static final Logger LOGGER = LogManager.getLogger(SantaniumDecorations.class);

<<<<<<< Updated upstream
=======
	public static final Block SANTANIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

	public static final EntityType<SantaSlimeEntity> SANTA_SLIME = Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "santa_slime"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SantaSlimeEntity::new).dimensions(EntityDimensions.fixed(1, 1)).build());

>>>>>>> Stashed changes
	@Override
	public void onInitialize() {
		LOGGER.info("HO HO HO!");
		Items.registerItems();
<<<<<<< Updated upstream
		SantaniumOre.registerItems();
=======

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "santanium_ore"), SANTANIUM_ORE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "santanium_ore"), new BlockItem(SANTANIUM_ORE, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "santa_slime_spawn_egg"), new SpawnEggItem(SANTA_SLIME, 0x0DA70B, 0x73420E, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP)));

		FabricDefaultAttributeRegistry.register(SANTA_SLIME, SantaSlimeEntity.createMobAttributes());
>>>>>>> Stashed changes
	}
}
