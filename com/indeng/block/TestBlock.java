package com.indeng.block;

import com.indeng.entity.TileEntityMultiBlock;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestBlock extends BlockContainer{

	protected TestBlock(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityMultiBlock();
	}

}
