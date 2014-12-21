package com.fibonacci.advanced_unknowns.reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by Fibonacci on 11/28/14.
 */
public class AU_Recipies {
    public static void loadRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(AU_Blocks.crafting_chest, 1),new Object[] {"XXX", "XXX", "XXX", 'X', Blocks.dirt});
    }

}
