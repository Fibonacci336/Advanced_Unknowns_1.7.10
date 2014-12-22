package com.fibonacci.advanced_unknowns.client;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityCraftingChest;
import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityDiamondDetector;
import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityWire;
import com.fibonacci.advanced_unknowns.block.tileentity.render.TileEntityRenderCraftingChest;
import com.fibonacci.advanced_unknowns.block.tileentity.render.TileEntityRenderDiamondDetector;
import com.fibonacci.advanced_unknowns.block.tileentity.render.TileEntityRenderWire;
import com.fibonacci.advanced_unknowns.server.CommonProxy;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class ClientProxy extends CommonProxy{
    public void RenderInformation(){
        ClientRegistry.registerTileEntity(TileEntityDiamondDetector.class, "Diamond Detector", new TileEntityRenderDiamondDetector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiamondDetector.class, new TileEntityRenderDiamondDetector());
        ClientRegistry.registerTileEntity(TileEntityCraftingChest.class, "Crafting Chest", new TileEntityRenderCraftingChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCraftingChest.class, new TileEntityRenderCraftingChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new TileEntityRenderWire());
        ClientRegistry.registerTileEntity(TileEntityWire.class, "Wire", new TileEntityRenderWire());
    }
}
