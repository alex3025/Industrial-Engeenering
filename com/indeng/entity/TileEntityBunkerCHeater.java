package com.indeng.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityBunkerCHeater extends TileEntity implements ITankContainer {
	
	public LiquidTank bunkerTank = new LiquidTank(16000);
	public LiquidTank heatedBunkerTank = new LiquidTank(16000);
	public LiquidTank steamTank = new LiquidTank(16000);
	public int maxEnergy = 64;
	public int energy = 0;
	public boolean initialized = false;
	boolean powered;
	ForgeDirection currentDirection = ForgeDirection.EAST;
	ForgeDirection secondDirection = ForgeDirection.WEST;
	ForgeDirection heatedDirection = ForgeDirection.WEST;
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		if (tag.hasKey("Energy")) {
			this.energy = tag.getInteger("energy");
		}
		
		if(tag.getShort("Dir") == (short)0) {
        	currentDirection = ForgeDirection.NORTH;
        	this.secondDirection = ForgeDirection.EAST;
        	this.heatedDirection = ForgeDirection.SOUTH;
        } else if(tag.getShort("Dir") == (short)1) {
        	currentDirection = ForgeDirection.EAST;
        	this.heatedDirection = ForgeDirection.WEST;
        	this.secondDirection = ForgeDirection.SOUTH;
        } else if(tag.getShort("Dir") == (short)2) {
        	currentDirection = ForgeDirection.SOUTH;
        	this.secondDirection = ForgeDirection.WEST;
        	this.heatedDirection = ForgeDirection.NORTH;
        } else if(tag.getShort("Dir") == (short)3) {
        	currentDirection = ForgeDirection.WEST;
        	this.secondDirection = ForgeDirection.NORTH;
        	this.heatedDirection = ForgeDirection.EAST;
        }
		
	}
	
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("energy", this.energy);
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
	
	@Override
	public void updateEntity() {
		if(this.bunkerTank.getLiquid() != null && this.steamTank.getLiquid() != null) {
			worldObj.spawnParticle("smoke", (double)(xCoord + 0.5), (double)yCoord+1, (double)(zCoord + 0.5), 0.0D, 0.4D, 0.0D);
			if(this.steamTank.getLiquid().amount >= 32 && this.bunkerTank.getLiquid().amount > 0) {
				//worldObj.spawnParticle("smoke", (double)(xCoord + 0.5), (double)yCoord+1, (double)(zCoord + 0.5), 0.0D, 0.4D, 0.0D);
				this.steamTank.drain(32, true);
				this.heatedBunkerTank.fill(LiquidDictionary.getLiquid("Heated Bunker C", this.bunkerTank.getLiquid().amount), true);
				this.bunkerTank.drain(this.bunkerTank.getLiquid().amount, true);
			}
		}
	}
	
	public TileEntityBunkerCHeater(ForgeDirection dir) {
		this.currentDirection = dir;
		
		
		if(dir == ForgeDirection.NORTH) {
			this.secondDirection = ForgeDirection.EAST;
		}
		
		if(dir == ForgeDirection.WEST) {
			this.secondDirection = ForgeDirection.NORTH;
		}
		
		if(dir == ForgeDirection.EAST) {
			this.secondDirection = ForgeDirection.SOUTH;
		}
		
		if(dir == ForgeDirection.SOUTH) {
			this.secondDirection = ForgeDirection.WEST;
		}
		
		if(dir == ForgeDirection.NORTH) {
			this.heatedDirection = ForgeDirection.SOUTH;
		}
		
		if(dir == ForgeDirection.WEST) {
			this.heatedDirection = ForgeDirection.EAST;
		}
		
		if(dir == ForgeDirection.EAST) {
			this.heatedDirection = ForgeDirection.WEST;
		}
		
		if(dir == ForgeDirection.SOUTH) {
			this.heatedDirection = ForgeDirection.NORTH;
		}
		
	}
	
	public TileEntityBunkerCHeater() {
		this.currentDirection = ForgeDirection.EAST;
	}
	
	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		if(from != this.currentDirection && from != this.secondDirection) {
			return 0;
		}
		
		if(resource == null) {
			return 0;
		}
		
		if(resource.isLiquidEqual(LiquidDictionary.getLiquid("Bunker C", resource.amount)) && from == this.currentDirection) {
			
			if(this.bunkerTank.getLiquid() == null) {
				if(resource.amount <= this.bunkerTank.getCapacity()) {
					this.bunkerTank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.bunkerTank.getLiquid().amount + resource.amount) <= this.bunkerTank.getCapacity()) {
				this.bunkerTank.fill(resource, doFill);
				return resource.amount;
			}
		} else if(resource.isLiquidEqual(LiquidDictionary.getLiquid("Steam", resource.amount)) && from == this.secondDirection) {
			
			if(this.steamTank.getLiquid() == null) {
				if(resource.amount <= this.steamTank.getCapacity()) {
					this.steamTank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.steamTank.getLiquid().amount + resource.amount) <= this.steamTank.getCapacity()) {
				this.steamTank.fill(resource, doFill);
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
		if (from == this.heatedDirection)
			return this.heatedBunkerTank.drain(maxDrain, doDrain);
		
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
				return new ILiquidTank[] {this.bunkerTank};
			} else if(direction == this.heatedDirection) {
				return new ILiquidTank[] {this.heatedBunkerTank};
			} else if(direction == this.secondDirection) {
				return new ILiquidTank[] {this.steamTank};
			}
		}
		return new ILiquidTank[] {};
	}
	
	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		if (!worldObj.isRemote) {
			System.out.println(this.currentDirection);
			if(direction == this.currentDirection) {
				return this.bunkerTank;
			} else if(direction == this.heatedDirection) {
				return this.heatedBunkerTank;
			} else if(direction == this.secondDirection) {
				return this.steamTank;
			}
		}
		return null;
	}
}
