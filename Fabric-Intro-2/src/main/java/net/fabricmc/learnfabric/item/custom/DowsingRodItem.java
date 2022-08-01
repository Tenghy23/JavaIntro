package net.fabricmc.learnfabric.item.custom;

import net.fabricmc.learnfabric.item.ModItems;
import net.fabricmc.learnfabric.util.InventoryUtil;
import net.fabricmc.learnfabric.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

// when creating an advanced item, extend the Item and make your own class name
// a dowsing rod is an item to detect if valuable ore is located below object
public class DowsingRodItem extends Item {
    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    // then override the methods inside Item class for custom bfehaviour
    // useOnBlock occurs when right click on block
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // wrap in this if statement to ensure you are in client
        if(context.getWorld().isClient) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            // loop from top pos all the way down, identify valuable block and return pos
            for(int i = 0; i <= positionClicked.getY(); i++) {
                BlockState stateBelow = context.getWorld().getBlockState(positionClicked.down(i));
                Block blockBelow = stateBelow.getBlock();

                if(isValuableBlock(stateBelow)) {
                    outputValuableCoordinates(positionClicked.add(0, -i, 0), player, blockBelow);
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET)) {
                        addNbtToDataTablet(player, positionClicked.add(0, -i, 0), blockBelow);
                    }

                    break;
                }
            }

            // return custom message when unable to find valuable block
            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.learnfabric.dowsing_rod.no_valuables"), false);
            }
        }

        // apply 1 dmg to the item
        // break the item on the player's hand once 0 durability is reached
        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private void addNbtToDataTablet(PlayerEntity player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet =
                player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("learnfabric.last_ore", "Found " + blockBelow.asItem().getName().getString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");

        dataTablet.setNbt(nbtData);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.learnfabric.dowsing_rod.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.learnfabric.dowsing_rod.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(Text.literal("Found " + blockBelow.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState block) {
        return block.isIn(ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS);
    }
}
