package net.fabricmc.learnfabric.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.learnfabric.MCCourseMod;
import net.fabricmc.learnfabric.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        System.out.println("Registering Fuels for + " + MCCourseMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        //  400 ticks / 20 = 20 Seconds
        registry.add(ModItems.COAL_SLIVER, 400);
    }
}
