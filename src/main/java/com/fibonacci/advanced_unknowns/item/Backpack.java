package com.fibonacci.advanced_unknowns.item;

import com.fibonacci.advanced_unknowns.main.Advanced_Unknowns;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class Backpack extends Item {
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p)
    {
//        if(!w.isRemote){
//            FMLNetworkHandler.openGui(p, Advanced_Unknowns.instance, Advanced_Unknowns.guiBackpackID, w, (int)p.posX, (int)p.posY, (int)p.posZ);
//        }
        return i;
    }

}
