package com.beetmacol.santaniumdecorations.blocks;

import com.beetmacol.santaniumdecorations.BaubleBlock;
import com.beetmacol.santaniumdecorations.SantaniumDecorations;
import com.beetmacol.santaniumdecorations.items.Items;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
	public static final Block SANTANIUM_ORE = register("santanium_ore", new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).hardness(1.2f)
			.breakByTool(FabricToolTags.SHOVELS, 2).requiresTool().sounds(BlockSoundGroup.SNOW)));
	public static final Block BAUBLE_RED = register("bauble_red", new BaubleBlock());

	public static Block register(String id, Block block) {
		Items.register(id, new BlockItem(block, Items.getItemSettings()));
		return Registry.register(Registry.BLOCK, new Identifier(SantaniumDecorations.MOD_ID, id), block);
	}

	public static void registerBlocks() {}
}
