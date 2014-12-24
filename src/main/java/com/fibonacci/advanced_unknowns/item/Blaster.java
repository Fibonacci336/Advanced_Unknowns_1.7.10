package com.fibonacci.advanced_unknowns.item;

import com.fibonacci.advanced_unknowns.entity.throwable.EntityLaserBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 12/22/14.
 */
public class Blaster extends Item{
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p){
        if(p.capabilities.isCreativeMode || p.inventory.hasItem(Items.redstone)){
            w.playSoundAtEntity(p, "advancedunknowns:lasershot", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!w.isRemote){
                p.inventory.consumeInventoryItem(Items.redstone);
                w.spawnEntityInWorld(new EntityLaserBolt(w, p));
            }

        }
        return i;
    }
}
