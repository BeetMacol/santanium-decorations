package com.beetmacol.santaniumdecorations.mixin;

import com.beetmacol.santaniumdecorations.blocks.Blocks;
import com.beetmacol.santaniumdecorations.blocks.WreathDoorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.DoorBlock.*;

@Mixin(DoorBlock.class)
public class DoorBlockMixin extends Block {
	@Shadow @Final public static EnumProperty<DoubleBlockHalf> HALF;

	public DoorBlockMixin(Settings settings) {
		super(settings);
	}

	@Inject(method = "onUse", at = @At(value = "HEAD"), cancellable = true)
	public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
		ItemStack itemStackInHand = player.getStackInHand(hand);
		Item itemInHand = itemStackInHand.getItem();
		if (itemInHand == Blocks.WREATH.asItem()) {
			if (state.getBlock() instanceof DoorBlock) {
				BlockState blockState = WreathDoorBlock.byDoor(state);
				if (blockState != null) {
					if (!player.isCreative()) {
						itemStackInHand.decrement(1);
					}
					// TODO sound effect
					// world.playSound(null, pos, SoundEvents.DOOR_PLACE_WREATH, SoundCategory.BLOCKS, 1f, 1f);
					world.setBlockState(pos, blockState);
					cir.setReturnValue(ActionResult.SUCCESS);
				}
			}
		}
	}

	/**
	 * Why overwriting requires javadoc???
	 * @author BeetMacol
	 */
	@Overwrite
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		DoubleBlockHalf doubleBlockHalf = state.get(HALF);
		if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
			Block oppositeWreathedBlock = getOppositeWreathedBlock((DoorBlock) (Object) this);
			boolean neighborIsOppositeWreathed = newState.isOf(oppositeWreathedBlock);
			if ((newState.isOf((DoorBlock) (Object) this) || neighborIsOppositeWreathed) && newState.get(HALF) != doubleBlockHalf) {
				if (neighborIsOppositeWreathed) {
					state = oppositeWreathedBlock.getDefaultState();
				}
				return state.with(HALF, getOppositeHalf(newState.get(HALF))).with(FACING, newState.get(FACING)).with(OPEN, newState.get(OPEN)).with(HINGE, newState.get(HINGE)).with(POWERED, newState.get(POWERED));
			} else {
				return net.minecraft.block.Blocks.AIR.getDefaultState();
			}
		} else {
			return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? net.minecraft.block.Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
		}
	}

	private DoubleBlockHalf getOppositeHalf(DoubleBlockHalf half) {
		return (half == DoubleBlockHalf.UPPER) ? DoubleBlockHalf.LOWER : DoubleBlockHalf.UPPER;
	}

	private Block getOppositeWreathedBlock(Block block) {
		if (block instanceof WreathDoorBlock) {
			return WreathDoorBlock.BY_WREATH_DOOR.get(block);
		} else if (block instanceof DoorBlock) {
			return WreathDoorBlock.BY_DOOR.get(block);
		} else {
			return null;
		}
	}
}
