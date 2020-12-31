package com.beetmacol.santaniumdecorations.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class ChristmasSocksBlock extends HorizontalFacingBlock {
	public static final IntProperty SOCKS = IntProperty.of("socks", 1, 3);

	public ChristmasSocksBlock(Settings settings) {
		super(settings);
		setDefaultState(getStateManager().getDefaultState().with(SOCKS, 1).with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		Direction direction = state.get(FACING);
		BlockPos blockPos = pos.offset(direction.getOpposite());
		BlockState blockState = world.getBlockState(blockPos);
		return direction.getAxis().isHorizontal() && blockState.isSideSolidFullSquare(world, blockPos, direction);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(SOCKS);
		builder.add(Properties.HORIZONTAL_FACING);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack itemStackInHand = player.getStackInHand(hand);
		Item itemInHand = itemStackInHand.getItem();
		if (itemInHand == this.asItem()) {
			if (state.get(SOCKS) >= 3) return ActionResult.PASS;
			if (!player.isCreative())
				itemStackInHand.decrement(1);
			world.playSound(null, pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1f, 1f);
			world.setBlockState(pos, state.with(SOCKS, state.get(SOCKS) + 1));
			return ActionResult.SUCCESS;
		}
		return ActionResult.PASS;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		switch (state.get(SOCKS)) {
			default:
				return Blocks.rotatedCuboid(state.get(FACING), 0.3125f, 0.4375f, 1-0.125f, 1-0.3125f, 1f, 1f);
			case 2:
				return Blocks.rotatedCuboid(state.get(FACING), 1-0.125f, 0.375f, 1-0.125f, 0.0625f, 1f, 1f);
			case 3:
				return Blocks.rotatedCuboid(state.get(FACING), 0f, 0.25f, 1-0.125f, 1f, 1f, 1f);
		}
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? net.minecraft.block.Blocks.AIR.getDefaultState() : state;
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		BlockState blockState = this.getDefaultState();
		WorldView worldView = ctx.getWorld();
		BlockPos blockPos = ctx.getBlockPos();
		Direction[] directions = ctx.getPlacementDirections();
		Direction[] var6 = directions;
		int var7 = directions.length;

		for(int var8 = 0; var8 < var7; ++var8) {
			Direction direction = var6[var8];
			if (direction.getAxis().isHorizontal()) {
				Direction direction2 = direction.getOpposite();
				blockState = (BlockState)blockState.with(FACING, direction2);
				if (blockState.canPlaceAt(worldView, blockPos)) {
					return blockState;
				}
			}
		}

		return null;
	}
}
