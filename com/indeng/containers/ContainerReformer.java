package com.indeng.containers;

import com.indeng.entity.TileEntityCracker;
import com.indeng.entity.TileEntityReformer;
import com.indeng.item.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerReformer extends Container {
	
	private Slot catalyzer;
	private TileEntityReformer tile;
	
	public ContainerReformer(IInventory inventoryplayer, TileEntityReformer catalystregen) {
		layoutContainer(inventoryplayer, catalystregen);
		this.tile = catalystregen;
	}
	
	private void layoutContainer(IInventory playerInventory, IInventory inventory) {
		addSlotToContainer(new Slot(inventory, 0, 80, 24));
		for (int inventoryRow = 0; inventoryRow < 3; inventoryRow++)
		{
			for (int inventoryColumn = 0; inventoryColumn < 9; inventoryColumn++)
			{
				addSlotToContainer(new Slot(playerInventory, inventoryColumn + inventoryRow * 9 + 9, 8 + inventoryColumn * 18, 84 + inventoryRow * 18));
			}
		}

		for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
		{
			addSlotToContainer(new Slot(playerInventory, hotbarSlot, 8 + hotbarSlot * 18, 142));
		}

	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        if(current.itemID != Items.catB.itemID) {
	        	return null;
	        }
	        previous = current.copy();

	        if (fromSlot < 9) {
	            if (!this.mergeItemStack(current, 9, 37, true))
	                return null;
	        } else {
	            if (!this.mergeItemStack(current, 0, 9, false))
	                return null;
	        }

	        if (current.stackSize == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.stackSize == previous.stackSize)
	            return null;
	        slot.onPickupFromSlot(playerIn, current);
	    }
	    return previous;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {

		return this.tile.isUseableByPlayer(var1);
	}
}
