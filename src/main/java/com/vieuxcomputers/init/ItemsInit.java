package com.vieuxcomputers.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemsInit {

	public static ItemBlock computerCase1Item;
	
	static {
		{
			Properties prop = new Properties();
			prop.group(ItemGroup.REDSTONE);
			computerCase1Item = new ItemBlock(BlocksInit.computerCase1, prop);
			computerCase1Item.setRegistryName("vieuxcomputers", "computer_case_1");
		}
	}
	
	public static void registerItems(IForgeRegistry<Item> registry) {
		registry.registerAll(computerCase1Item);
	}
	
}
