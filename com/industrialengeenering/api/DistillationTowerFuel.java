package com.industrialengeenering.api;

import net.minecraftforge.liquids.LiquidStack;

public class DistillationTowerFuel {
	
	LiquidStack liquid;
	int burnTime;
	FuelType type;
	public enum FuelType{
		GAS,
		LIQUID
	}
	
	public DistillationTowerFuel(LiquidStack liquid, int burnTime, FuelType type) {
		this.liquid = liquid;
		this.burnTime = burnTime;
		this.type = type;
	}
	
	
	public LiquidStack getLiquid() {
		return this.liquid;
	}
	
	public int getBurnTime() {
		return this.burnTime;
	}
	
	public FuelType getType() {
		return this.type;
	}
	
}
