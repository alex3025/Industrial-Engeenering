package com.industrialengeenering.utils;

import buildcraft.api.core.Position;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public class Utils {
	public static ForgeDirection get2dOrientation(Position pos1, Position pos2) {
		double Dx = pos1.x - pos2.x;
		double Dz = pos1.z - pos2.z;
		double angle = Math.atan2(Dz, Dx) / Math.PI * 180 + 180;

		if (angle < 45 || angle > 315)
			return ForgeDirection.EAST;
		else if (angle < 135)
			return ForgeDirection.SOUTH;
		else if (angle < 225)
			return ForgeDirection.WEST;
		else
			return ForgeDirection.NORTH;
	}
	
	public static ItemStack getItemByName(String name) {
		for(int i=0; i < Item.itemsList.length; i++) {
			if (Item.itemsList[i] != null) {
				if(Item.itemsList[i].getItemName() == name) {
					return new ItemStack(Item.itemsList[i]);
				}
			}
		}
		
		return null;
	}
	
	public static ItemStack getItemByID(int id) {
		for(int i=0; i < Item.itemsList.length; i++) {
			if (Item.itemsList[i] != null) {
				if(Item.itemsList[i].itemID == id) {
					return new ItemStack(Item.itemsList[i]);
				}
			}
		}
		
		return null;
	}
	
}
