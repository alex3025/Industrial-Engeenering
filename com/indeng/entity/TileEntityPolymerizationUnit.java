package com.indeng.entity;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityPolymerizationUnit extends TileEntity implements IEnergySink, ITankContainer{

	
	public LiquidTank oilTank = new LiquidTank(16000);
	public LiquidTank gasTank = new LiquidTank(16000);
	public int maxEnergy = 64;
	public int energy = 0;
	public boolean initialized = false;
	boolean powered;
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		if (tag.hasKey("Energy")) {
			this.energy = tag.getInteger("energy");
		}
	}
	
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("energy", this.energy);
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


		if(this.energy >= 64) {
			this.energy = 0;
			this.powered = true;
		} else {
			this.powered = false;
		}
		
		
	}

	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, Direction direction) {
		// TODO Auto-generated method stub
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
		return 32;
	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		
		return null;
	}

}
