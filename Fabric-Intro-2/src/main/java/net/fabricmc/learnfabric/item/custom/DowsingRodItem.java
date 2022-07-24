package net.fabricmc.learnfabric.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import javax.swing.*;

// when creating an advanced item, extend the Item and make your own class name
// a dowsing rod is an item to detect if valuable ore is located below object
public class DowsingRodItem extends Item {
    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    // then override the methods inside Item class for custom behaviour
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
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked, player, blockBelow);
                    foundBlock = true;
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

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(Text.literal("Found " + blockBelow.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE
                || block == Blocks.EMERALD_ORE || block == Blocks.GOLD_ORE
                || block == Blocks.DEEPSLATE_DIAMOND_ORE;
    }
}