package com.industrialengeenering.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.world.World;

public class EntityLoco extends CartBase{

	
	boolean reverse = false;
	float speed = 0;
	boolean isRunning = true;
	
	
	public void onUpdate() {
		
		super.onUpdate();
		if(this.isRunning) {
			if(this.motionX == 0) {
				this.motionX = 1;
			}
			if(this.motionZ == 0) {
				this.motionZ = 1;
			}
			this.motionX *= 0.20000000298023224D;
	        this.motionZ *= 0.20000000298023224D;
	        this.addVelocity(this.motionX, 0.0D, this.motionZ);
		} else {
			this.motionZ = 0;
			this.motionX = 0;
		}
	}
	
	@Override
	protected void moveMinecartOnRail(int i, int j, int k)
    {
        int id = worldObj.getBlockId(i, j, k);
        if (!BlockRail.isRailBlock(id))
        {
                return;
        }
        float railMaxSpeed = ((BlockRail)Block.blocksList[id]).getRailMaxSpeed(worldObj, this, i, j, k);

        double maxSpeed = Math.min(railMaxSpeed, getMaxSpeedRail());
        double mX = motionX;
        double mZ = motionZ;
        mX *= 0.75D;
        mZ *= 0.75D;
        if(mX < -maxSpeed) mX = -maxSpeed;
        if(mX >  maxSpeed) mX =  maxSpeed;
        if(mZ < -maxSpeed) mZ = -maxSpeed;
        if(mZ >  maxSpeed) mZ =  maxSpeed;
        moveEntity(mX, 0.0D, mZ);
    }
	
	public void setSpeed(float s) {
		this.speed = s;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public float getMaxReverseSpeed() {
		return 10f;
	}
	
	public EntityLoco(World par1World) {
		super(par1World);
		this.minecartType = 2;
	}
	
	public EntityLoco(World par1World, double par2, double par4, double par6, int par8) {
		super(par1World, par2, par4, par6, par8);
		this.minecartType = 2;
		this.isRunning = false;
	}

	public void reverse() {
		this.reverse = !this.reverse;
		rotationYaw += 180;
        motionX = -motionX;
        motionZ = -motionZ;
    }
	
	@Override
	protected double getDrag()
    {
        if(isRunning) {
        	return 10D;
        }
        return 0;
    }
	
	protected void applyDrag() {
        motionX *= getDrag();
        motionY *= 0.0D;
        motionZ *= getDrag();

        if (reverse && getSpeed() > getMaxReverseSpeed()) {
            setSpeed(getMaxReverseSpeed());
        }
        
        if (isRunning) {
        	motionX *= getDrag() * 10;
            motionY *= 0.0D;
            motionZ *= getDrag() * 10;
            float force = 10f * 0.01F;
            double yaw = rotationYaw * Math.PI / 180D;
            motionX += Math.cos(yaw) * force;
            motionZ += Math.sin(yaw) * force;
        }
    }
}
