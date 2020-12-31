package com.beetmacol.santaniumdecorations.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public class PresentBlockEntity extends BlockEntity {
	private ItemStack content = ItemStack.EMPTY;

	public PresentBlockEntity() {
		super(Blocks.PRESENT_BLOCK_ENTITY);
	}

	@Override
	public void fromTag(BlockState blockState, CompoundTag tag) {
		super.toTag(tag);
		Inventories.fromTag(tag, DefaultedList.ofSize(1, content));
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		Inventories.toTag(tag, DefaultedList.ofSize(1, content));

		return super.toTag(tag);
	}

	public void setContent(ItemStack content) {
		this.content = content;
	}

	public ItemStack getContent() {
		return content;
	}
}
