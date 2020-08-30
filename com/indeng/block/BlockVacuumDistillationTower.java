package com.indeng.block;

import com.indeng.entity.TileEntityDistillationTower;
import com.indeng.entity.TileEntityVacuumDistillationTower;
import com.indeng.utils.Utils;

import buildcraft.api.core.Position;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockVacuumDistillationTower extends BlockContainer {
	
	String fuel;
	
	protected BlockVacuumDistillationTower(int par1, int par2, Material par3Material, String fuel) {
		super(par1, par2, par3Material);
		setTextureFile("/com/indeng/sprites/blocks.png");
		this.fuel = fuel;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {

		return new TileEntityVacuumDistillationTower();
	}
	
	public static void updateDistillationState(World worldObj, int x, int y, int z, int id) {
		worldObj.markBlockForUpdate(x, y, z);
		TileEntity te = worldObj.getBlockTileEntity(x, y, z);
		
		worldObj.setBlockAndMetadataWithNotify(x, y, z, id, worldObj.getBlockMetadata(x, y, z));
		
		if(te != null) {
			te.validate();
			worldObj.setBlockTileEntity(x, y, z, te);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		super.onBlockPlacedBy(world, i, j, k, entityliving);

		ForgeDirection orientation = Utils.get2dOrientation(new Position(entityliving.posX, entityliving.posY, entityliving.posZ), new Position(i, j, k));

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
		
		int front = 17;
		
		if(this.fuel == "fuel") {
			front = 19;
		} else if(this.fuel == "gpl") {
			front = 18;
		}
		
		if (metadata == 0 && blockSide == 3)
			return front;

		
		if (blockSide == 1)
			return 16;

		if (blockSide == metadata)
			return front;
		
		
		
		
		// Lati
		return 16;

	}
	
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
		return new ItemStack(Blocks.blockVacuumDistillation, 1);
		
	}

}
