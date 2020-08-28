package com.indeng.common;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.indeng.core.Core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

@SideOnly(Side.CLIENT)
public class SoundHandler {
	
	@ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
		System.out.println("[RGB] Loading Sound for RGBMod");
        try
        {
        	System.out.println(Core.class.getResource("/com/industrialengeenering/sprites/blocks.png"));
            event.manager.addSound("machines/osmo.ogg", new File("resources/mod/sound/osmo.ogg"));
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
