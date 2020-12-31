package com.beetmacol.santaniumdecorations;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class BaubleBlock extends Block {
    public BaubleBlock() {
        super(FabricBlockSettings.of(Material.WOOL).breakByHand(true).breakInstantly());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid((6.0f/16.0f), 1.0f - (8.0f/16.0f), (6.0f/16.0f), 1.0f - (6.0f/16.0f), 1.0f, 1.0f - (6.0f/16.0f));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(world.getBlockState(pos.add(0, 1, 0)).isAir()) {
           return false;
        }
        else {
            return  true;
        }
    }
}
