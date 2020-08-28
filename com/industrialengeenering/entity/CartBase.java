package com.industrialengeenering.entity;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

public class CartBase extends EntityMinecart {

	
	
	
	protected CartBase(World world) {
        super(world);
    }
	
	public CartBase(World par1World, double par2, double par4, double par6, int par8) {
		super(par1World, par2, par4, par6, par8);
	}
	
	@Override
    public boolean isPoweredCart() {
        return false;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
    
    
	
}
