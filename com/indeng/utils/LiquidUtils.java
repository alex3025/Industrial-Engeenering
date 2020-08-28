package com.indeng.utils;

import java.util.ArrayList;
import java.util.List;

import com.indeng.client.TextureLiquidsFX;
import com.indeng.core.ModCreativeTab;
import com.indeng.item.ItemCell;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;

public class LiquidUtils {
	
	public static List<LiquidStack> liquids = new ArrayList<LiquidStack>();
	public static List<Item> items = new ArrayList<Item>();
	
	public static void addLiquid(String name, int id, int index, int cellID, int cellIndex, List toolTip) {
		Item itemCell = new ItemCell(cellID, toolTip).setItemName(name.toLowerCase() + "Cell").setCreativeTab(ModCreativeTab.IndEngLiquids).setIconIndex(cellIndex).setTextureFile("/com/indeng/sprites/items.png");
		items.add(itemCell);
		OreDictionary.registerOre(name + " Cell", itemCell);
		
		GameRegistry.registerItem(itemCell, name.toLowerCase() + "Cell");
		LanguageRegistry.addName(itemCell, name + " Cell");
		Item liquidItem = new Item(id).setIconIndex(index).setTextureFile("/com/indeng/sprites/textures.png").setItemName("liquid" + name);
		
		ItemStack liquidItemStack = new ItemStack(liquidItem, 1);
		
		LiquidStack liquidStack = new LiquidStack(liquidItem, LiquidContainerRegistry.BUCKET_VOLUME);
		liquidStack = LiquidDictionary.getOrCreateLiquid(name, liquidStack);
		LanguageRegistry.addName(liquidItem, name);
		liquids.add(liquidStack);
		LiquidContainerData liquidData = new LiquidContainerData(liquidStack,
                new ItemStack(itemCell, 1), ic2.api.Items.getItem("cell"));
        LiquidContainerRegistry.registerLiquid(liquidData);
        System.out.println("Created " + name);
	}
	
	public static void addLiquid(String name, int id, int index, Item itemCell) {
		itemCell.setTextureFile("/com/indeng/sprites/items.png");
		itemCell.setItemName(name.toLowerCase() + "Cell");
		itemCell.setCreativeTab(ModCreativeTab.IndEngLiquids);
		items.add(itemCell);
		GameRegistry.registerItem(itemCell, name.toLowerCase() + "Cell");
		LanguageRegistry.addName(itemCell, name + " Cell");
		Item liquidItem = new Item(id).setIconIndex(index).setTextureFile("/com/indeng/sprites/textures.png").setItemName("liquid" + name);
		ItemStack liquidItemStack = new ItemStack(liquidItem, 1);
		
		LiquidStack liquidStack = new LiquidStack(liquidItem, LiquidContainerRegistry.BUCKET_VOLUME);
		liquidStack = LiquidDictionary.getOrCreateLiquid(name, liquidStack);
		LanguageRegistry.addName(liquidItem, name);
		liquids.add(liquidStack);
		LiquidContainerData liquidData = new LiquidContainerData(liquidStack,
                new ItemStack(itemCell, 1), ic2.api.Items.getItem("cell"));
        LiquidContainerRegistry.registerLiquid(liquidData);
        System.out.println("Created " + name);
	}
}
