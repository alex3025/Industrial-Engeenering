package com.industrialengeenering.block;

import java.util.Random;

import com.industrialengeenering.entity.OsmoGenerator;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockOsmo extends BlockContainerRotation {

	protected BlockOsmo(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material, 1, 1, 0, 0, 0, 0);
		setTextureFile("/com/industrialengeenering/sprites/blocks.png");
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new OsmoGenerator();
	}
	
	//@SideOnly(Side.CLIENT)
    //public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
    //    par1World.spawnParticle("water", par2, par3 + 1, par4, 0.0D, 0.0D, 0.0D);
    //}
}
