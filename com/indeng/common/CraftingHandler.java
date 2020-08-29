package com.indeng.common;

import com.indeng.block.Blocks;
import com.indeng.utils.LiquidUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.Ic2Recipes;
import net.minecraft.item.ItemStack;

public class CraftingHandler {
	public static void initRecipes() {
		// IC2 Extractor: Salt Water Cell > Empty Cell
		Ic2Recipes.addExtractorRecipe(new ItemStack(LiquidUtils.items.get(0), 1, 0), new ItemStack(ic2.api.Items.getItem("cell").itemID, 1, 0));

		// Smelting: Salt Water Cell > Water Cell
		GameRegistry.addSmelting(LiquidUtils.items.get(0).itemID, new ItemStack(ic2.api.Items.getItem("waterCell").itemID, 1, 0), 0);

		// Salt Extractor
		GameRegistry.addRecipe(new ItemStack(Blocks.blockOsmo, 1),
				new Object[] { "TAT",
							   "GMG",
							   "TPT",
						'T', ic2.api.Items.getItem("tinIngot"),
						'A', ic2.api.Items.getItem("advancedCircuit"),
						'G', ic2.api.Items.getItem("rubber"),
						'M', ic2.api.Items.getItem("machine"),
						'P', ic2.api.Items.getItem("pump")});
		
		// Osmotic Generator
//		GameRegistry.addRecipe(new ItemStack(Blocks.blockOsmoGen, 1),
//				new Object[] { "TAT",
//							   "GMG",
//							   "TPT",
//						'T', ic2.api.Items.getItem("tinIngot"),
//						'A', ic2.api.Items.getItem("advancedCircuit"),
//						'G', ic2.api.Items.getItem("rubber"),
//						'M', ic2.api.Items.getItem("machine"),
//						'P', ic2.api.Items.getItem("pump")});
						 
	}
}
