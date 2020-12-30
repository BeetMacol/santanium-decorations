package com.beetmacol.santaniumdecorations.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprection")
public class WreathDoorBlock extends DoorBlock {
	public static final Map<Block, WreathDoorBlock> BY_DOOR = new HashMap<>();
	public static final Map<WreathDoorBlock, Block> BY_WREATH_DOOR = new HashMap<>();

	protected WreathDoorBlock(Block doorBlock, Settings settings) {
		super(settings);
		BY_DOOR.put(doorBlock, this);
		BY_WREATH_DOOR.put(this, doorBlock);
	}

	@Override
	public ActionResult onUse(BlockState wreathDoorBlockState, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack itemStackInHand = player.getStackInHand(hand);
		Item itemInHand = itemStackInHand.getItem();
		if (itemInHand == Items.SHEARS) {
			Block wreathDoorBlock = wreathDoorBlockState.getBlock();
			if (wreathDoorBlock instanceof WreathDoorBlock) {
				Block block = BY_WREATH_DOOR.get(wreathDoorBlock);
				if (block != null) {
					BlockState blockState = block.getDefaultState();
					for (Property property : blockState.getProperties())
						blockState = blockState.with(property, wreathDoorBlockState.get(property));
					if (!player.isCreative()) {
						itemStackInHand.setDamage(itemStackInHand.getDamage()+1);
					}
					dropStack(world, pos, new ItemStack(getWreathItem()));
					// TODO sound effect
					// world.playSound(null, pos, SoundEvents.DOOR_REMOVE_WREATH, SoundCategory.BLOCKS, 1f, 1f);
					world.setBlockState(pos, blockState);
					return ActionResult.SUCCESS;
				}
			}
		}
		return super.onUse(wreathDoorBlockState, world, pos, player, hand, hit);
	}

	public static Item getWreathItem() {
		return Blocks.WREATH.asItem();
	}

	public static BlockState byDoor(BlockState doorBlockState) {
		WreathDoorBlock block = BY_DOOR.get(doorBlockState.getBlock());
		if (block != null) {
			BlockState blockState = block.getDefaultState();
			for (Property property : blockState.getProperties())
				blockState = blockState.with(property, doorBlockState.get(property));
			return blockState;
		}
		return null;
	}
}
