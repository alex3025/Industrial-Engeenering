package com.indeng.keys;

import java.util.EnumSet;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;

public class RGBKeyBind extends KeyHandler {

	public RGBKeyBind(KeyBinding[] keyBindings) {
		super(keyBindings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "RGBKeys";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

}
