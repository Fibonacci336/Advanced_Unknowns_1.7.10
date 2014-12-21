package com.fibonacci.advanced_unknowns.client.gui;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityCraftingChest;
import com.fibonacci.advanced_unknowns.server.container.ContainerCraftingChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Fibonacci on 11/27/14.
 */
public class GUICraftingChest extends GuiContainer{
   private ResourceLocation texture;
    public GUICraftingChest(InventoryPlayer inventory, TileEntityCraftingChest te) {
        super(new ContainerCraftingChest(inventory, te));
        texture = new ResourceLocation("advancedunknowns", "textures/blocks/tileentity/gui/crafting_chest_GUI.png");
        xSize = 256;
        ySize = 241;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        this.mc.getTextureManager().bindTexture(texture);
    	int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);


    }
}
