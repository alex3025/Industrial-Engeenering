package com.industrialengeenering.entity;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

public class MachineBase extends TileEntity implements IEnergySink{
	
	public int maxEnergy = 0;
	public int energy = 0;
	public int voltage = 0;
	public boolean initialized = false;
	
	
	public MachineBase(int maxEnergy, int voltage) {
		this.maxEnergy = maxEnergy;
		this.voltage = voltage;
	}
	
	
	public boolean consumeEnergy(int e) {
		if (this.energy >= e) {
			this.energy -= e;
			return true;
		} else {
			return false;
		}
	}
	
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
	}
	
	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, Direction direction) {
		return true;
	}

	@Override
	public boolean isAddedToEnergyNet() {
		return this.initialized;
	}

	@Override
	public int demandsEnergy() {
		return this.maxEnergy - this.energy;
	}

	@Override
	public void invalidate() {
		EnergyTileUnloadEvent event = new EnergyTileUnloadEvent(this);
		MinecraftForge.EVENT_BUS.post(event);
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
		return this.voltage;
	}

}
