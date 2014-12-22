package com.fibonacci.advanced_unknowns.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 12/21/14.
 */
public class ExpStorage extends Item {


    private boolean finished;
    private boolean tomuch;
    private boolean noexp;

    public ExpStorage(){
        super();
        this.setMaxDamage(50);
        this.setMaxStackSize(1);
        finished = false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p) {
        if(!w.isRemote){
            if(i.getItemDamage() >= 50){
                i.setItemDamage(50);
                i.damageItem(-1, p);
                p.addExperienceLevel(-1);
                this.finished = true;
                if(i.getItemDamage() == 49){
                    this.finished = false;
                }
            }
            if(i.getItemDamage() < 1){
                this.tomuch = true;
            }
            if(i.getItemDamage() >= 1){
                this.tomuch = false;
            }
            if(p.experienceLevel < 1){
                this.noexp = true;
            }
            if(p.experienceLevel >= 1){
                this.noexp = false;
            }
            if(p.isSneaking() && !this.finished){
                p.addExperienceLevel(1);
                i.damageItem(1, p);
            }else if(i.getItemDamage() <= 51 && !finished && !tomuch && !noexp){
                p.addExperienceLevel(-1);
                i.damageItem(-1, p);
            }
        }
        return i;
    }
    public String getInformation() {
        return StatCollector.translateToLocal("Able to store 50 levels");
    }
}
