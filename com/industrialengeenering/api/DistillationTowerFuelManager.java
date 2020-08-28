package com.industrialengeenering.api;

import java.util.ArrayList;
import java.util.List;

import com.industrialengeenering.api.DistillationTowerFuel.FuelType;

import net.minecraftforge.liquids.LiquidStack;

public class DistillationTowerFuelManager {
	
	public static List<DistillationTowerFuel> fuels = new ArrayList<DistillationTowerFuel>();
	
	public static boolean isFuelValid(LiquidStack f) {
		for (DistillationTowerFuel fuel : fuels) {
			if (f.isLiquidEqual(fuel.getLiquid())) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int getBurnTime(LiquidStack f) {
		if(isFuelValid(f)) {
			for (DistillationTowerFuel fuel : fuels) {
				if (f.isLiquidEqual(fuel.getLiquid())) {
					return fuel.getBurnTime();
				}
			}
		}
		
		return 0;
	}
	
	public static FuelType getType(LiquidStack f) {
		if(isFuelValid(f)) {
			for (DistillationTowerFuel fuel : fuels) {
				if (f.isLiquidEqual(fuel.getLiquid())) {
					return fuel.getType();
				}
			}
		}
		
		return null;
	}
	
	public static void addFuel(DistillationTowerFuel fuel) {
		fuels.add(fuel);
	}
	
}
