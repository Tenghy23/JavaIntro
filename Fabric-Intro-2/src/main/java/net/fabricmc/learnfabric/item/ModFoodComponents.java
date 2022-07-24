package net.fabricmc.learnfabric.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class ModFoodComponents {
    // hunger(qty) restores number of points in hunger bar
    // saturation refers to how much saturation in background
    // press shift key twice & search FoodComponents.class for vanilla examples
    public static FoodComponent TURNIP = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
}