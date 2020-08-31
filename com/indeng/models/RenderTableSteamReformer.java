package com.indeng.models;

import org.lwjgl.opengl.GL11;

import com.indeng.block.Blocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class RenderTableSteamReformer extends TileEntitySpecialRenderer {
	private ModelSteamReformer Cracker;
	
	public RenderTableSteamReformer() {
		Cracker = new ModelSteamReformer();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float var8) {
		int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord,
				tileentity.zCoord);

		int direction = 2;
		if (tileentity.getWorldObj().getBlockId(tileentity.xCoord, tileentity.yCoord,
				tileentity.zCoord) == Blocks.blockSteamReformer.blockID) {
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
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		
		GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);
		bindTextureByName("/com/indeng/sprites/SteamReformer.png");
		Cracker.render((Entity) null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
