package com.beetmacol.santaniumdecorations;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SantaSlimeEntity extends SlimeEntity  {
    public SantaSlimeEntity(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
    }

    /*@Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        this.setSize(1, true);
        return super.initialize(world, difficulty, spawnReason, entityData, entityTag);
    }*/
    @Override
    protected void setSize(int size, boolean heal) {
        //super.setSize(1, heal);
        this.dataTracker.set(SLIME_SIZE, size);
        this.refreshPosition();
        this.calculateDimensions();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue((double)(size * size));
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)size));
        //this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue((double)size);
        if (heal) {
            this.setHealth(this.getMaxHealth());
        }

        this.experiencePoints = size;
    }

    @Override
    public void readCustomDataFromTag(CompoundTag tag) {
        //int i = tag.getInt("Size");
        //if (i < 0) {
        //    i = 0;
        //}

        this.setSize(1, false);
        super.readCustomDataFromTag(tag);
        //this.onGroundLastTick = tag.getBoolean("wasOnGround");
    }
}
