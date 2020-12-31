package com.beetmacol.santaniumdecorations.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;

public class PresentBlockEntity extends BlockEntity {
	private ItemStack content;

	public PresentBlockEntity() {
		super(Blocks.PRESENT_BLOCK_ENTITY);
	}

	@Override
	public void fromTag(BlockState blockState, CompoundTag tag) {
		super.fromTag(blockState, tag);
		//super.toTag(tag);
		//Inventories.fromTag(tag, DefaultedList.ofSize(1, content));
		//content.setTag(tag);
		//content.

		Tag content_tag = tag.get("content");
		//content = ItemStack.fromTag((CompoundTag) content_tag);
		Tag item_tag = ((CompoundTag) content_tag).get("tag");
		byte item_count = ((CompoundTag)content_tag).getByte("Count");
		String item_id = ((CompoundTag)content_tag).getString("id");
		content = new ItemStack(Registry.ITEM.get(new Identifier(item_id)), item_count);
		content.setTag((CompoundTag)item_tag);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		//Inventories.toTag(tag, DefaultedList.ofSize(1, content));
		Tag content_tag = content.toTag(new CompoundTag());
		tag.put("content", content_tag);

		return tag;
	}

	public void setContent(ItemStack content) {
		this.content = content;
	}

	public ItemStack getContent() {
		return content;
	}
}
