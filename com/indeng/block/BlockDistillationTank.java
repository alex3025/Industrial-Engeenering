package com.indeng.block;

import com.indeng.entity.TileEntityDistillationTank;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDistillationTank extends BlockContainer{
	
	
	
	protected BlockDistillationTank(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityDistillationTank();
	}
	
	public int getRenderType() {
		return -1;
	}

	public String getTextureFile() {
		return "/com/industrialengeenering/sprites/torredist.png";
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}
