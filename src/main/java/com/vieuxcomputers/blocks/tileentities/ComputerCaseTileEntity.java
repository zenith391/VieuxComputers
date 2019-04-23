package com.vieuxcomputers.blocks.tileentities;

import com.vieuxcomputers.init.BlocksInit;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ComputerCaseTileEntity extends TileEntity implements ITickable {

	public ComputerCaseTileEntity() {
		super(null);
	}

	@Override
	public void tick() {
		BlockPos pos = getPos();
		World world = getWorld();
		System.out.println("Test! " + "(" + pos.getX() + ", " + pos.getY() + ", " + pos.getY() + ") world = " + world);
	}

}
