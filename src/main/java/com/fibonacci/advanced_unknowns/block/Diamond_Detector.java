package com.fibonacci.advanced_unknowns.block;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityDiamondDetector;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class Diamond_Detector extends BlockContainer{
    public Diamond_Detector(Material m) {
        super(m);
        this.setBlockBounds(.45F, 0, .45F, .65F, 0.7F, .65F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDiamondDetector();
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean renderAsNormalBlock()
    {
        return false;

    }
    public int getRenderType()
    {
        return -1;
    }

    public String getItemIconName()
    {
        return "advancedunknowns:diamonddetector";
    }

    public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
        if(w.getBlock(x, y-1, z).equals(Blocks.air)){
        	Block block = w.getBlock(x, y, z);
            block.dropBlockAsItem(w, x, y+1, z, w.getBlockMetadata(x, y, z), 0);
            w.setBlockToAir(x, y, z);
            w.removeTileEntity(x, y, z);


        }
    }
}
