package com.indeng.guis;

import org.lwjgl.opengl.GL11;

import com.indeng.containers.ContainerCatalystRegen;
import com.indeng.entity.TileEntityCatalystRegen;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class GuiCatalystRegen extends GuiContainer {
	
	private TileEntityCatalystRegen tileEntity;
	
	public GuiCatalystRegen(IInventory player, TileEntityCatalystRegen chest) {
		super(new ContainerCatalystRegen(player, chest));
		
	}

	
	@Override
	protected void drawGuiContainerForegroundLayer(int p1, int p2) {
        this.drawCenteredString(fontRenderer, "Catalyst Regenerating Unit", this.xSize/2, 4, 0x404040);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		int k = mc.renderEngine.getTexture("/com/indeng/sprites/guis/gui_catalyzer.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	@Override
	public void drawCenteredString(FontRenderer par1FontRenderer,
			String par2Str, int par3, int par4, int par5) {
		par1FontRenderer.drawString(par2Str, par3 - par1FontRenderer.getStringWidth(par2Str) / 2, par4, par5);
	}

}
