package com.beetmacol.santaniumdecorations.blocks;

import com.beetmacol.santaniumdecorations.BaubleBlock;
import com.beetmacol.santaniumdecorations.SantaniumDecorations;
import com.beetmacol.santaniumdecorations.items.Items;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
	public static final Block SANTANIUM_ORE = register("santanium_ore", new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).hardness(1.2f)
			.breakByTool(FabricToolTags.SHOVELS, 2).requiresTool().sounds(BlockSoundGroup.SNOW)), true);

	public static final Block WREATH = register("wreath", new WreathBlock(FabricBlockSettings.of(Material.LEAVES).hardness(0f).sounds(BlockSoundGroup.GRASS).nonOpaque()), true);
	public static final Block SANTANIUM_BLOCK = register("santanium_block", new Block(FabricBlockSettings.of(Material.STONE).resistance(1200.0f).slipperiness(1.1f).hardness(5.0f)), true);
	public static final Block BAUBLE_RED = register("bauble_red", new BaubleBlock(), true);
	public static final Block BAUBLE_BLACK = register("bauble_black", new BaubleBlock(), true);
	public static final Block BAUBLE_BLUE = register("bauble_blue", new BaubleBlock(), true);
	public static final Block BAUBLE_BROWN = register("bauble_brown", new BaubleBlock(), true);
	public static final Block BAUBLE_CYAN = register("bauble_cyan", new BaubleBlock(), true);
	public static final Block BAUBLE_GRAY = register("bauble_gray", new BaubleBlock(), true);
	public static final Block BAUBLE_GREEN = register("bauble_green", new BaubleBlock(), true);
	public static final Block BAUBLE_LIGHT_BLUE = register("bauble_light_blue", new BaubleBlock(), true);
	public static final Block BAUBLE_LIGHT_GRAY = register("bauble_light_gray", new BaubleBlock(), true);
	public static final Block BAUBLE_LIME = register("bauble_lime", new BaubleBlock(), true);
	public static final Block BAUBLE_MAGENTA = register("bauble_magenta", new BaubleBlock(), true);
	public static final Block BAUBLE_ORANGE = register("bauble_orange", new BaubleBlock(), true);
	public static final Block BAUBLE_PINK = register("bauble_pink", new BaubleBlock(), true);
	public static final Block BAUBLE_PURPLE = register("bauble_purple", new BaubleBlock(), true);
	public static final Block BAUBLE_WHITE = register("bauble_white", new BaubleBlock(), true);
	public static final Block BAUBLE_YELLOW = register("bauble_yellow", new BaubleBlock(), true);

	public static final Block WREATH_OAK_DOOR = register("wreath_oak_door", new WreathDoorBlock(net.minecraft.block.Blocks.OAK_DOOR, AbstractBlock.Settings.of(Material.WOOD, net.minecraft.block.Blocks.OAK_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_BIRCH_DOOR = register("wreath_birch_door", new WreathDoorBlock(net.minecraft.block.Blocks.BIRCH_DOOR, AbstractBlock.Settings.of(Material.WOOD, net.minecraft.block.Blocks.BIRCH_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_SPRUCE_DOOR = register("wreath_spruce_door", new WreathDoorBlock(net.minecraft.block.Blocks.SPRUCE_DOOR, AbstractBlock.Settings.of(Material.WOOD, net.minecraft.block.Blocks.SPRUCE_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_JUNGLE_DOOR = register("wreath_jungle_door", new WreathDoorBlock(net.minecraft.block.Blocks.JUNGLE_DOOR, AbstractBlock.Settings.of(Material.WOOD, net.minecraft.block.Blocks.JUNGLE_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_ACACIA_DOOR = register("wreath_acacia_door", new WreathDoorBlock(net.minecraft.block.Blocks.ACACIA_DOOR, AbstractBlock.Settings.of(Material.WOOD, net.minecraft.block.Blocks.ACACIA_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_DARK_OAK_DOOR = register("wreath_dark_oak_door", new WreathDoorBlock(net.minecraft.block.Blocks.DARK_OAK_DOOR, AbstractBlock.Settings.of(Material.WOOD, net.minecraft.block.Blocks.DARK_OAK_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_CRIMSON_DOOR = register("wreath_crimson_door", new WreathDoorBlock(net.minecraft.block.Blocks.CRIMSON_DOOR, AbstractBlock.Settings.of(Material.NETHER_WOOD, net.minecraft.block.Blocks.CRIMSON_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_WARPED_DOOR = register("wreath_warped_door", new WreathDoorBlock(net.minecraft.block.Blocks.WARPED_DOOR, AbstractBlock.Settings.of(Material.NETHER_WOOD, net.minecraft.block.Blocks.WARPED_PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()), false);
	public static final Block WREATH_IRON_DOOR = register("wreath_iron_door", new WreathDoorBlock(net.minecraft.block.Blocks.IRON_DOOR, AbstractBlock.Settings.of(Material.METAL, MaterialColor.IRON).requiresTool().strength(5.0F).sounds(BlockSoundGroup.METAL).nonOpaque()), false);

	public static Block register(String id, Block block, boolean blockItem) {
		if (blockItem)
			return register(id, block, new BlockItem(block, Items.getItemSettings()));
		else
			return Registry.register(Registry.BLOCK, new Identifier(SantaniumDecorations.MOD_ID, id), block);
	}

	public static Block register(String id, Block block, BlockItem blockItem) {
		Items.register(id, blockItem);
		return register(id, block, false);
	}

	public static void registerBlocks() {}
}
