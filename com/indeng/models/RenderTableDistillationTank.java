package com.indeng.models;

import org.lwjgl.opengl.GL11;

import com.indeng.block.BlockDistillationTank;
import com.indeng.block.Blocks;
import com.indeng.entity.TileEntityDistillationTank;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class RenderTableDistillationTank extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
	private ModelDistillationTower DistillationTank;
	
	public RenderTableDistillationTank() {
		DistillationTank = new ModelDistillationTower();

	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale) {
		
		int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord,
				tileentity.zCoord);

		int direction = 2;
		if (tileentity.getWorldObj().getBlockId(tileentity.xCoord, tileentity.yCoord,
				tileentity.zCoord) == Blocks.blockDistillationTank.blockID) {
			direction = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord,
					tileentity.zCoord) + 1;
			if (direction == 1) {
				direction = 3;
			} else if (direction == 3) {
				direction = 1;
			} else if (direction == 2) {
				direction = 4;
			} else if (direction == 4) {
				direction = 2;
			}
		}
		
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
		
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		
		GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);
		
		bindTextureByName("/com/indeng/sprites/torredist.png");
		DistillationTank.render((Entity) null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		bindTextureByName("/com/indeng/sprites/torredist.png");
        GL11.glPushMatrix();
        GL11.glTranslated(-0.5, -0.5625, -0.5);
        DistillationTank.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glPopMatrix();

    }

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return -1;
	}

}
