package com.fibonacci.advanced_unknowns.reference;

import com.fibonacci.advanced_unknowns.block.Crafting_Chest;
import com.fibonacci.advanced_unknowns.block.Diamond_Detector;
import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityDiamondDetector;
import com.fibonacci.advanced_unknowns.main.Advanced_Unknowns;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class AU_Blocks {
    public static Block diamond_detector;
    public static Block crafting_chest;
    public static void loadBlocks(){
        diamond_detector = new Diamond_Detector(Material.rock).setBlockName("DiamondDetector").setBlockTextureName("advancedunknowns:DiamondDetector").setCreativeTab(Advanced_Unknowns.tab);
        crafting_chest = new Crafting_Chest(Material.wood).setBlockName("CraftingChest").setBlockTextureName("advancedunknowns:CraftingChest").setCreativeTab(Advanced_Unknowns.tab);
    }
    public static void registerBlocks(){
        GameRegistry.registerBlock(diamond_detector, "Diamond Detector");
        GameRegistry.registerBlock(crafting_chest, "Crafting Chest");

    }
}
