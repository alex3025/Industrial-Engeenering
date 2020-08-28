package com.industrialengeenering.entity;

import ic2.api.Direction;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

public class BaseGenerator extends TileEntity implements IEnergySource{

	private boolean added = false;
	
	public int power = 0; 
	public int maxOutput = 0;
	
	public BaseGenerator(int maxOutput) {
		this.maxOutput = maxOutput;
	}
	
	public void updateEntity() {
		if (!added)
	    {
		        EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
		        MinecraftForge.EVENT_BUS.post(loadevent);
		        added = true;
	    }
		
		EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, power);
        MinecraftForge.EVENT_BUS.post(sourceEvent);
		
	}
	
	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		return true;
	}

	@Override
	public boolean isAddedToEnergyNet() {
		return added;
	}

	@Override
	public int getMaxEnergyOutput() {
		return this.maxOutput;
	}

}
