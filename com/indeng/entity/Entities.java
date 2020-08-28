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
	}
}
