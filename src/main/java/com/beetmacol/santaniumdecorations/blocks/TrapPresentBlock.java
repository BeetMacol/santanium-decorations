package com.beetmacol.santaniumdecorations.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TrapPresentBlock extends PresentBlock {

	public TrapPresentBlock(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		world.removeBlock(pos, false);
		Random r = new Random();
		for(int i = 0; i < 75; i++) {
			world.addParticle(ParticleTypes.FIREWORK, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, ((r.nextFloat() * 2.0f) - 1.0f) * 0.35f, ((r.nextFloat() * 2.0f) - 1.0f) * 0.35f, ((r.nextFloat() * 2.0f) - 1.0f) * 0.35f);
		}
		Entity tnt = new TntEntity(world, pos.getX(), pos.getY(), pos.getZ(), null);
		world.spawnEntity(tnt);
		return ActionResult.SUCCESS;
	}

	/* TODO trap presents behaviour similar to dispensers
	@Override
	protected ActionResult open(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, PresentBlockEntity entity) {
		ItemStack itemStack = entity.getContent();
		DispenserBehavior dispenserBehavior = DispenserBlockMixin.BEHAVIORS.get(itemStack.getItem());
		if (dispenserBehavior != DispenserBehavior.NOOP) {
			if (!world.isClient()) {
				itemStack = dispenserBehavior.dispense(new BlockPointerImpl((ServerWorld) world, pos), itemStack);
			}
		}
		dropStack(world, pos, itemStack);
		return ActionResult.SUCCESS;
	}*/
}
