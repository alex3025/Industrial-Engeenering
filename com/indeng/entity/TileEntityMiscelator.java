package com.indeng.entity;

import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityMiscelator extends TileEntity implements ITankContainer {
	
	public LiquidTank hydroTank = new LiquidTank(16000);
	public LiquidTank coTank = new LiquidTank(16000);
	public LiquidTank townTank = new LiquidTank(16000);
	ForgeDirection currentDirection = ForgeDirection.EAST;
	ForgeDirection secondDirection = ForgeDirection.WEST;
	ForgeDirection townDirection = ForgeDirection.WEST;
	
	
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
		if(tag.getShort("Dir") == (short)0) {
        	currentDirection = ForgeDirection.NORTH;
        	this.secondDirection = ForgeDirection.WEST;
        	this.townDirection = ForgeDirection.SOUTH;
        } else if(tag.getShort("Dir") == (short)1) {
        	currentDirection = ForgeDirection.EAST;
        	this.townDirection = ForgeDirection.WEST;
        	this.secondDirection = ForgeDirection.NORTH;
        } else if(tag.getShort("Dir") == (short)2) {
        	currentDirection = ForgeDirection.SOUTH;
        	this.secondDirection = ForgeDirection.EAST;
        	this.townDirection = ForgeDirection.NORTH;
        } else if(tag.getShort("Dir") == (short)3) {
        	currentDirection = ForgeDirection.WEST;
        	this.secondDirection = ForgeDirection.SOUTH;
        	this.townDirection = ForgeDirection.EAST;
        }
		
	}
	
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		
		if(currentDirection == ForgeDirection.NORTH) {
        	tag.setShort("Dir", (short)0);
        } else if(currentDirection == ForgeDirection.EAST) {
        	tag.setShort("Dir", (short)1);
        } else if(currentDirection == ForgeDirection.SOUTH) {
        	tag.setShort("Dir", (short)2);
        } else if(currentDirection == ForgeDirection.WEST) {
        	tag.setShort("Dir", (short)3);
        } 
	}
	
	
	public TileEntityMiscelator(ForgeDirection dir) {
		this.currentDirection = dir;
		
		
		if(dir == ForgeDirection.NORTH) {
			this.secondDirection = ForgeDirection.WEST;
		}
		
		if(dir == ForgeDirection.WEST) {
			this.secondDirection = ForgeDirection.SOUTH;
		}
		
		if(dir == ForgeDirection.EAST) {
			this.secondDirection = ForgeDirection.NORTH;
		}
		
		if(dir == ForgeDirection.SOUTH) {
			this.secondDirection = ForgeDirection.EAST;
		}
		
		if(dir == ForgeDirection.NORTH) {
			this.townDirection = ForgeDirection.SOUTH;
		}
		
		if(dir == ForgeDirection.WEST) {
			this.townDirection = ForgeDirection.EAST;
		}
		
		if(dir == ForgeDirection.EAST) {
			this.townDirection = ForgeDirection.WEST;
		}
		
		if(dir == ForgeDirection.SOUTH) {
			this.townDirection = ForgeDirection.NORTH;
		}
		
	}
	
	public TileEntityMiscelator() {
		this.currentDirection = ForgeDirection.EAST;
	}
	
	
	@Override
	public void updateEntity() {
		if(this.hydroTank.getLiquid() != null && this.coTank.getLiquid() != null) {
			if(this.hydroTank.getLiquid().amount >= 2000 && this.coTank.getLiquid().amount >= 1000) {
				this.townTank.fill(LiquidDictionary.getLiquid("Town Gas", 3000), true);
				this.hydroTank.drain(2000, true);
				this.coTank.drain(1000, true);
			}
		}
	}
	
	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		if(from != this.currentDirection && from != this.secondDirection) {
			return 0;
		}
		
		if(resource == null) {
			return 0;
		}
		
		
		
		
		if(resource.isLiquidEqual(LiquidDictionary.getLiquid("gasHydrogen", resource.amount)) && from == this.currentDirection) {
			
			if(this.hydroTank.getLiquid() == null) {
				if(resource.amount <= this.hydroTank.getCapacity()) {
					this.hydroTank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.hydroTank.getLiquid().amount + resource.amount) <= this.hydroTank.getCapacity()) {
				this.hydroTank.fill(resource, doFill);
				return resource.amount;
			}
		} else if(resource.isLiquidEqual(LiquidDictionary.getLiquid("Carbon Monoxide", resource.amount)) && from == this.secondDirection) {
			
			if(this.coTank.getLiquid() == null) {
				if(resource.amount <= this.coTank.getCapacity()) {
					this.coTank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.coTank.getLiquid().amount + resource.amount) <= this.coTank.getCapacity()) {
				this.coTank.fill(resource, doFill);
				return resource.amount;
			}
		}
		
		return 0;
	}
	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (from == this.townDirection)
			return this.townTank.drain(maxDrain, doDrain);
		
		return null;
	}
	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		if (!worldObj.isRemote) {
			System.out.println(this.currentDirection);
			if(direction == this.currentDirection) {
				return new ILiquidTank[] {this.hydroTank};
			} else if(direction == this.townDirection) {
				return new ILiquidTank[] {this.townTank};
			} else if(direction == this.secondDirection) {
				return new ILiquidTank[] {this.coTank};
			}
		}
		return new ILiquidTank[] {};
	}
	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		if (!worldObj.isRemote) {
			System.out.println(this.currentDirection);
			if(direction == this.currentDirection) {
				return this.hydroTank;
			} else if(direction == this.townDirection) {
				return this.townTank;
			} else if(direction == this.secondDirection) {
				return this.coTank;
			}
		}
		return null;
	}
	
	
	
}
