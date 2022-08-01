package net.fabricmc.learnfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.learnfabric.block.ModBlocks;
import net.fabricmc.learnfabric.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;

public class MCCourseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHERRY_BLOSSOM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEERY_BLOSSOM_TRAPDOOR, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();
    }
}

