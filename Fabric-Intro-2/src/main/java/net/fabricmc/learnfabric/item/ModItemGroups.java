package net.fabricmc.learnfabric.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.learnfabric.MCCourseMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    // if you want to create item groups
    public static final ItemGroup COURSE = FabricItemGroupBuilder.build(new Identifier(MCCourseMod.MOD_ID, "course"),
        () -> new ItemStack(ModItems.ORICHALCUM_INGOT));
}
