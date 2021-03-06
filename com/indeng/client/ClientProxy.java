package com.indeng.client;

import java.util.List;

import com.indeng.block.Blocks;
import com.indeng.common.CommonProxy;
import com.indeng.common.SoundHandler;
import com.indeng.entity.OsmoGeneratorEnergy;
import com.indeng.entity.TileEntityBunkerCHeater;
import com.indeng.entity.TileEntityCatalystRegen;
import com.indeng.entity.TileEntityCracker;
import com.indeng.entity.TileEntityDistillationTank;
import com.indeng.entity.TileEntityHydroCracker;
import com.indeng.entity.TileEntityMiscelator;
import com.indeng.entity.TileEntityPolymerizationUnit;
import com.indeng.entity.TileEntityReformer;
import com.indeng.entity.TileEntitySteamReformer;
import com.indeng.entity.TileEntityTest;
import com.indeng.guis.GuiCatalystRegen;
import com.indeng.guis.GuiCracker;
import com.indeng.guis.GuiReformer;
import com.indeng.models.RenderTableBunkerCHeater;
import com.indeng.models.RenderTableCatalystRegen;
import com.indeng.models.RenderTableCatalyticCracker;
import com.indeng.models.RenderTableCatalyticReformer;
import com.indeng.models.RenderTableDistillationTank;
import com.indeng.models.RenderTableGasMixingUnit;
import com.indeng.models.RenderTableHydroCracker;
import com.indeng.models.RenderTablePolymerizationUnit;
import com.indeng.models.RenderTableSteamReformer;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture("/com/indeng/sprites/textures.png");
		MinecraftForgeClient.preloadTexture("/com/indeng/sprites/blocks.png");
		MinecraftForgeClient.preloadTexture("/com/indeng/sprites/items.png");
		MinecraftForgeClient.preloadTexture("/com/indeng/sprites/torredist.png");
		System.out.println("Loading client liquids");
        
        final int distillationTankRenderID = RenderingRegistry.getNextAvailableRenderId();
        //Blocks.blockDistillationTank.setRenderType(distillationTankRenderID);
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDistillationTank.class, new RenderTableDistillationTank(distillationTankRenderID));
        
		

		//Salt Water
		TextureLiquidsFX liquidFX = new TextureLiquidsFX(4, 2, 188, 249, 249, 249, 0,
                "/com/indeng/sprites/textures.png");
        liquidFX.tileImage = 3595;
        TextureFXManager.instance().addAnimation(liquidFX);

        //GPL
        TextureLiquidsFX liquidGPLFX = new TextureLiquidsFX(0, 0, 0, 0, 255, 255, 1,
                "/com/indeng/sprites/textures.png");
        liquidGPLFX.tileImage = 3595;
        TextureFXManager.instance().addAnimation(liquidGPLFX);

        //Gasoline
        TextureLiquidsFX gasolineFX = new TextureLiquidsFX(0, 0, 133, 179, 128, 172, 2,
                "/com/indeng/sprites/textures.png");
        gasolineFX.tileImage = 3595;
        TextureFXManager.instance().addAnimation(gasolineFX);
        
        //Naphtha
        TextureLiquidsFX naphthaFX = new TextureLiquidsFX(194, 255, 0, 0, 0, 0, 3,
                "/com/indeng/sprites/textures.png");
        naphthaFX.tileImage = 3595;
        TextureFXManager.instance().addAnimation(naphthaFX);
        
        //HFO
	    TextureLiquidsFX hfoFX = new TextureLiquidsFX(54, 94, 14, 23, 14, 23, 4,
	            "/com/indeng/sprites/textures.png");
	    hfoFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(hfoFX);
	    
	    //Crude residues
	    TextureLiquidsFX crudeFX = new TextureLiquidsFX(46, 163, 45, 162, 45, 162, 5,
	            "/com/indeng/sprites/textures.png");
	    crudeFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(crudeFX);
	    
	    //BunkerC
	    TextureLiquidsFX bunkerFX = new TextureLiquidsFX(0, 41, 0, 41, 0, 41, 6,
	            "/com/indeng/sprites/textures.png");
	    bunkerFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(bunkerFX);
	    
	    //Heated BunkerC
	    TextureLiquidsFX hbunkerFX = new TextureLiquidsFX(0, 77, 0, 77, 0, 77, 7,
	            "/com/indeng/sprites/textures.png");
	    hbunkerFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(hbunkerFX);
	    
	    //CO
	    TextureLiquidsFX coFX = new TextureLiquidsFX(99, 99, 88, 88, 88, 88, 8,
	            "/com/indeng/sprites/textures.png");
	    coFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(coFX);
	    
	    //Town GAS
	    TextureLiquidsFX townFX = new TextureLiquidsFX(184, 184, 181, 181, 127, 127, 9,
	            "/com/indeng/sprites/textures.png");
	    townFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(townFX); 
	    
	    //Lubricant
	    TextureLiquidsFX lubricantFX = new TextureLiquidsFX(212, 242, 90, 104, 36, 56, 12,
	            "/com/indeng/sprites/textures.png");
	    lubricantFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(lubricantFX);
	    
	    //Asphalt
	    TextureLiquidsFX asphaltFX = new TextureLiquidsFX(74, 97, 74, 97, 74, 97, 10,
	            "/com/indeng/sprites/textures.png");
	    asphaltFX.tileImage = 3595;
	    TextureFXManager.instance().addAnimation(asphaltFX);
		
	}
	
	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int X, int Y, int Z) {
		TileEntity te=world.getBlockTileEntity(X, Y, Z);
		if (te!=null && te instanceof TileEntityCatalystRegen) {
			TileEntityCatalystRegen temg = (TileEntityCatalystRegen) te;
			return new GuiCatalystRegen(player.inventory, temg);
		} else if (te!=null && te instanceof TileEntityCracker) {
			TileEntityCracker temg = (TileEntityCracker) te;
			return new GuiCracker(player.inventory, temg);
		} else if (te!=null && te instanceof TileEntityReformer) {
			TileEntityReformer temg = (TileEntityReformer) te;
			return new GuiReformer(player.inventory, temg);
		} else {
			return null;
		}
	}

	@Override
	public void init() {
		super.init();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDistillationTank.class, new RenderTableDistillationTank());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPolymerizationUnit.class, new RenderTablePolymerizationUnit());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBunkerCHeater.class, new RenderTableBunkerCHeater());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiscelator.class, new RenderTableGasMixingUnit());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCatalystRegen.class, new RenderTableCatalystRegen());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCracker.class, new RenderTableCatalyticCracker());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReformer.class, new RenderTableCatalyticReformer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHydroCracker.class, new RenderTableHydroCracker());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamReformer.class, new RenderTableSteamReformer());
	}
	
}
