package com.fibonacci.advanced_unknowns.block.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class TileEntityDiamondDetector extends TileEntity {
    public int rotation;
    public double rotation1;
    public double rotation2;
    public int orefound;
    private int ticks;
    private boolean hasorebeenfound = false;

    public void updateEntity() {
        ++ticks;
        ++rotation1;

if(ticks < 20) {
    for (int y1 = 0; y1 < 256; ++y1) {
        for (int x1 = 0; x1 < 3; ++x1) {
            for (int z1 = 0; z1 < 3; ++z1) {
                for (int x2 = 0; x2 < 3; ++x2) {
                    for (int z2 = 0; z2 < 3; ++z2) {
                        if (this.worldObj.getBlock(this.xCoord + x1 - x2, y1, this.zCoord + z1 - z2).equals(Blocks.diamond_ore)) {
                            ++this.orefound;

                        }
                    }
                }
            }

        }
    }
}
        this.rotation = (orefound)*(int)rotation1;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        nbt.getInteger("orefound");
    }
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("orefound", orefound);
    }
}


