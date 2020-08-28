package com.indeng.entity;

import com.indeng.api.DistillationTowerFuel.FuelType;

import net.minecraft.nbt.NBTTagCompound;
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
	
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);

        if(currentDirection == ForgeDirection.NORTH) {
        	par1NBTTagCompound.setShort("Dir", (short)0);
        } else if(currentDirection == ForgeDirection.EAST) {
        	par1NBTTagCompound.setShort("Dir", (short)1);
        } else if(currentDirection == ForgeDirection.SOUTH) {
        	par1NBTTagCompound.setShort("Dir", (short)2);
        } else if(currentDirection == ForgeDirection.WEST) {
        	par1NBTTagCompound.setShort("Dir", (short)3);
        } 
        
    }
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);

        if(par1NBTTagCompound.getShort("Dir") == (short)0) {
        	currentDirection = ForgeDirection.NORTH;
        } else if(par1NBTTagCompound.getShort("Dir") == (short)1) {
        	currentDirection = ForgeDirection.EAST;
        } else if(par1NBTTagCompound.getShort("Dir") == (short)2) {
        	currentDirection = ForgeDirection.SOUTH;
        } else if(par1NBTTagCompound.getShort("Dir") == (short)3) {
        	currentDirection = ForgeDirection.WEST;
        }
    }
	
	public TileEntityDistillationTank(ForgeDirection meta) {
		this.currentDirection = meta;
	}
	
	public TileEntityDistillationTank() {
		this.currentDirection = ForgeDirection.EAST;
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
