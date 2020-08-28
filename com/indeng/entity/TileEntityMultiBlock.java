package com.indeng.entity;

import com.indeng.block.Blocks;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMultiBlock extends TileEntity{
	
	private boolean formed;
	private boolean foundInvalidBlock;
    private int inventoriesFound;
    private IInventory inventory;
    private int checkingX, checkingY, checkingZ;
	
    @Override
    public void updateEntity(){
        super.updateEntity();

        if(!worldObj.isRemote) {
            checkMultiblock();
            if(formed) {
                System.out.println("Struttura formata!");
            }
        }
    }
    
    private void checkMultiblock(){
        checkingX++;
        if(checkingX > 1) {
            checkingX = -1;
            checkingY++;
            if(checkingY > 1) {
                checkingY = -1;
                checkingZ++;
                if(checkingZ > 1) {
                    checkingZ = -1;
                    formed = !foundInvalidBlock && inventoriesFound == 1;
                    foundInvalidBlock = false;
                    inventoriesFound = 0;
                }
            }
        }

        if(checkingX == 0 && checkingY == 0 && checkingZ == 0) return;
        int block = worldObj.getBlockId(xCoord + checkingX, yCoord + checkingY, zCoord + checkingZ);

        if(checkingX == 0 && checkingZ == 0 && checkingY == 1) {
            if(block != Block.dirt.blockID && block != Block.grass.blockID) {
                foundInvalidBlock = true;
            }
        } else if(checkingY == 1 && checkingX != 0 ^ checkingZ != 0) {
            TileEntity te = worldObj.getBlockTileEntity(xCoord + checkingX, yCoord + checkingY, zCoord + checkingZ);
            if(te instanceof IInventory) {
                inventoriesFound++;
                inventory = (IInventory)te;
            } else if(block != Block.blockSteel.blockID) {
                foundInvalidBlock = true;
            }
        } else if(block != Block.blockSteel.blockID) {
            foundInvalidBlock = true;
        }
    }
	
}
