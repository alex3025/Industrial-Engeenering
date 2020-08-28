package com.indeng.item;

import java.util.List;
import java.util.Random;

import com.indeng.utils.DeathDrink;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemCellCO extends DeathDrink {
	public ItemCellCO(int par1) {
		super(par1, 0, true);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack parItemStack, EntityPlayer parPlayer, List parList, boolean parBool) {
		parList.add("CO");
	}
}
