package com.indeng.common;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.indeng.api.DistillationTowerFuel;
import com.indeng.api.DistillationTowerFuelManager;
import com.indeng.containers.ContainerCatalystRegen;
import com.indeng.containers.ContainerCracking;
import com.indeng.containers.ContainerReformer;
import com.indeng.api.DistillationTowerFuel.FuelType;
import com.indeng.entity.TileEntityCatalystRegen;
import com.indeng.entity.TileEntityCracker;
import com.indeng.entity.TileEntityReformer;
import com.indeng.guis.GuiCatalystRegen;
import com.indeng.item.ItemCellCO;
import com.indeng.item.Items;
import com.indeng.utils.LiquidUtils;
import com.indeng.utils.Utils;

import buildcraft.api.fuels.IronEngineFuel;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ic2.api.Ic2Recipes;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import railcraft.common.api.fuel.FuelManager;

public class CommonProxy implements IGuiHandler{
	public static LiquidStack acidStack;
	public static ItemStack acidItemStack;
	public static Item acidItem;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityCatalystRegen) {
			TileEntityCatalystRegen temg = (TileEntityCatalystRegen) te;
			return new ContainerCatalystRegen(player.inventory, temg);
		} else if (te != null && te instanceof TileEntityCracker) {
			TileEntityCracker temg = (TileEntityCracker) te;
			return new ContainerCracking(player.inventory, temg);
		} else if (te != null && te instanceof TileEntityReformer) {
			TileEntityReformer temg = (TileEntityReformer) te;
			return new ContainerReformer(player.inventory, temg);
		} else {
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public void registerRenderThings() {
		
	}
	
	public void preInit() {}
	
	public void init() {
		for(int i=0; i < Item.itemsList.length; i++) {
			if(Item.itemsList[i] != null) {
				//System.out.println(Utils.getItemByID(1059).getItemName());
			}
		}
		System.out.println("Loading common proxy");
		initLiquids();
		registerRenderThings();
		
		// Recipes
        CraftingHandler.initRecipes();
	}

	public static void initLiquids() {
		// Town Gas
		LiquidUtils.addLiquid("Town Gas", 3822, 9, 21523, 8, new ArrayList<String>(){{add("CO, H2");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Town Gas", LiquidContainerRegistry.BUCKET_VOLUME), 78800);
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("Town Gas", LiquidContainerRegistry.BUCKET_VOLUME), 3660, FuelType.GAS));
		
		// Diesel
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("Fuel", LiquidContainerRegistry.BUCKET_VOLUME), 6000, FuelType.LIQUID));
		
		// GPL
		LiquidUtils.addLiquid("GPL", 3405, 1, 21506, 1, new ArrayList<String>(){{add("C3H8, C4");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("GPL", LiquidContainerRegistry.BUCKET_VOLUME), 84000);
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("GPL", LiquidContainerRegistry.BUCKET_VOLUME), 3900, FuelType.GAS));
		
		// CO
		LiquidUtils.addLiquid("Carbon Monoxide", 3819, 8, new ItemCellCO(21520).setIconIndex(7));
		
		// Gasoline
		LiquidUtils.addLiquid("Gasoline", 3807, 2, 21508, 2, new ArrayList<String>(){{add("C8");}});
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 10, 90000));
		
		// Naphtha
		LiquidUtils.addLiquid("Kerosene", 3809, 3, 21510, 3, new ArrayList<String>(){{add("C15");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Kerosene", LiquidContainerRegistry.BUCKET_VOLUME), 41000);
		
		// HFO
		LiquidUtils.addLiquid("HFO", 3811, 4, 21512, 4, new ArrayList<String>(){{add("C24");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("HFO", LiquidContainerRegistry.BUCKET_VOLUME), 105000);
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("HFO", LiquidContainerRegistry.BUCKET_VOLUME), 6600, FuelType.LIQUID));
		
		// BunkerC
		LiquidUtils.addLiquid("Bunker C", 3815, 6, 21516, 81, new ArrayList<String>(){{add("Category H");}});
		
		// Heated BunkerC
		LiquidUtils.addLiquid("Heated Bunker C", 3817, 7, 21518, 82, new ArrayList<String>(){{add("Category H"); add("This can be burnt in a boiler");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Heated Bunker C", LiquidContainerRegistry.BUCKET_VOLUME), 125000);
		
		// Crude residue
		LiquidUtils.addLiquid("Crude Residue", 3813, 5, 21514, 5, new ArrayList<String>(){{add("> C24");}});
		
		// Salt Water
		LiquidUtils.addLiquid("Salt Water", 3804, 0, 21500, 0, new ArrayList<String>(){{add("H2O, NaCl");}});
		
		// Hasphalt
		LiquidUtils.addLiquid("Hasphalt", 3824, 10, 21525, 83, new ArrayList<String>(){{add("> C90");}});
		
		// Paraffin
		LiquidUtils.addLiquid("Paraffin", 3826, 11, 21527, 84, new ArrayList<String>(){{add("> C20");}});
		
		// Lubricant
		LiquidUtils.addLiquid("Lubricant", 3828, 12, 21529, 85, new ArrayList<String>(){{add("> H18, O35");}});
	}
}
