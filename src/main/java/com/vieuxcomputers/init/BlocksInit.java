package com.vieuxcomputers.init;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

import com.vieuxcomputers.VieuxComputers;
import com.vieuxcomputers.blocks.BlockCC1;
import com.vieuxcomputers.blocks.tileentities.ComputerCaseTileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class BlocksInit {

	static class TESupplier implements Supplier<TileEntity> {
		
		private Class<?> te;
		
		public TESupplier(Class<?> te) {
			this.te = te;
		}

		@Override
		public TileEntity get() {
			try {
				return (TileEntity) te.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new Error(e);
			}
		}
		
	}
	
	public static BlockCC1 computerCase1;
	
	static {
		computerCase1 = new BlockCC1();
	} 
	
	public static void registerTileEntities(IForgeRegistry<TileEntityType<?>> registry) {
		TileEntityType<TileEntity> cc1 = TileEntityType.Builder.create(new TESupplier(ComputerCaseTileEntity.class)).build(null);
		cc1.setRegistryName("vieuxcomputers", "computer_case_1");
		registry.register(cc1);
	}
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		VieuxComputers.LOGGER.info("Registering blocks");
		registry.registerAll(computerCase1);
	}
	
}
