package com.indeng.entity;

import com.indeng.item.Items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityCracker extends TileEntity implements ITankContainer, IInventory{
	
	public ItemStack[] inv = new ItemStack[1];
	public LiquidTank bunkerTank = new LiquidTank(16000);
	public LiquidTank heatedBunkerTank = new LiquidTank(16000);
	public LiquidTank steamTank = new LiquidTank(16000);
	ForgeDirection currentDirection = ForgeDirection.EAST;
	ForgeDirection secondDirection = ForgeDirection.WEST;
	ForgeDirection heatedDirection = ForgeDirection.WEST;
	public int usati;
	public int audioDuration = 0;
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
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
		
		NBTTagList tagList = tag.getTagList("Inventory");

		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);

			byte slot = tag.getByte("Slot");

			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
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
		
		
		NBTTagList itemList = new NBTTagList();

		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];

			if (stack != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();

				tagCompound.setByte("Slot", (byte) i);
				stack.writeToNBT(tagCompound);
				itemList.appendTag(tagCompound);
			}
		}

		tag.setTag("Inventory", itemList);
	}
	
	@Override
	public void updateEntity() {
		if(this.bunkerTank.getLiquid() != null && this.steamTank.getLiquid() != null) {
			worldObj.spawnParticle("smoke", (double)(xCoord + 0.5), (double)yCoord+1, (double)(zCoord + 0.5), 0.0D, 0.4D, 0.0D);
			if(this.steamTank.getLiquid().amount >= 32 && this.bunkerTank.getLiquid().amount > 0 && this.inv[0] != null) {
				if(this.inv[0].getItemDamage() < this.inv[0].getItem().getMaxDamage() && this.inv[0].itemID == Items.catA.itemID) {
					this.steamTank.drain(32, true);
					ItemStack stack = inv[0];
					if(this.usati >= 10000) {
						this.usati = 0;
						stack.setItemDamage(stack.getItemDamage()+10);
						this.setInventorySlotContents(0, stack);
					}
					if(this.audioDuration > 0) {
						this.audioDuration--;
					} else {
						this.audioDuration = 20;
						worldObj.playSoundEffect(xCoord, yCoord, zCoord, "machines.cracker", 1f, 1);
					}
					
					if(this.bunkerTank.getLiquid().isLiquidEqual(LiquidDictionary.getLiquid("Gasoline", this.bunkerTank.getLiquid().amount))) {
						this.heatedBunkerTank.fill(LiquidDictionary.getLiquid("GPL", this.bunkerTank.getLiquid().amount), true);
						this.usati += this.bunkerTank.getLiquid().amount;
						this.bunkerTank.drain(this.bunkerTank.getLiquid().amount, true);
					} else if(this.bunkerTank.getLiquid().isLiquidEqual(LiquidDictionary.getLiquid("Kerosene", this.bunkerTank.getLiquid().amount))) {
						this.heatedBunkerTank.fill(LiquidDictionary.getLiquid("Gasoline", this.bunkerTank.getLiquid().amount), true);
						this.usati += this.bunkerTank.getLiquid().amount;
						this.bunkerTank.drain(this.bunkerTank.getLiquid().amount, true);
					} else if(this.bunkerTank.getLiquid().isLiquidEqual(LiquidDictionary.getLiquid("Fuel", this.bunkerTank.getLiquid().amount))) {
						this.heatedBunkerTank.fill(LiquidDictionary.getLiquid("Kerosene", this.bunkerTank.getLiquid().amount), true);
						this.usati += this.bunkerTank.getLiquid().amount;
						this.bunkerTank.drain(this.bunkerTank.getLiquid().amount, true);
					} else if(this.bunkerTank.getLiquid().isLiquidEqual(LiquidDictionary.getLiquid("HFO", this.bunkerTank.getLiquid().amount))) {
						this.heatedBunkerTank.fill(LiquidDictionary.getLiquid("Fuel", this.bunkerTank.getLiquid().amount), true);
						this.usati += this.bunkerTank.getLiquid().amount;
						this.bunkerTank.drain(this.bunkerTank.getLiquid().amount, true);
					}
				}
			}
			
		}
	}
	
	public TileEntityCracker(ForgeDirection dir) {
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
	
	public TileEntityCracker() {
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
		
		if(resource.isLiquidEqual(LiquidDictionary.getLiquid("Gasoline", resource.amount)) && from == this.currentDirection || resource.isLiquidEqual(LiquidDictionary.getLiquid("Kerosene", resource.amount)) && from == this.currentDirection || resource.isLiquidEqual(LiquidDictionary.getLiquid("Fuel", resource.amount)) && from == this.currentDirection || resource.isLiquidEqual(LiquidDictionary.getLiquid("HFO", resource.amount)) && from == this.currentDirection) {
			
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
}
