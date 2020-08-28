package com.indeng.block;

import com.indeng.entity.TileEntityDistillationTank;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDistillationTank extends BlockContainer{
	
	int gMeta = 0;
	ForgeDirection dir;
	
	protected BlockDistillationTank(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
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
				System.out.println(dir);
			} else if(facing/2 == 1) {
				dir = ForgeDirection.EAST;
				System.out.println(dir);
			} else if(facing/2 == 2) {
				dir = ForgeDirection.SOUTH;
				System.out.println(dir);
			} else if(facing/2 ==  3) {
				dir = ForgeDirection.WEST;
				System.out.println(dir);
			} else {
				dir = ForgeDirection.EAST;
			}
			
				
			
			
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityDistillationTank();
	}
	
	public int getRenderType() {
		return -1;
	}

	public String getTextureFile() {
		return "/com/indeng/sprites/torredist.png";
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}
