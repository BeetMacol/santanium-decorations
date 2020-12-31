package com.beetmacol.santaniumdecorations.blocks;

import com.beetmacol.santaniumdecorations.SantaniumDecorations;
import com.beetmacol.santaniumdecorations.items.Items;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

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

	public static final Block WHITE_CHRISTMAS_SOCKS = registerSocks("white_christmas_socks", MaterialColor.WHITE);
	public static final Block ORANGE_CHRISTMAS_SOCKS = registerSocks("orange_christmas_socks", MaterialColor.ORANGE);
	public static final Block MAGENTA_CHRISTMAS_SOCKS = registerSocks("magenta_christmas_socks", MaterialColor.MAGENTA);
	public static final Block LIGHT_BLUE_CHRISTMAS_SOCKS = registerSocks("light_blue_christmas_socks", MaterialColor.LIGHT_BLUE);
	public static final Block YELLOW_CHRISTMAS_SOCKS = registerSocks("yellow_christmas_socks", MaterialColor.YELLOW);
	public static final Block LIME_CHRISTMAS_SOCKS = registerSocks("lime_christmas_socks", MaterialColor.LIME);
	public static final Block PINK_CHRISTMAS_SOCKS = registerSocks("pink_christmas_socks", MaterialColor.PINK);
	public static final Block GRAY_CHRISTMAS_SOCKS = registerSocks("gray_christmas_socks", MaterialColor.GRAY);
	public static final Block LIGHT_GRAY_CHRISTMAS_SOCKS = registerSocks("light_gray_christmas_socks", MaterialColor.LIGHT_GRAY);
	public static final Block CYAN_CHRISTMAS_SOCKS = registerSocks("cyan_christmas_socks", MaterialColor.CYAN);
	public static final Block PURPLE_CHRISTMAS_SOCKS = registerSocks("purple_christmas_socks", MaterialColor.PURPLE);
	public static final Block BLUE_CHRISTMAS_SOCKS = registerSocks("blue_christmas_socks", MaterialColor.BLUE);
	public static final Block BROWN_CHRISTMAS_SOCKS = registerSocks("brown_christmas_socks", MaterialColor.BROWN);
	public static final Block GREEN_CHRISTMAS_SOCKS = registerSocks("green_christmas_socks", MaterialColor.GREEN);
	public static final Block RED_CHRISTMAS_SOCKS = registerSocks("red_christmas_socks", MaterialColor.RED);
	public static final Block BLACK_CHRISTMAS_SOCKS = registerSocks("black_christmas_socks", MaterialColor.BLACK);

	public static final Block STAR = register("star", new StarBlock(), true);

	/**
	 * Can be used for outline shapes of directional blocks
	 * @param direction the direction it will be rotated
	 * @param xMin north xMin
	 * @param yMin north yMin
	 * @param zMin north zMin
	 * @param xMax north xMax
	 * @param yMax north yMax
	 * @param zMax north zMax
	 * @return rotated VoxelShape
	 */
	public static VoxelShape rotatedCuboid(Direction direction, double xMin, double yMin, double zMin, double xMax, double yMax, double zMax) {
		switch (direction) {
			case NORTH:
				return VoxelShapes.cuboid(xMin, yMin, zMin, xMax, yMax, zMax);
			case SOUTH:
				return VoxelShapes.cuboid(xMax, yMin, 1-zMin, xMin, yMax, 1-zMax);
			case WEST:
				return VoxelShapes.cuboid(zMin, yMin, xMin, zMax, yMax, xMax);
			case EAST:
				return VoxelShapes.cuboid(1-zMin, yMin, xMin, 1-zMax, yMax, xMax);
		}
		throw new IllegalArgumentException("Incorrect direction argument.");
	}

	public static Block registerSocks(String id, MaterialColor materialColor) {
		return register(id, new ChristmasSocksBlock(FabricBlockSettings.of(Material.WOOL, materialColor).hardness(0f).sounds(BlockSoundGroup.WOOL).nonOpaque()), true);
	}

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
