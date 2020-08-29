package com.indeng.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCatalizer extends Item{
	
	int type;
	
	public ItemCatalizer(int par1, int type) {
		super(par1);
		this.type = type;
		if(this.type == 0 || this.type == 1) {
			this.setMaxDamage(1000);
			this.canRepair = true;
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		
		par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.catA, 1, 1000));
		
		return true;
	}
	
	@Override
	public boolean isDamageable() {
		return true;
	}
	
	@Override
	public int getIconFromDamage(int meta) {
		
		switch(type) {
			case 0:
				switch(meta) {
					case 0:
						return 32;
					case 1000:
						return 33;
				}
			case 1:
				switch(meta) {
					case 0:
						return 34;
					case 1000:
						return 35;
				}
			case 2:
				return 36;
			case 3:
				return 37;
		}
		
		return 0;
	}

}
