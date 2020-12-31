package com.beetmacol.santaniumdecorations.world;

import com.beetmacol.santaniumdecorations.blocks.Blocks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SantaHillFeature extends Feature<DefaultFeatureConfig> {
    public SantaHillFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
        if(world.getBlockState(topPos) != net.minecraft.block.Blocks.ICE.getDefaultState()) {
            //Direction offset = Direction.NORTH;
            int max_radius = random.nextInt(2) + 1;
            float fill_rate = (random.nextInt(30) + 20) / 100.0f;
            int block_amount = (max_radius * max_radius * max_radius) * (int) (fill_rate * 100.0f);
            //int i2 = 0;
            for (int i = 0; i < block_amount; i++) {
                int offset_x = random.nextInt(max_radius * 2) - (int) (max_radius * 1.75f);
                int offset_y = random.nextInt(max_radius * 2) - (int) (max_radius * 1.75f);
                int offset_z = random.nextInt(max_radius * 2) - (int) (max_radius * 1.75f);
                float r2 = random.nextFloat();
                float r3 = r2 * r2;
                offset_x = (int)(offset_x * r3);
                offset_y = (int)(offset_y * r3);
                offset_z = (int)(offset_z * r3);
                //if(world.isAir(topPos.add(offset_x, offset_y, offset_z))) {

                float r = random.nextFloat();

                if (r < 0.2f) {
                    world.setBlockState(topPos.add(offset_x, offset_y, offset_z), Blocks.SANTANIUM_ORE.getDefaultState(), 3);
                } else {
                    world.setBlockState(topPos.add(offset_x, offset_y, offset_z), net.minecraft.block.Blocks.SNOW_BLOCK.getDefaultState(), 3);
                }
                //i2++;
                //if(i2 >= block_amount) break;;
                //}
            }
            //for (int y = 1; y <= 15; y++) {
            //offset = offset.rotateYClockwise();
            //world.setBlockState(topPos.up(y).offset(offset), Blocks.SANTANIUM_ORE.getDefaultState(), 3);
            //}
            return  true;
        }
        else {
            return  false;
        }
    }
}
