package com.indeng.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class DeathDrink extends ItemFood {
	public DeathDrink(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
	}

	@Override
	public ItemStack onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		--stack.stackSize;
		
		player.inventory.addItemStackToInventory(ic2.api.Items.getItem("cell"));
		player.heal(-10000);
		return stack;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
}
