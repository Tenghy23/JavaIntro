package net.fabricmc.learnfabric.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.learnfabric.item.custom.DowsingRodItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.learnfabric.MCCourseMod;

public class ModItems {

    // 3. making a new item: ORICHALCUM_IGNOT, name has to be lowercase
    // for every new item, add tne static final Item
    public static final Item ORICHALCUM_INGOT = registerItem("orichalcum_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));
    public static final Item ORICHALCUM_NUGGET = registerItem("orichalcum_nugget",
            new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));
    public static final Item RAW_ORICHALCUM = registerItem("raw_orichalcum",
            new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));

    // maxDamage here refers to total durability value
    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroups.COURSE).maxDamage(32)));
    public static final Item TURNIP = registerItem("turnip",
            new Item(new FabricItemSettings().group(ModItemGroups.COURSE).food(ModFoodComponents.TURNIP)));
    public static final Item COAL_SLIVER = registerItem("coal_silver",
            new Item(new FabricItemSettings().group(ModItemGroups.COURSE)));

    private static Item registerItem(String name, Item item) {
        // 2. setup base method to register mod
        return Registry.register(Registry.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // 1. setup to identify mod is successfully registered in console
        // 1a. setup gradle.properties + fabric.mod.json + learnfabric.mixins.json
        System.out.println("Register Mod Items for " + MCCourseMod.MOD_ID);
    }
}
