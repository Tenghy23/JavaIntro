package net.fabricmc.learnfabric.util;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.learnfabric.MCCourseMod;
import net.fabricmc.learnfabric.item.ModItems;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        FabricModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(MCCourseMod.MOD_ID, "on"),
                ((stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f));
    }
}