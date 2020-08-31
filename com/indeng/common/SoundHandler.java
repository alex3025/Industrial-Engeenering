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
        try
        {
            event.manager.addSound("machines/bruciatore.ogg", new File("resources/mod/sound/bruciatore.ogg"));
            event.manager.addSound("machines/bruciatorevuoto.ogg", new File("resources/mod/sound/bruciatorevuoto.ogg"));
            event.manager.addSound("machines/catalyst.ogg", new File("resources/mod/sound/catalystregen.ogg"));
            event.manager.addSound("machines/cracker.ogg", new File("resources/mod/sound/cracker.ogg"));
            event.manager.addSound("machines/reformer.ogg", new File("resources/mod/sound/reformer.ogg"));
            event.manager.addSound("machines/hydrocracker.ogg", new File("resources/mod/sound/hydrocracker.ogg"));
            event.manager.addSound("machines/steamreformer.ogg", new File("resources/mod/sound/steamreformer.ogg"));
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
