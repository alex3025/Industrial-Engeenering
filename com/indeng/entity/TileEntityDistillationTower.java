package com.indeng.entity;
import com.indeng.api.DistillationTowerFuelManager;
import com.indeng.api.DistillationTowerFuel.FuelType;
import com.indeng.block.BlockDistillationTower;
import com.indeng.block.Blocks;

import ic2.api.Direction;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityDistillationTower extends TileEntity implements ITankContainer {
	

	int crudeP = 0;
	int hfoP = 0;
	int fuelP = 0;
	int kerosenP = 0;
	int gasolineP = 0;
	int gplP = 0;
	public boolean formed;
	public boolean fueled;
	public boolean lastFueled = false;
	public LiquidTank tank = new LiquidTank(20000);
	public LiquidTank fuel = new LiquidTank(16000);
	public int burnTime;
	public FuelType currentType = FuelType.LIQUID;
	
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.burnTime);
        if(this.currentType == FuelType.LIQUID) {
        	par1NBTTagCompound.setShort("Type", (short)1);
        } else if(this.currentType == FuelType.GAS) {
        	par1NBTTagCompound.setShort("Type", (short)2);
        } else {
        	par1NBTTagCompound.setShort("Type", (short)1);
        }
        
        if (fuel.getLiquid() != null) {
        	par1NBTTagCompound.setInteger("fLiquidId", fuel.getLiquid().itemID);
        	par1NBTTagCompound.setInteger("fStored", fuel.getLiquid().amount);
		}
        
        if (tank.getLiquid() != null) {
        	par1NBTTagCompound.setInteger("oLiquidId", tank.getLiquid().itemID);
        	par1NBTTagCompound.setInteger("oStored", tank.getLiquid().amount);
		}
        
    }
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.burnTime = par1NBTTagCompound.getShort("BurnTime");
        if(par1NBTTagCompound.getShort("Type") == (short)1) {
        	this.currentType = FuelType.LIQUID;
        } else if(par1NBTTagCompound.getShort("Type") == (short)2) {
        	this.currentType = FuelType.GAS;
        } else {
        	this.currentType = FuelType.LIQUID;
        }
        
        if (par1NBTTagCompound.hasKey("oStored") && par1NBTTagCompound.hasKey("oLiquidId")) {
			LiquidStack liquid = new LiquidStack(par1NBTTagCompound.getInteger("oLiquidId"), par1NBTTagCompound.getInteger("oStored"), 0);
			tank.setLiquid(liquid);
		}
        
        if (par1NBTTagCompound.hasKey("fStored") && par1NBTTagCompound.hasKey("fLiquidId")) {
			LiquidStack liquid = new LiquidStack(par1NBTTagCompound.getInteger("fLiquidId"), par1NBTTagCompound.getInteger("fStored"), 0);
			fuel.setLiquid(liquid);
			
		}

    }
	
	public void updateEntity() {
		
		if(!worldObj.isRemote) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			
			crudeP = 0;
			hfoP = 0;
			fuelP = 0;
			kerosenP = 0;
			gasolineP = 0;
			gplP = 0;
			
			if(fuel.getLiquid() != null) {
				if(fuel.getLiquid().amount >= 1000 && !fueled) {
					if(DistillationTowerFuelManager.isFuelValid(fuel.getLiquid())) {
						this.burnTime += DistillationTowerFuelManager.getBurnTime(fuel.getLiquid());
						if(DistillationTowerFuelManager.getType(fuel.getLiquid()) == FuelType.LIQUID) {
							this.currentType = FuelType.LIQUID;
							//BlockDistillationTower.updateDistillationState(worldObj, xCoord, yCoord, zCoord, Blocks.blockDistillationDiesel.blockID);
						} else if(DistillationTowerFuelManager.getType(fuel.getLiquid()) == FuelType.GAS) {
							this.currentType = FuelType.GAS;
							//BlockDistillationTower.updateDistillationState(worldObj, xCoord, yCoord, zCoord, Blocks.blockDistillationGPL.blockID);
						}
						this.fuel.drain(1000, true);
					}
				}
			}
			
			fueled = burnTime > 0;
			
			if(!fueled) {
				BlockDistillationTower.updateDistillationState(worldObj, xCoord, yCoord, zCoord, Blocks.blockDistillationIdle.blockID);
			} 
			if(fueled) {
				if(this.currentType == FuelType.LIQUID) {
					BlockDistillationTower.updateDistillationState(worldObj, xCoord, yCoord, zCoord, Blocks.blockDistillationDiesel.blockID);
				} else {
					BlockDistillationTower.updateDistillationState(worldObj, xCoord, yCoord, zCoord, Blocks.blockDistillationGPL.blockID);
				}
			}
			
			if(!worldObj.isRemote) {
				if(burnTime > 0) {
					burnTime--;
					System.out.println(fueled);
				}
			}
			
			/*
			if(fuel.getLiquid() != null) {
				if(fuel.getLiquid().isLiquidEqual(LiquidDictionary.getLiquid("Fuel", fuel.getLiquid().amount))) {
					if (!this.lastFueled || tickForFuel >= 20*120) {
						if (this.fuel.getLiquid() != null) {
							if(this.fuel.getLiquid().amount >= 1000) {
								TileEntityDistillationTower te = this;
								this.worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, Blocks.blockDistillationDiesel.blockID, this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
								this.worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
								this.lastFueled = true;
								this.tickForFuel = 0;
								this.fueled = true;
								this.lastFuelEntered = 1;
								this.fuel.drain(1000, true);
							} else {
								this.fueled = false;
							}
						} else {
							this.fueled = false;
						}
					}
				} else if(fuel.getLiquid().isLiquidEqual(LiquidDictionary.getLiquid("GPL", fuel.getLiquid().amount))) {
					if (!this.lastFueled || tickForFuel >= 20*90) {
						this.tickForFuel = 0;
						System.out.println("Ticcato");
						if (this.fuel.getLiquid() != null) {
							if(this.fuel.getLiquid().amount >= 1000) {
								TileEntityDistillationTower te = this;
								this.worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, Blocks.blockDistillationGPL.blockID, this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
								this.worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
								this.lastFueled = true;
								this.fueled = true;
								this.lastFuelEntered = 2;
								this.fuel.drain(1000, true);
								System.out.println("Accendo");
							} else {
								this.fueled = false;
							}
						} else {
							this.fueled = false;
						}
					}
				} else {
					TileEntityDistillationTower te = this;
					this.worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, Blocks.blockDistillationIdle.blockID, this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
					this.worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
				}
			} else {
				this.lastFueled = false;
			}
			*/
			
			if(fueled) {
				if(this.tank.getLiquid() != null) {
					worldObj.spawnParticle("smoke", (double)(xCoord + 0.5), (double)yCoord+7.3, (double)(zCoord + 0.5), 0.0D, 0.2D, 0.0D);
					if (tank.getLiquid().amount >= 1000) {
						crudeP = (tank.getLiquid().amount * 17)/100;
						hfoP = (tank.getLiquid().amount * 10)/100;
						fuelP = (tank.getLiquid().amount * 35)/100;
						kerosenP = (tank.getLiquid().amount * 7)/100;
						gasolineP = (tank.getLiquid().amount * 18)/100;
						gplP = (tank.getLiquid().amount * 13)/100;
						tank.drain(1000, true);
					}
				}
			}
			
			checkFormed();
			
			if(fueled && this.formed) {
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) != null) {
					TileEntityDistillationTank block1 = (TileEntityDistillationTank)worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
					if(block1.tank != null) {
						block1.tank.fill(LiquidDictionary.getLiquid("Crude Residue", crudeP), true);
					}
				}
				
				if(worldObj.getBlockTileEntity(xCoord, yCoord+2, zCoord) != null){
					TileEntityDistillationTank block2 = (TileEntityDistillationTank)worldObj.getBlockTileEntity(xCoord, yCoord+2, zCoord);
					if(block2.tank != null) {
						block2.tank.fill(LiquidDictionary.getLiquid("HFO", hfoP), true);
					}
				}
				
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) != null){
					TileEntityDistillationTank block3 = (TileEntityDistillationTank)worldObj.getBlockTileEntity(xCoord, yCoord+3, zCoord);
					if(block3.tank != null) {
						block3.tank.fill(LiquidDictionary.getLiquid("Fuel", fuelP), true);
					}
				}
				
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) != null){
					TileEntityDistillationTank block4 = (TileEntityDistillationTank)worldObj.getBlockTileEntity(xCoord, yCoord+4, zCoord);
					if(block4.tank != null) {
						block4.tank.fill(LiquidDictionary.getLiquid("Kerosene", kerosenP), true);
					}
				}
				
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) != null){
					TileEntityDistillationTank block5 = (TileEntityDistillationTank)worldObj.getBlockTileEntity(xCoord, yCoord+5, zCoord);
					if(block5.tank != null) {
						block5.tank.fill(LiquidDictionary.getLiquid("Gasoline", gasolineP), true);
					}
				}
				
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) != null){
					TileEntityDistillationTank block6 = (TileEntityDistillationTank)worldObj.getBlockTileEntity(xCoord, yCoord+6, zCoord);
					if(block6.tank != null) {
						block6.tank.fill(LiquidDictionary.getLiquid("GPL", gplP), true);
					}
				}
				
				
				
			}
		}
	}
	
	public void checkFormed() {
		int finded = 0;
		for (int i=1; i < 7; i++) {
			int block = worldObj.getBlockId(xCoord, yCoord+i, zCoord);
			if (block == Blocks.blockDistillationTank.blockID) {
				finded++;
			}
		}
		
		if (finded == 6) {
			this.formed = true;
		} else {
			this.formed = false;
		}
	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		if(!formed) 
			return 0;
		
		return fill(0, resource, doFill);
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		
		if(resource == null) {
			return 0;
		}
		
		if(resource.isLiquidEqual(LiquidDictionary.getLiquid("Oil", resource.amount))) {
			if(!formed) 
				return 0;
			
			if (tankIndex != 0 || resource == null) {
				return 0;
			}
			
			if(this.tank.getLiquid() == null) {
				if(resource.amount <= this.tank.getCapacity()) {
					tank.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.tank.getLiquid().amount + resource.amount) <= this.tank.getCapacity()) {
				tank.fill(resource, doFill);
				return resource.amount;
			}
		} else if(DistillationTowerFuelManager.isFuelValid(resource)) {
			
			if(!formed) 
				return 0;
			
			if (tankIndex != 0 || resource == null) {
				return 0;
			}
			
			if(this.fuel.getLiquid() == null) {
				if(resource.amount <= this.fuel.getCapacity()) {
					fuel.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.fuel.getLiquid().amount + resource.amount) <= this.fuel.getCapacity()) {
				fuel.fill(resource, doFill);
				return resource.amount;
			}
		}
		
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return drain(0, maxDrain, doDrain);
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		if (tankIndex == 0)
			return tank.drain(maxDrain, doDrain);
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		// TODO Auto-generated method stub
		return new ILiquidTank[] {tank};
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return tank;
	}
	

	
	
}
