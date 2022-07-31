package net.fabricmc.learnfabric.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.learnfabric.MCCourseMod;
import net.fabricmc.learnfabric.block.custom.SpeedyBlock;
import net.fabricmc.learnfabric.item.ModItemGroups;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    // 4. create & define individual blocks
    // 5. create blockstates folder

    //region orichalcum blocks
    public static final Block ORICHALCUM_BLOCK = registerBlock("orichalcum_block",
        new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroups.COURSE);

    public static final Block DEEPSLATE_ORICHALCUM_ORE = registerBlock("deepslate_orichalcum_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroups.COURSE);

    public static final Block RAW_ORICHALCUM_BLOCK = registerBlock("raw_orichalcum_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroups.COURSE);
    //endregion

    //region orichalcum furniture
    public static final Block ORICHALCUM_STAIRS = registerBlock("orichalcum_stairs",
            new StairsBlock(ModBlocks.ORICHALCUM_BLOCK.getDefaultState(),
                    FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_SLAB = registerBlock("orichalcum_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_BUTTON = registerBlock("orichalcum_button",
            new StoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_PRESSURE_PLATE = registerBlock("orichalcum_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_FENCE = registerBlock("orichalcum_fence",
            new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_FENCE_GATE = registerBlock("orichalcum_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block ORICHALCUM_WALL = registerBlock("orichalcum_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroups.COURSE);
    //endregion

    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroups.COURSE);

    public static final Block CHERRY_BLOSSOM_DOOR = registerBlock("cherry_blossom_door",
            new DoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()), ModItemGroups.COURSE);
    public static final Block CHEERY_BLOSSOM_TRAPDOOR = registerBlock("cherry_blossom_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()), ModItemGroups.COURSE);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        // 3. register Block
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MCCourseMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        // 2. register BlockItem first before registering Block itself
        return Registry.register(Registry.ITEM, new Identifier(MCCourseMod.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        // 1. setup to identify mod is successfully registered in console
        System.out.println("Register Block Items for " + MCCourseMod.MOD_ID);
    }
}
