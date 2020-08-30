package com.indeng.entity;

import com.indeng.api.DistillationTowerFuelManager;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityPolymerizationUnit extends TileEntity implements IEnergySink, ITankContainer{

	
	public LiquidTank oilTank = new LiquidTank(16000);
	public LiquidTank gasTank = new LiquidTank(16000);
	public int maxEnergy = 64;
	public int energy = 0;
	public boolean initialized = false;
	boolean powered;
	ForgeDirection currentDirection = ForgeDirection.EAST;
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		if (tag.hasKey("Energy")) {
			this.energy = tag.getInteger("energy");
		}
		
		if(tag.getShort("Dir") == (short)0) {
        	currentDirection = ForgeDirection.NORTH;
        } else if(tag.getShort("Dir") == (short)1) {
        	currentDirection = ForgeDirection.EAST;
        } else if(tag.getShort("Dir") == (short)2) {
        	currentDirection = ForgeDirection.SOUTH;
        } else if(tag.getShort("Dir") == (short)3) {
        	currentDirection = ForgeDirection.WEST;
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
		if (!initialized && worldObj != null) {
			if (!worldObj.isRemote) {
				EnergyTileLoadEvent event = new EnergyTileLoadEvent(this);
				MinecraftForge.EVENT_BUS.post(event);
				initialized = true;
			}
		}
		
		if(this.oilTank.getLiquid() != null) {
			if(this.energy >= 64 && this.oilTank.getLiquid().amount > 0) {
				this.energy = 0;
				this.gasTank.fill(LiquidDictionary.getLiquid("Gasoline", this.oilTank.getLiquid().amount), true);
				this.oilTank.drain(this.oilTank.getLiquid().amount, true);
			}
		}
		
		
	}
	
	public TileEntityPolymerizationUnit(ForgeDirection meta) {
		this.currentDirection = meta;
	}
	
	public TileEntityPolymerizationUnit() {
		this.currentDirection = ForgeDirection.EAST;
	}

	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, Direction direction) {
		return true;
	}

	@Override
	public boolean isAddedToEnergyNet() {
		// TODO Auto-generated method stub
		return this.initialized;
	}

	@Override
	public int demandsEnergy() {
		// TODO Auto-generated method stub
		return this.maxEnergy - this.energy;
	}

	@Override
	public int injectEnergy(Direction directionFrom, int amount) {
		if (this.energy >= this.maxEnergy) return amount;
		
		int openEnergy = this.maxEnergy - this.energy;
		
		if (openEnergy >= amount) {
			this.energy += amount;
			return 0;
		} else if(amount > openEnergy) {
			this.energy = this.maxEnergy;
			return amount - openEnergy;
		}
		
		return 0;
	}

	@Override
	public int getMaxSafeInput() {
		// TODO Auto-generated method stub
		return 128;
	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		if(from != this.currentDirection && from != this.currentDirection.getOpposite()) {
			return 0;
		}
		
		if(resource == null) {
			return 0;
		}
		
		if(resource.isLiquidEqual(LiquidDictionary.getLiquid("GPL", resource.amount)) && from == this.currentDirection.getOpposite()) {
			
			if(this.oilTank.getLiquid() == null) {
				if(resource.amount <= this.oilTank.getCapacity()) {
					this.oilTank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.oilTank.getLiquid().amount + resource.amount) <= this.oilTank.getCapacity()) {
				this.oilTank.fill(resource, doFill);
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
		if (from == currentDirection)
			return this.gasTank.drain(maxDrain, doDrain);
		
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
				return new ILiquidTank[] {this.oilTank};
			} else if(direction == this.currentDirection.getOpposite()) {
				return new ILiquidTank[] {this.gasTank};
			}
		}
		return new ILiquidTank[] {};
	}
	
	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		if (!worldObj.isRemote) {
			System.out.println(this.currentDirection);
			if(direction == this.currentDirection) {
				return this.oilTank;
			} else if(direction == this.currentDirection.getOpposite()) {
				return this.gasTank;
			}
		}
		return null;
	}
	
}
