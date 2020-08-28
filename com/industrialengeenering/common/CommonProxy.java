package com.industrialengeenering.common;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;


import com.industrialengeenering.item.ItemCellCO;
import com.industrialengeenering.item.Items;
import com.industrialengeenering.utils.LiquidUtils;
import com.industrialengeenering.utils.Utils;

import com.industrialengeenering.api.DistillationTowerFuel;
import com.industrialengeenering.api.DistillationTowerFuel.FuelType;
import com.industrialengeenering.api.DistillationTowerFuelManager;
import com.industrialengeenering.item.ItemCellCO;
import com.industrialengeenering.item.Items;
import com.industrialengeenering.utils.LiquidUtils;
import com.industrialengeenering.utils.Utils;


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
		return null;
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
		
		// IC2 Extractor: Salt Water Cell > Empty Cell
		Ic2Recipes.addExtractorRecipe(new ItemStack(LiquidUtils.items.get(0), 1, 0), new ItemStack(ic2.api.Items.getItem("cell").itemID, 1, 0));
		
		// Smelting: Salt Water Cell > Water Cell
		GameRegistry.addSmelting(LiquidUtils.items.get(0).itemID, new ItemStack(ic2.api.Items.getItem("waterCell").itemID, 1, 0), 0);
	}

	public static void initLiquids() {
		
		//Diesel
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("Fuel", LiquidContainerRegistry.BUCKET_VOLUME), 6000, FuelType.LIQUID));
		
		//GPL
		LiquidUtils.addLiquid("GPL", 3405, 1, 3406, 1, new ArrayList<String>(){{add("C3H8, C4");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("GPL", LiquidContainerRegistry.BUCKET_VOLUME), 84000);
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("GPL", LiquidContainerRegistry.BUCKET_VOLUME), 3900, FuelType.GAS));
		
		//CO
		LiquidUtils.addLiquid("Carbon Monoxide", 3419, 8, new ItemCellCO(3420).setIconIndex(7));
		
		//Gasoline
		LiquidUtils.addLiquid("Gasoline", 3407, 2, 3408, 2, new ArrayList<String>(){{add("C8");}});
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 10, 90000));
		
		//Naphtha
		LiquidUtils.addLiquid("Kerosene", 3409, 3, 3410, 3, new ArrayList<String>(){{add("C15");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Kerosene", LiquidContainerRegistry.BUCKET_VOLUME), 41000);
		
		//HFO
		LiquidUtils.addLiquid("HFO", 3411, 4, 3412, 4, new ArrayList<String>(){{add("C24");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("HFO", LiquidContainerRegistry.BUCKET_VOLUME), 105000);
		DistillationTowerFuelManager.addFuel(new DistillationTowerFuel(LiquidDictionary.getLiquid("HFO", LiquidContainerRegistry.BUCKET_VOLUME), 6600, FuelType.LIQUID));
		
		//BunkerC
		LiquidUtils.addLiquid("Bunker C", 3415, 6, 3416, 6, new ArrayList<String>(){{add("Category H");}});
		
		//Heated BunkerC
		LiquidUtils.addLiquid("Heated Bunker C", 3417, 7, 3418, 6, new ArrayList<String>(){{add("Category H"); add("This can be burnt in a boiler");}});
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Heated Bunker C", LiquidContainerRegistry.BUCKET_VOLUME), 125000);
		
		//Crude residue
		LiquidUtils.addLiquid("Crude Residue", 3413, 5, 3414, 5, new ArrayList<String>(){{add("> C24");}});
		
		//Salt Water
		LiquidUtils.addLiquid("Salt Water", 3404, 0, 3400, 0, new ArrayList<String>(){{add("H2O, NaCl");}});
		
	}

}
