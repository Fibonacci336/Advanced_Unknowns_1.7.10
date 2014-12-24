package com.fibonacci.advanced_unknowns.item;

import com.fibonacci.advanced_unknowns.entity.throwable.EntityLaserBolt;
import com.fibonacci.advanced_unknowns.reference.AU_Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 12/22/14.
 */
public class Blaster extends Item{

    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p){
        if(p.capabilities.isCreativeMode || p.inventory.hasItem(AU_Items.blasterbullets)){
            w.playSoundAtEntity(p, "advancedunknowns:lasershot", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!w.isRemote){

                w.spawnEntityInWorld(new EntityLaserBolt(w, p));
            }
            if(!p.capabilities.isCreativeMode) {
                p.inventory.consumeInventoryItem(AU_Items.blasterbullets);
            }
        }
        return i;
    }
}
