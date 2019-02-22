package com.vieuxcomputers.init;

import com.vieuxcomputers.VieuxComputers;
import com.vieuxcomputers.blocks.BlockCC1;

import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistry;

public class BlocksInit {

	public static BlockCC1 computerCase1;
	
	static {
		computerCase1 = new BlockCC1();
	}
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		VieuxComputers.LOGGER.info("Registering blocks");
		registry.registerAll(computerCase1);
	}
	
}
