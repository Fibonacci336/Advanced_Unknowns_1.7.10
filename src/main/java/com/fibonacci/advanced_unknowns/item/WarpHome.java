package com.fibonacci.advanced_unknowns.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 12/20/14.
 */
public class WarpHome extends Item{
    ChunkCoordinates spawn;

    public WarpHome(){
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(100);
    }

    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p)
    {
        if(!w.isRemote){
            this.spawn = p.getBedLocation(p.dimension);
            Object cords = null;
            if(this.spawn == cords){
                p.addChatComponentMessage(new ChatComponentTranslation("Spawn not found!", new Object[0]));
            }
            if(spawn != cords){
                EntityPlayerMP e = (EntityPlayerMP)p;
                e.setPositionAndUpdate(spawn.posX, spawn.posY, spawn.posZ);
                e.addPotionEffect(new PotionEffect(Potion.resistance.id, 150, 100));
                i.damageItem(1, p);
            }
        }
        return i;
    }
}
