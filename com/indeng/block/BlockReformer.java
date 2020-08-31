package com.indeng.block;

import com.indeng.core.Core;
import com.indeng.entity.TileEntityCracker;
import com.indeng.entity.TileEntityReformer;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockReformer extends BlockContainer {
	int gMeta = 0;
	ForgeDirection dir;
	
	protected BlockReformer(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);

	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityReformer(dir);
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

		if (tile_entity instanceof TileEntityReformer) {

			TileEntityReformer cast_tile_entity = (TileEntityReformer) tile_entity;
			player.openGui(Core.instance, 1, world, x, y, z);

		}
		return true;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity) {
		super.onBlockPlacedBy(world, x, y, z, entity);
		if ((entity instanceof EntityPlayer)) {
			int yaw = (int) entity.rotationYaw;

			if (yaw < 0)
				yaw += 360;
			yaw += 22;
			yaw %= 360;
			int facing = yaw / 45;
			
			world.setBlockMetadataWithNotify(x, y, z, facing / 2);

			if(facing/2 == 0) {
				dir = ForgeDirection.NORTH;
			} else if(facing/2 == 1) {
				dir = ForgeDirection.EAST;
			} else if(facing/2 == 2) {
				dir = ForgeDirection.SOUTH;
			} else if(facing/2 ==  3) {
				dir = ForgeDirection.WEST;
			} else {
				dir = ForgeDirection.EAST;
			}
			
		}
	}
	
	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
}
