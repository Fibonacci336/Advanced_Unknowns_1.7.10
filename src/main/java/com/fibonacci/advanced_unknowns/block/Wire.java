package com.fibonacci.advanced_unknowns.block;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityWire;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * Created by Fibonacci on 12/21/14.
 */
public class Wire extends BlockContainer{
    public Wire(Material m) {
        super(m);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityWire();
    }
    public int getRenderType() {
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool( World w,  int x,  int y,  int z) {
         TileEntityWire p = (TileEntityWire)w.getTileEntity(x, y, z);
        if (p != null) {
             float pixel = 0.0625f;
             float minZ = 11.0f * pixel / 2.0f - ((p.connections[2] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float minX = 11.0f * pixel / 2.0f - ((p.connections[5] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float minY = 11.0f * pixel / 2.0f - ((p.connections[1] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float maxZ = 1.0f - 11.0f * pixel / 2.0f + ((p.connections[4] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float maxX = 1.0f - 11.0f * pixel / 2.0f + ((p.connections[3] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float maxY = 1.0f - 11.0f * pixel / 2.0f + ((p.connections[0] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool( World w,  int x,  int y,  int z) {
        TileEntityWire p = (TileEntityWire)w.getTileEntity(x, y, z);
        if (p != null) {
             float pixel = 0.0625f;
             float minZ = 11.0f * pixel / 2.0f - ((p.connections[2] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float minX = 11.0f * pixel / 2.0f - ((p.connections[5] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float minY = 11.0f * pixel / 2.0f - ((p.connections[1] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float maxZ = 1.0f - 11.0f * pixel / 2.0f + ((p.connections[4] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float maxX = 1.0f - 11.0f * pixel / 2.0f + ((p.connections[3] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
             float maxY = 1.0f - 11.0f * pixel / 2.0f + ((p.connections[0] != null) ? (11.0f * pixel / 2.0f) : 0.0f);
            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
    }
    public String getItemIconName()
    {
        return "advancedunknowns:wire";
    }
}
