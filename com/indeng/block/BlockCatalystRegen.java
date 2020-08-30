package com.indeng.block;

import com.indeng.core.Core;
import com.indeng.entity.TileEntityCatalystRegen;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCatalystRegen extends BlockContainer {

	protected BlockCatalystRegen(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		
	}
	
	
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int i, float f, float g, float t) {
		// Just making an instance of the TileEntity that the player clicked on
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity == null || player.isSneaking()) {
			return false;
		}

		if (world.isRemote) {
			return true;
		}

		if (tile_entity instanceof TileEntityCatalystRegen) {

			TileEntityCatalystRegen cast_tile_entity = (TileEntityCatalystRegen) tile_entity;
			player.openGui(Core.instance, 0, world, x, y, z);

		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityCatalystRegen();
	}

}
