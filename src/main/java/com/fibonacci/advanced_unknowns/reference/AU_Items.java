package com.fibonacci.advanced_unknowns.reference;

import com.fibonacci.advanced_unknowns.item.Backpack;
import com.fibonacci.advanced_unknowns.item.WarpHome;
import com.fibonacci.advanced_unknowns.main.Advanced_Unknowns;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class AU_Items {
    public static Item backpack;
    public static Item warphome;

    public static void loadItems(){
        backpack = new Backpack().setCreativeTab(Advanced_Unknowns.tab).setUnlocalizedName("Backpack").setTextureName("advancedunknowns:backpack");
        warphome = new WarpHome().setCreativeTab(Advanced_Unknowns.tab).setUnlocalizedName("WarpHome").setTextureName("advancedunknowns:warphome");
    }
    public static void registerItems(){
        GameRegistry.registerItem(backpack, "Backpack");
        GameRegistry.registerItem(warphome, "WarpHome");
    }

}
