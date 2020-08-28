package com.indeng.entity;

import com.indeng.utils.LiquidUtils;

import buildcraft.api.core.Position;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class OsmoGenerator extends TileEntity implements ITankContainer{
	
	
	LiquidTank tank = new LiquidTank(20000);
	boolean istantiated = false;
	
	public boolean find(World world, int blockID, int distance, int xCenter, int yCenter, int zCenter) { 
		for (int z = zCenter - distance; z < zCenter + distance; z++)
	    {
	      for (int x = xCenter - distance; x < xCenter + distance; x++)
	      {
	        for (int y = yCenter - distance; (y < yCenter + distance) && (y > 0) && (y < 128); y++)
	        {
	          if (world.getBlockId(x, y, z) == blockID)
	          {
	            return true;
	          }
	        }
	      }
	    }
    
		return false;
	}
	
	
	public void updateEntity() {
		
		if(!worldObj.isRemote && yCoord < 55) {
			if (find(worldObj, Block.waterMoving.blockID, 2, xCoord, yCoord, zCoord) || find(worldObj, Block.waterStill.blockID, 2, xCoord, yCoord, zCoord)) {
				istantiated = true;
			} else {
				istantiated = false;
			}
		}
		if (istantiated) {
			if(this.tank.getLiquid() != null) {
				if((this.tank.getLiquid().amount + 10) <= this.tank.getCapacity()) {
					tank.fill(LiquidDictionary.getLiquid("Salt Water", 100), true);
				}
			} else {
				tank.fill(LiquidDictionary.getLiquid("Salt Water", 100), true);
			}
		}
		
		LiquidStack liquid = tank.getLiquid();
		if (liquid != null && liquid.amount >= 0) {
			for (int i = 0; i < 6; ++i) {
				Position p = new Position(xCoord, yCoord, zCoord, ForgeDirection.values()[i]);
				p.moveForwards(1);

				TileEntity tile = worldObj.getBlockTileEntity((int) p.x, (int) p.y, (int) p.z);

				if (tile instanceof ITankContainer && !(tile instanceof OsmoGeneratorEnergy)) {
					int moved = ((ITankContainer) tile).fill(p.orientation.getOpposite(), liquid, true);
					tank.drain(moved, true);
					if (liquid.amount <= 0) {
						break;
					}
				}
			}
		}
	}
	
	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		return 0;
	}
	
	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		return 0;
	}
	
	@Override
	public LiquidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
		return drain(0, maxEmpty, doDrain);
	}
	
	@Override
	public LiquidStack drain(int tankIndex, int maxEmpty, boolean doDrain) {
		if (tankIndex == 0)
			return tank.drain(maxEmpty, doDrain);
		return null;
	}
	
	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		return new ILiquidTank[] { this.tank };
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		return tank;
	}
	
	
}
