package com.indeng.common;

import com.indeng.block.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class CraftingHandler {
	public static void initRecipes() {
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
