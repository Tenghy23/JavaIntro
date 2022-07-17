package net.fabricmc.learnfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.learnfabric.block.ModBlocks;
import net.fabricmc.learnfabric.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	// cannot contain uppercase, change your mod_id to whatever you want
	// dont change the getLogger's modid
	public static final String MOD_ID = "learnfabric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// 4. place here so upon initialize, we can tell mod initialize successfully
		// 5. create folder structure in assets > net.xyph.learnfabric lang/models/textures\
		// 6. add lang file & follow structure (en_us)
		// 7. add model/item json files + textures/item png files
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
