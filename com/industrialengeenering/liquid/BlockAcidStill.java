package com.industrialengeenering.liquid;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.liquids.ILiquid;

public class BlockAcidStill extends BlockStationary implements ILiquid {

	protected BlockAcidStill(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(100F);
		setLightOpacity(3);
	}

	@Override
	public int stillLiquidId() {
		// TODO Auto-generated method stub
		return 3400;
	}

	@Override
	public boolean isMetaSensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int stillLiquidMeta() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean isBlockReplaceable(World world, int i, int j, int k) {
		return true;
	}
	
}
