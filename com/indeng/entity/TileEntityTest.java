package com.indeng.entity;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityTest extends TileEntity implements ITankContainer, IEnergySource{
	
	LiquidTank tank = new LiquidTank(20000);
	

	private ItemStack[] inventory = new ItemStack[1];
	
	boolean added = false;
	
	
	
	
	public void updateEntity() {
		/*
		if(active) {
			worldObj.setBlockWithNotify(xCoord, yCoord, zCoord, Blocks.blockOsmoGenActive.blockID);	
		} else {
			worldObj.setBlockWithNotify(xCoord, yCoord, zCoord, Blocks.blockOsmoGenIdle.blockID);
		}*/
		double var8 = (double)this.xCoord + 0.5D;
		double var11 = (double)this.zCoord + 0.5D;
		//this.worldObj.playSoundEffect(var8, (double)this.yCoord + 0.5D, var11, "machines.osmo", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		if (!added)
	    {
		        EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
		        MinecraftForge.EVENT_BUS.post(loadevent);
		        added = true;
	    }
		/*
		if(this.tank.getLiquid() != null) {
			if(this.tank.getLiquid().amount > 0) {
		        active = true;
			} else {
		        active = false;
			}
		}*/
		
		if(this.tank.getLiquid() != null) {
			if(this.tank.getLiquid().amount >= 10) {
				this.tank.drain(10, true);
				EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, 32);
		        MinecraftForge.EVENT_BUS.post(sourceEvent);
			} else {
				EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, 0);
		        MinecraftForge.EVENT_BUS.post(sourceEvent);
			}
		}
	}
	

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return this.fill(0, resource, doFill);
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		if(tankIndex == 0) {
			if(!resource.isLiquidEqual(LiquidDictionary.getLiquid("Salt Water", resource.amount))) {
				return 0;
			}
			if(this.tank.getLiquid() == null) {
				if(resource.amount <= this.tank.getCapacity()) {
					tank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.tank.getLiquid().amount + resource.amount) <= this.tank.getCapacity()) {
				tank.fill(resource, doFill);
				return resource.amount;
			}
		}
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return this.drain(0, maxDrain, doDrain);
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		if (tankIndex == 0)
			return tank.drain(maxDrain, doDrain);
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		// TODO Auto-generated method stub
		return new ILiquidTank[]{this.tank};
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return this.tank;
	}


	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAddedToEnergyNet() {
		// TODO Auto-generated method stub
		return added;
	}


	@Override
	public int getMaxEnergyOutput() {
		// TODO Auto-generated method stub
		return 32;
	}
}
