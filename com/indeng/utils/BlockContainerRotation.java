package com.indeng.utils;

import buildcraft.api.core.Position;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockContainerRotation extends BlockContainer {
	private ForgeDirection forgeDirection;
	int frontIndex;
	int topIndex;
	int backIndex;
	int bottomIndex;
	int leftIndex;
	int rightIndex;

	public BlockContainerRotation(int id, int meta, Material material, int frontIndex, int backIndex, int topIndex, int bottomIndex, int leftIndex, int rightIndex) {
		super(id, meta, material);
		
		this.frontIndex = frontIndex;
		this.backIndex = backIndex;
		this.topIndex = topIndex;
		this.bottomIndex = bottomIndex;
		this.leftIndex = leftIndex;
		this.rightIndex = rightIndex;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		super.onBlockPlacedBy(world, i, j, k, entityliving);

		ForgeDirection orientation = Utils.get2dOrientation(new Position(entityliving.posX, entityliving.posY, entityliving.posZ), new Position(i, j, k));
		System.out.println(orientation.getOpposite().ordinal());
		System.out.println(orientation);
		System.out.println(" ");

		world.setBlockMetadataWithNotify(i, j, k, orientation.getOpposite().ordinal());
	}

	@Override
	public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return getBlockTextureFromSideAndMetadata(l, iblockaccess.getBlockMetadata(i, j, k));
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int blockSide, int metadata) {
		// blockSide values
		// 0: Bottom
		// 1: Top
		// 2: Back
		// 3: Front
		// 4: Left
		// 5: Right
		
		/*
		if (metadata == 0 && blockSide == 3)
			return this.frontIndex;

		if (metadata == 0 && blockSide == 2)
			return this.backIndex;
		
		if (blockSide == 1)
			return this.topIndex;

		if (blockSide == metadata)
			return this.frontIndex;
		*/
		
		switch(metadata) {
			case 0:
				switch(blockSide) {
					case 3:
						return this.frontIndex;
					case 2:
						return this.backIndex;
					case 1:
						return this.topIndex;
					case 0:
						return this.frontIndex;
				}
		}
		
		// Lati
		return 0;

	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return null;
	}
}
