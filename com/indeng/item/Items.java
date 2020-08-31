package com.indeng.item;

import java.util.ArrayList;
import java.util.List;

import com.indeng.core.ModCreativeTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;

public class Items {
	
	 public static List<Item> items = new ArrayList<Item>();
	 
	 public static Item catA, catB, catC, catD, jar;
	 
	public static void initItems() {
		items.add(catA = new ItemCatalizer(3701, 0).setItemName("catA"));
		items.add(catB = new ItemCatalizer(3702, 1).setItemName("catB"));
		items.add(catC = new ItemCatalizer(3703, 2).setItemName("catC"));
		items.add(catD = new ItemCatalizer(3704, 3).setItemName("catD"));
		items.add(jar = new Item(3705).setItemName("jar").setIconIndex(80));
		LanguageRegistry.addName(catA, "Catalizer A");
		LanguageRegistry.addName(catB, "Catalizer B");
		LanguageRegistry.addName(catC, "Catalizer C");
		LanguageRegistry.addName(catD, "Catalizer D");
		LanguageRegistry.addName(jar, "Empty Jar");
	}
	
	
	public static void registerItems(){
        for (int i=0; i < items.size(); i++){
        	
        	items.get(i).setCreativeTab(ModCreativeTab.IndEngGeneral).setTextureFile("/com/indeng/sprites/items.png");
        	
            GameRegistry.registerItem(items.get(i), items.get(i).getItemName());
        }
    }
	
}
