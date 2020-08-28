package com.industrialengeenering.utils;

import net.minecraft.world.World;

public class Game {
	
	public static boolean isHost(World world) {
        return !world.isRemote;
    }

    public static boolean isNotHost(World world) {
        return world.isRemote;
    }
}
