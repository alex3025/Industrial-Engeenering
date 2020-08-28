package com.indeng.entity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityDistillationTank extends TileEntity implements ITankContainer{
	
	LiquidTank tank = new LiquidTank(20000);
	LiquidTank tank1 = new LiquidTank(1);
	ForgeDirection currentDirection;
	
	
	public TileEntityDistillationTank(ForgeDirection meta) {
		this.currentDirection = meta;
	}
	
	@Override
	public void updateEntity() {
		System.out.println(this.currentDirection);
	}

	
	
	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (from == currentDirection)
			return tank.drain(maxDrain, doDrain);
		return null;
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		if (direction == currentDirection) {
			return new ILiquidTank[] {tank};
		} else {
			return new ILiquidTank[] {tank};
		}
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		if (direction == currentDirection)
			return tank;
		else
			return tank1;
	}
	

}
