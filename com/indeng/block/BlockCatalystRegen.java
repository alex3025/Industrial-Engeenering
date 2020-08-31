package com.indeng.block;

import java.util.Random;

import com.indeng.core.Core;
import com.indeng.entity.TileEntityCatalystRegen;
import com.indeng.entity.TileEntityDistillationTank;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCatalystRegen extends BlockContainer {

	int gMeta = 0;
	ForgeDirection dir;
	private Random random = new Random();
	
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
	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
		TileEntityCatalystRegen var7 = (TileEntityCatalystRegen)par1World.getBlockTileEntity(par2, par3, par4);

        if (var7 != null)
        {
            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var14;

                    for (float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World.spawnEntityInWorld(var14))
                    {
                        int var13 = this.random.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.random.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.random.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.random.nextGaussian() * var15);

                        if (var9.hasTagCompound())
                        {
                            var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
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
	
	
	public String getTextureFile() {
		return "/com/indeng/sprites/torredist.png";
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public int getRenderType() {
		return -1;
	}

}
