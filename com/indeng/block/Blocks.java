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

    public static Block blockOsmo, blockOsmoGen, blockTest, blockDistillationIdle, blockDistillationTank, blockDistillationDiesel, blockDistillationGPL, blockPolymerization, blockBunkerCHeater, blockMiscelator, blockCatalystRegen, blockVacuumDistillation, blockVacuumDistillationDiesel, blockVacuumDistillationGPL, blockCracker, blockReformer, blockHydroCracker, blockSteamReformer;
    
    public static void initBlocks(){
    	blocks.add(blockDistillationIdle = new BlockDistillationTower(3602, 0, Material.iron, "none").setBlockName("blockDistillation")); 
    	blocks.add(blockVacuumDistillation = new BlockVacuumDistillationTower(3614, 0, Material.iron, "none").setBlockName("blockVacuumDistillation")); 
    	blocks.add(blockVacuumDistillationDiesel = new BlockVacuumDistillationTower(3615, 0, Material.iron, "fuel").setBlockName("blockVacuumDistillationDiesel")); 
    	blocks.add(blockVacuumDistillationGPL = new BlockVacuumDistillationTower(3616, 0, Material.iron, "gpl").setBlockName("blockVacuumDistillationGPL")); 
    	blocks.add(blockDistillationDiesel = new BlockDistillationTower(3604, 0, Material.iron, "fuel").setBlockName("blockDistillationDiesel")); 
    	blocks.add(blockDistillationGPL = new BlockDistillationTower(3605, 0, Material.iron, "gpl").setBlockName("blockDistillationGPL")); 
    	blocks.add(blockDistillationTank = new BlockDistillationTank(3603, 64, Material.iron).setBlockName("blockDistillationTank").setTextureFile("/com/indeng/sprites/items.png")); 
        blocks.add(blockOsmo = new BlockOsmo(3301, 0, Material.iron).setBlockName("blockOsmo"));
        blocks.add(blockOsmoGen = new BlockOsmoGen(3302, 0, Material.iron).setBlockName("blockOsmoGenIdle"));
        blocks.add(blockTest = new TestBlock(3601, 0, Material.iron).setBlockName("blockTest"));
        blocks.add(blockPolymerization = new PolymerizationUnit(3610, 65, Material.iron).setBlockName("blockPolymerization").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockBunkerCHeater = new BlockBunkerCHeater(3611, 66, Material.iron).setBlockName("blockBunkerCHeater").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockMiscelator = new BlockMiscelator(3612, 72, Material.iron).setBlockName("blockMiscelator").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockCatalystRegen = new BlockCatalystRegen(3613, 67, Material.iron).setBlockName("blockCatalystRegen").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockCracker = new BlockCracker(3617, 69, Material.iron).setBlockName("blockCracker").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockReformer = new BlockReformer(3618, 68, Material.iron).setBlockName("blockReformer").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockHydroCracker = new BlockHydroCracker(3619, 70, Material.iron).setBlockName("blockHydroCracker").setTextureFile("/com/indeng/sprites/items.png"));
        blocks.add(blockSteamReformer = new BlockSteamReformer(3620, 71, Material.iron).setBlockName("blockSteamReformer").setTextureFile("/com/indeng/sprites/items.png"));
        LanguageRegistry.addName(blockOsmo, "Salt Extractor");
        LanguageRegistry.addName(blockTest, "Test Block");
        LanguageRegistry.addName(blockOsmoGen, "Osmosis Generator");
        LanguageRegistry.addName(blockDistillationIdle, "Distillation Tower");
        LanguageRegistry.addName(blockVacuumDistillation, "Vacuum Distillation Tower");
        LanguageRegistry.addName(blockPolymerization, "Polymerization Unit");
        LanguageRegistry.addName(blockBunkerCHeater, "Bunker C Heater");
        LanguageRegistry.addName(blockMiscelator, "Gas Mixing Unit");
        LanguageRegistry.addName(blockCatalystRegen, "Catalyst Regeneration Unit");
        LanguageRegistry.addName(blockCracker, "Catalyst Cracking Unit");
        LanguageRegistry.addName(blockReformer, "Catalyst Reforming Unit");
        LanguageRegistry.addName(blockHydroCracker, "Hydrocracking Unit");
        LanguageRegistry.addName(blockSteamReformer, "Steam Reforming Unit");
    }
    
    public static void registerBlocks(){
        for (int i=0; i < blocks.size(); i++){
        	if(blocks.get(i).blockID != 3304 && blocks.get(i).blockID != 3305 && blocks.get(i).blockID != 3315 && blocks.get(i).blockID != 3316) {
        		blocks.get(i).setCreativeTab(ModCreativeTab.IndEngGeneral).setHardness(2.0F).setStepSound(Block.blockSteel.stepSound);
        	}
            GameRegistry.registerBlock(blocks.get(i), blocks.get(i).getBlockName());
        }
    }
}
