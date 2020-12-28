package com.beetmacol.santaniumdecorations;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SantaniumToolMaterial implements ToolMaterial {
    public static final SantaniumToolMaterial INSTANCE = new SantaniumToolMaterial();

    @Override
    public int getDurability() {
        return 666;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.SANTANIUM_INGOT);
    }
}
