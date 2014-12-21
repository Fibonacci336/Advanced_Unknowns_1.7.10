package com.fibonacci.advanced_unknowns.main;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityCraftingChest;
import com.fibonacci.advanced_unknowns.client.gui.GUICraftingChest;
import com.fibonacci.advanced_unknowns.server.container.ContainerCraftingChest;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

//import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityBackpack;

/**
 * Created by Fibonacci on 11/27/14.
 */
public class AUguiHandler implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID){
            case 0: {
                return new ContainerCraftingChest(player.inventory, (TileEntityCraftingChest)te);
            }
//            case 1: {
//                return new ContainerBackpack(player.inventory, (InventoryBackpack)te);
//            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID){
            case 0: {
                return new GUICraftingChest(player.inventory, (TileEntityCraftingChest)te);
            }
//            case 1: {
//                return new GUIBackpack(player.inventory, (InventoryBackpack)te);
//            }
        }
        return null;
    }
}
