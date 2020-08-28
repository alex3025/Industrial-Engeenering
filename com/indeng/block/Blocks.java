package com.indeng.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

import com.indeng.core.Core;
import com.indeng.core.ModCreativeTab;

public class Blocks {

    public static List<Block> blocks = new ArrayList<Block>();

    public static Block blockOsmo, blockOsmoGen, blockTest, blockDistillationIdle, blockDistillationDiesel, blockDistillationGPL, blockDistillationTank;

    public static void initBlocks(){
    	blocks.add(blockDistillationIdle = new BlockDistillationTower(3302, 0, Material.iron, "none").setBlockName("blockDistillation")); 
    	blocks.add(blockDistillationDiesel = new BlockDistillationTower(3304, 0, Material.iron, "fuel").setBlockName("blockDistillationDiesel")); 
    	blocks.add(blockDistillationGPL = new BlockDistillationTower(3305, 0, Material.iron, "gpl").setBlockName("blockDistillationGPL")); 
    	blocks.add(blockDistillationTank = new BlockDistillationTank(3303, 0, Material.iron).setBlockName("blockDistillationTank")); 
        blocks.add(blockOsmo = new BlockOsmo(3404, 0, Material.iron).setBlockName("blockOsmo"));
        blocks.add(blockOsmoGen = new BlockOsmoGen(3405, 0, Material.iron).setBlockName("blockOsmoGenIdle"));
        blocks.add(blockTest = new TestBlock(3301, 0, Material.iron).setBlockName("blockTest"));
        LanguageRegistry.addName(blockOsmo, "Salt Extractor");
        LanguageRegistry.addName(blockTest, "Test Block");
        LanguageRegistry.addName(blockOsmoGen, "Osmosis Generator");
        LanguageRegistry.addName(blockDistillationIdle, "Distillation Tower");
    }

    public static void registerBlocks(){
        for (int i=0; i < blocks.size(); i++){
        	if(blocks.get(i).blockID != 3304 && blocks.get(i).blockID != 3305) {
        		blocks.get(i).setCreativeTab(ModCreativeTab.IndEngBlocks).setHardness(2.0F).setStepSound(Block.blockSteel.stepSound);
        	}
            GameRegistry.registerBlock(blocks.get(i), blocks.get(i).getBlockName());
        }
    }
}
