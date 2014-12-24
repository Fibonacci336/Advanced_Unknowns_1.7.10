package com.fibonacci.advanced_unknowns.reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Fibonacci on 11/28/14.
 */
public class AU_Recipies {
    public static void loadRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(AU_Blocks.crafting_chest, 1),new Object[] {"AXA", "YZY", "YYY", 'X', Blocks.chest, 'Y', Blocks.planks, 'Z', Blocks.crafting_table, 'A', Items.redstone});
        GameRegistry.addShapedRecipe(new ItemStack(AU_Blocks.diamond_detector, 1), new Object[] {"XYX", "YXY", "XYX", 'X', Items.diamond, 'Y', Items.redstone});
        GameRegistry.addShapedRecipe(new ItemStack(AU_Items.warphome, 1), new Object[] {"XYX", "YZY", "XYX", 'X', Items.ender_pearl, 'Y', Blocks.torch, 'Z', Items.bed});
        GameRegistry.addShapedRecipe(new ItemStack(AU_Items.expstorage, 1), new Object[] {"XYX", "XZX", "XXX", 'X', Blocks.iron_bars, 'Y', Blocks.hopper, 'Z', Items.glass_bottle});
        GameRegistry.addShapedRecipe(new ItemStack(AU_Items.blaster, 1), new Object[]{"XXX", " XY", " XZ", 'X', Items.iron_ingot, 'Y', Items.redstone, 'Z', Blocks.tnt});

    }

}
