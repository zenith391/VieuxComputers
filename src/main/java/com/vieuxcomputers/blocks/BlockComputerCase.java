package com.vieuxcomputers.blocks;

import com.vieuxcomputers.blocks.tileentities.ComputerCaseTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockComputerCase extends Block {

	public BlockComputerCase() {
		super(Properties.create(Material.IRON));
	}

	@Override
	public boolean hasTileEntity(IBlockState bs) {
		return true;
		
	}
	
	@Override
	public TileEntity createTileEntity(IBlockState bs, IBlockReader world) {
		return new ComputerCaseTileEntity();
	}
	
}
