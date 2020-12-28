package com.beetmacol.santaniumdecorations;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class SantaMassEntity extends SlimeEntity  {
    public SantaMassEntity(EntityType<? extends SantaMassEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canSpawn(WorldView world) {
        return world.intersectsEntities(this);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }

    // TODO
    /*protected ParticleEffect getParticles() {
        return ParticleTypes.FLAME;
    }*/

    /*protected Identifier getLootTableId() {
        return this.isSmall() ? LootTables.EMPTY : this.getType().getLootTableId();
    }*/

    protected int getTicksUntilNextJump() {
        return this.random.nextInt(18) + 8;
    }

    protected float getDamageAmount() {
        return super.getDamageAmount() - 3.0F;
    }

    /*protected SoundEvent getHurtSound(DamageSource source) {
        return this.isSmall() ? SoundEvents.ENTITY_MAGMA_CUBE_HURT_SMALL : SoundEvents.ENTITY_MAGMA_CUBE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isSmall() ? SoundEvents.ENTITY_MAGMA_CUBE_DEATH_SMALL : SoundEvents.ENTITY_MAGMA_CUBE_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmall() ? SoundEvents.ENTITY_MAGMA_CUBE_SQUISH_SMALL : SoundEvents.ENTITY_MAGMA_CUBE_SQUISH;
    }

    protected SoundEvent getJumpSound() {
        return SoundEvents.ENTITY_MAGMA_CUBE_JUMP;
    }*/
}
