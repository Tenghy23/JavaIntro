package net.fabricmc.learnfabric.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.learnfabric.MCCourseMod;

public class ModItems {

    // 3. making a new item: ORICHALCUM_IGNOT, name has to be lowercase
    // for every new item, add ne static final Item
    public static final Item ORICHALCUM_INGOT = registerItem("orichalcum_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item ORICHALCUM_NUGGET = registerItem("orichalcum_nugget",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

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
