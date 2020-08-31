package com.indeng.entity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class Entities {
	
	
	public static void registerEntities() {
		GameRegistry.registerTileEntity(TileEntityTest.class, "tileentitytest");
		GameRegistry.registerTileEntity(OsmoGenerator.class, "teOsmoGenerator");
		GameRegistry.registerTileEntity(OsmoGeneratorEnergy.class, "teOsmoGeneratorEnergy");
		GameRegistry.registerTileEntity(TileEntityDistillationTower.class, "teDistillation");
		GameRegistry.registerTileEntity(TileEntityDistillationTank.class, "teDistillationTank");
		GameRegistry.registerTileEntity(TileEntityPolymerizationUnit.class, "tePolymerization");
		GameRegistry.registerTileEntity(TileEntityBunkerCHeater.class, "teBunkerCHeater");
		GameRegistry.registerTileEntity(TileEntityMiscelator.class, "teMiscelator");
		GameRegistry.registerTileEntity(TileEntityCatalystRegen.class, "teCatalystRegen");
		GameRegistry.registerTileEntity(TileEntityVacuumDistillationTower.class, "teVacuumDistillationTower");
		GameRegistry.registerTileEntity(TileEntityCracker.class, "teCracker");
		GameRegistry.registerTileEntity(TileEntityHydroCracker.class, "teHydroCracker");
	}
}
