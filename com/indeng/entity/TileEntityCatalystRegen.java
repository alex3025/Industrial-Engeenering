package com.indeng.entity;

import com.indeng.item.ItemCatalizer;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityCatalystRegen extends TileEntity implements IInventory, IEnergySink{

	
	public ItemStack[] inv = new ItemStack[1];
	public int maxEnergy = 250;
	public int energy = 0;
	public boolean initialized = false;
	boolean powered;
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");

		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);

			byte slot = tag.getByte("Slot");

			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();

		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];

			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();

				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}

		tagCompound.setTag("Inventory", itemList);
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
		
		ItemStack stack = inv[0];
		if(stack != null && this.energy >= 250) {
			if(stack.getItemDamage() > 0) {
				this.energy = 0;
				stack.setItemDamage(stack.getItemDamage()-5);
				this.setInventorySlotContents(0, stack);
			}
		}
	}
	
	@Override
	public int getSizeInventory() {

		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {

		return inv[var1];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (inv[i] != null) {
			if (inv[i].stackSize <= j) {
				ItemStack itemstack = inv[i];
				inv[i] = null;
				onInventoryChanged();
				return itemstack;
			}
			ItemStack itemstack1 = inv[i].splitStack(j);
			if (inv[i].stackSize == 0) {
				inv[i] = null;
			}
			onInventoryChanged();
			return itemstack1;
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		if (this.inv[var1] != null) {
			ItemStack var2 = this.inv[var1];
			this.inv[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inv[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
		
	}

	@Override
	public String getInvName() {
		return "TileEntityCatalystRegen";
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		if (worldObj == null) {
			return true;
		}
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}
		return entityPlayer.getDistanceSq((double) xCoord + 0.5D,
				(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}
	
	

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
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
		return 128;
	}

}
