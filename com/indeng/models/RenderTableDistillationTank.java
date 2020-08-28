package com.indeng.models;

import org.lwjgl.opengl.GL11;

import com.indeng.block.BlockDistillationTank;
import com.indeng.entity.TileEntityDistillationTank;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class RenderTableDistillationTank extends TileEntitySpecialRenderer {
	private ModelDistillationTower DistillationTank;
	
	public RenderTableDistillationTank() {
		DistillationTank = new ModelDistillationTower();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		bindTextureByName("/com/industrialengeenering/sprites/torredist.png");
		DistillationTank.render((Entity) null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
