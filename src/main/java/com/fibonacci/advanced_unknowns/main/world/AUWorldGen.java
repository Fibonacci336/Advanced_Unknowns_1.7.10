package com.fibonacci.advanced_unknowns.main.world;

import com.fibonacci.advanced_unknowns.main.world.features.StoneTemple;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

/**
 * Created by Fibonacci on 12/23/14.
 */
public class AUWorldGen implements IWorldGenerator{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId){
            case 0 : generateSurface(world, random, chunkX*16, chunkZ*16);
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        for(int i = 0; i < 2; i++){
            int Xcoords = x + random.nextInt(16);
            int Ycoords = random.nextInt(256)+2;
            int Zcoords = z + random.nextInt(16);
            new StoneTemple().generate(world, random, Xcoords, Ycoords, Zcoords);


        }
    }
}
