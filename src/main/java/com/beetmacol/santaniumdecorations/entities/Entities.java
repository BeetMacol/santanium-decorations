package com.beetmacol.santaniumdecorations.entities;

import com.beetmacol.santaniumdecorations.SantaniumDecorations;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Entities {
	public static final EntityType<SantaMassEntity> SANTA_MASS = register("santa_mass", FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SantaMassEntity::new).dimensions(EntityDimensions.fixed(1, 1)).build(), SantaMassEntity.createMobAttributes());

	public static <T extends LivingEntity> EntityType<T> register(String id, EntityType<T> entityType, DefaultAttributeContainer.Builder attributes) {
		FabricDefaultAttributeRegistry.register(entityType, attributes);
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(SantaniumDecorations.MOD_ID, id), entityType);
	}
}
