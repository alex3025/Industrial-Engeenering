package com.industrialengeenering.item;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemCellCO extends ItemFood{
	
	
	public ItemCellCO(int par1) {
		super(par1, 0, true);
	}
	
	public ItemStack onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		stack.stackSize --;
		
		player.inventory.addItemStackToInventory(ic2.api.Items.getItem("cell"));
		player.heal(-10000);
		return stack;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack parItemStack, EntityPlayer parPlayer, List parList, boolean parBool) {
		parList.add("CO");
	}
	
	
}
