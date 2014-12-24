package com.fibonacci.advanced_unknowns.reference;

import com.fibonacci.advanced_unknowns.main.world.AUWorldGen;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Fibonacci on 12/23/14.
 */
public class AU_Generators {
    public static AUWorldGen worldgen;

    public static void loadGenerators(){
        worldgen = new AUWorldGen();
    }

    public static void registerGenerators(){
        GameRegistry.registerWorldGenerator(worldgen, 1);

    }
}
