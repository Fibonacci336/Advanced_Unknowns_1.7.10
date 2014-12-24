package com.fibonacci.advanced_unknowns.item;

import com.fibonacci.advanced_unknowns.reference.AU_Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Fibonacci on 12/21/14.
 */
public class ExpStorage extends Item {

    public ExpStorage() {
        this.setMaxDamage(51);
        this.setMaxStackSize(1);
        this.setDamage(new ItemStack(AU_Items.expstorage), 50);

    }

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(this.getRecordNameLocal());
    }

    boolean finished = false;
    boolean tomuch = false;
    boolean noexp = false;

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

        if (!par2World.isRemote) {
            if (par1ItemStack.getItemDamage() >= 50) {
                par1ItemStack.setItemDamage(50);
                par1ItemStack.damageItem(-1, par3EntityPlayer);
                par3EntityPlayer.addExperienceLevel(-1);
                finished = true;
                if (par1ItemStack.getItemDamage() == 49) {
                    finished = false;
                }
            }
            if (par1ItemStack.getItemDamage() < 1) {
                tomuch = true;
            }
            if (par1ItemStack.getItemDamage() >= 1) {
                tomuch = false;
            }
            if (par3EntityPlayer.experienceLevel < 1) {
                noexp = true;
            }
            if (par3EntityPlayer.experienceLevel >= 1) {
                noexp = false;
            }
            if (par3EntityPlayer.isSneaking() && !finished) {
                par3EntityPlayer.addExperienceLevel(1);
                par1ItemStack.damageItem(1, par3EntityPlayer);

            } else {
                if (par1ItemStack.getItemDamage() <= 51 && !finished && !tomuch && !noexp) {
                    par3EntityPlayer.addExperienceLevel(-1);
                    par1ItemStack.damageItem(-1, par3EntityPlayer);
                }
            }

        }


        return par1ItemStack;
    }

    public void onCreated(ItemStack i, World w, EntityPlayer p) {
        i.setItemDamage(50);

    }


    public String getRecordNameLocal() {
        return StatCollector.translateToLocal("Able to store 50 levels");
    }
}