package com.indeng.block;

import com.indeng.entity.TileEntityPolymerizationUnit;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PolymerizationUnit extends BlockContainer{

	protected PolymerizationUnit(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {

		return new TileEntityPolymerizationUnit();
	}

}
