package com.fibonacci.advanced_unknowns.server.container;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityCraftingChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 11/27/14.
 */
public class ContainerCraftingChest extends Container{
private int numRows;
public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
public IInventory craftResult = new InventoryCraftResult();
private World worldObj;

    public ContainerCraftingChest(InventoryPlayer p, TileEntityCraftingChest te){
    	
        super();
        numRows = 6;
        int x = (this.numRows - 4) * 18;
        int y;
        int z;
        this.addSlotToContainer(new SlotCrafting(p.player, this.craftMatrix, this.craftResult, 0, 205, 124));

        for (int l = 0; l < 3; ++l)
        {
            for (int i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 186 + i1 * 18, 30 + l * 18));
            }
        }
        for (y = 0; y < this.numRows; ++y)
        {
            for (z = 0; z < 9; ++z)
            {
                this.addSlotToContainer(new Slot(te, z + y * 9, 8 + z * 18, 18 + y * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer((new Slot(p, i, 8 + i * 18, 198)));
           
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(p, 9 + j + i * 9, 8 + 18 * j, 140 + i * 18));
            }
        }
    }
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);


            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }

    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
    public void onCraftMatrixChanged(IInventory p_75130_1_)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
//    public void onContainerClosed(EntityPlayer p_75134_1_)
//    {
//        super.onContainerClosed(p_75134_1_);
//
//        if (!this.worldObj.isRemote)
//        {
//            for (int i = 0; i < 9; ++i)
//            {
//                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
//
//                if (itemstack != null)
//                {
//                    p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
//                }
//            }
//        }
//    }
}
