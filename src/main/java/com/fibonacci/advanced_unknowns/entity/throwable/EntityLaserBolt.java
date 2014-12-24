package com.fibonacci.advanced_unknowns.entity.throwable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 12/22/14.
 */
public class EntityLaserBolt extends EntityThrowable{

    private final float speed = 3;
    private int explosionRadius = 3;

    public EntityLaserBolt(World par1World)
    {
        super(par1World);
    }
    public EntityLaserBolt(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
        
        this.motionX*=3;
        this.motionY*=3;
        this.motionZ*=3;
        
        setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3, 1.0F);

       

    }
    public EntityLaserBolt(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.10F;
    }

    @Override
    protected void onImpact(MovingObjectPosition p) {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
        this.setDead();
    }
}
