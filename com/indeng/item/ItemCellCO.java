package com.indeng.item;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemCellCO extends ItemFood {
	public ItemCellCO(int par1) {
		super(par1, 0, true);
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
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack parItemStack, EntityPlayer parPlayer, List parList, boolean parBool) {
		parList.add("CO");
	}
}
