package com.beetmacol.santaniumdecorations.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
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

import java.util.Random;

@SuppressWarnings("deprecation")
public class PresentBlock extends HorizontalFacingBlock implements BlockEntityProvider {
	public static final BooleanProperty EMPTY = BooleanProperty.of("empty");

	public PresentBlock(Settings settings) {
		super(settings);
		setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(EMPTY, true));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (state.get(EMPTY)) {
			ItemStack itemStackInHand = player.getStackInHand(hand);
			if (!itemStackInHand.isEmpty()) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity instanceof PresentBlockEntity) {
					((PresentBlockEntity) blockEntity).setContent(itemStackInHand);
					if (!player.isCreative()) {
						player.setStackInHand(hand, ItemStack.EMPTY);
					}
					world.setBlockState(pos, state.with(EMPTY, false));
					return ActionResult.SUCCESS;
				}
			}
		} else {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof PresentBlockEntity) {
				world.removeBlock(pos, false);
				Random r = new Random();
				for(int i = 0; i < 75; i++) {
					world.addParticle(ParticleTypes.FIREWORK, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, ((r.nextFloat() * 2.0f) - 1.0f) * 0.35f, ((r.nextFloat() * 2.0f) - 1.0f) * 0.35f, ((r.nextFloat() * 2.0f) - 1.0f) * 0.35f);
				}
				dropStack(world, pos, ((PresentBlockEntity) blockEntity).getContent());
				return ActionResult.SUCCESS;
			}
		}
		return ActionResult.PASS;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return Blocks.rotatedCuboid(state.get(FACING), 0.125f, 0f, 0.125f, 1-0.125f, 1-0.1875f, 1-0.125f);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(Properties.HORIZONTAL_FACING);
		builder.add(EMPTY);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return !state.canPlaceAt(world, pos) ? net.minecraft.block.Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return !world.isAir(pos.down());
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

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new PresentBlockEntity();
	}
}
