package com.indeng.core;

import com.indeng.block.Blocks;
import com.indeng.client.TextureLiquidsFX;
import com.indeng.common.SoundHandler;
import com.indeng.entity.Entities;
import com.indeng.entity.TileEntityTest;
import com.indeng.item.Items;
import com.indeng.liquid.Liquids;
import com.indeng.utils.LiquidUtils;

import buildcraft.api.fuels.IronEngineFuel;
import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.Ic2Recipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;

//LE COSE SI FANNO CON ORDINE, TUTTO HA UN PACCHETTO

@Mod(name="Industrial Engeenering", version="1.0-dev", modid="industrialengeenering")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, clientPacketHandlerSpec = @SidedPacketHandler (channels = {"ie"}, packetHandler = com.indeng.client.ClientPacketHandler.class), serverPacketHandlerSpec =@SidedPacketHandler(channels = {"ie"}, packetHandler = com.indeng.common.ServerPacketHandler.class))
public class Core extends BaseMod {
	@SidedProxy(clientSide = "com.industrialengeenering.client.ClientProxy", serverSide = "com.industrialengeenering.common.CommonProxy")
	public static com.indeng.common.CommonProxy proxy;

	@Instance("industrialengeenering")
	public static Core instance;

    @Override
    public String getVersion() {
        return "1.0-dev";
    }

    @Override
    public void load() {}

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit();
    }

    //La roba da registrare va messa qui
    @Init
    public void init(FMLInitializationEvent event) {
    	Blocks.initBlocks();
        Blocks.registerBlocks();
        Entities.registerEntities();
        Liquids.initLiquids();
        Items.registerItems();
        
        
        proxy.init();
    	proxy.registerRenderThings();
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		
		System.out.println("<alex3025> Yes Of Course!");
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {}
}
