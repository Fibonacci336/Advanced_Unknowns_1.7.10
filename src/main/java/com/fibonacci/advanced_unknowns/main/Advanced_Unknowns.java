package com.fibonacci.advanced_unknowns.main;

import com.fibonacci.advanced_unknowns.client.creative.AUTab;
import com.fibonacci.advanced_unknowns.reference.AU_Blocks;
import com.fibonacci.advanced_unknowns.reference.AU_Items;
import com.fibonacci.advanced_unknowns.reference.AU_Recipies;
import com.fibonacci.advanced_unknowns.server.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;

@Mod(modid = Advanced_Unknowns.MODID, version = Advanced_Unknowns.VERSION)
public class Advanced_Unknowns
{
    @SidedProxy(clientSide = "com.fibonacci.advanced_unknowns.client.ClientProxy", serverSide = "com.fibonacci.advanced_unknowns.server.CommonProxy")
    public static CommonProxy proxy;
    public static final String MODID = "Advanced_Unknowns";
    public static final String VERSION = "Alpha 0.1";
    @Mod.Instance("Advanced_Unknowns")
    public static Advanced_Unknowns instance;
    public static int guiCraftingChestID = 0;
    public static int guiBackpackID = 1;
    public static AUTab tab;


    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        tab = new AUTab("Advanced Unknowns");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new AUguiHandler());
        AU_Blocks.loadBlocks();
        AU_Blocks.registerBlocks();
        AU_Items.loadItems();
        AU_Items.registerItems();
        AU_Recipies.loadRecipies();
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.RenderInformation();
    }
}
