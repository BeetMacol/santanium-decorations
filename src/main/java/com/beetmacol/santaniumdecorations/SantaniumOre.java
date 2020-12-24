package com.beetmacol.santaniumdecorations;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SantaniumOre {
	public static final Block SANTANIUM_ORE = new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).hardness(1.2f)
			.breakByTool(FabricToolTags.SHOVELS, 2).requiresTool().sounds(BlockSoundGroup.SNOW));

	public static void registerItems() {
		Registry.register(Registry.BLOCK, new Identifier(SantaniumDecorations.MOD_ID, "santanium_ore"), SANTANIUM_ORE);
		Registry.register(Registry.ITEM, new Identifier(SantaniumDecorations.MOD_ID, "santanium_ore"),
				new BlockItem(SANTANIUM_ORE, new Item.Settings().group(Items.SANTANIUM_DECORATIONS_ITEM_GROUP)));
	}
}
