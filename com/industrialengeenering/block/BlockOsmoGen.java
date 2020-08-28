package com.industrialengeenering.block;

import java.util.Random;

import com.industrialengeenering.core.Core;
import com.industrialengeenering.entity.OsmoGeneratorEnergy;
import com.industrialengeenering.entity.TileEntityTest;
import com.industrialengeenering.utils.BlockContainerRotation;
import com.industrialengeenering.utils.Utils;

import buildcraft.api.core.Position;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockOsmoGen extends BlockContainerRotation {
	
	boolean active = false;
	
	protected BlockOsmoGen(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material, 2, 0, 0, 0, 0, 0);
		//this.active = active;
		setTextureFile("/com/industrialengeenering/sprites/blocks.png");
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new OsmoGeneratorEnergy();
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return ic2.api.Items.getItem("generator").itemID;
	}
}
