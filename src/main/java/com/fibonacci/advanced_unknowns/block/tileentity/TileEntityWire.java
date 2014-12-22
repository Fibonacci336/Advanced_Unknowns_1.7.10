package com.fibonacci.advanced_unknowns.block.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import resonant.api.tile.node.IEnergyNode;

/**
 * Created by Fibonacci on 12/21/14.
 */
public class TileEntityWire extends TileEntity {
    public ForgeDirection[] connections;

    public TileEntityWire() {
        super();
        this.connections = new ForgeDirection[6];
    }

    public void updateEntity(){
        updateConnections();
    }

    public void updateConnections() {
        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord) instanceof IEnergyNode) {
            this.connections[0] = ForgeDirection.UP;
        }
        else {
            this.connections[0] = null;
        }
        if (this.connections[0] == null) {
            if (this.worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord) instanceof TileEntityWire) {
                this.connections[0] = ForgeDirection.UP;
            }
            else {
                this.connections[0] = null;
            }
        }

        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord - 1, this.zCoord) instanceof IEnergyNode) {
            this.connections[1] = ForgeDirection.DOWN;
        }
        else {
            this.connections[1] = null;
        }

                    if (this.connections[1] == null) {
                        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord - 1, this.zCoord) instanceof TileEntityWire) {
                            this.connections[1] = ForgeDirection.DOWN;
                        }
                        else {
                            this.connections[1] = null;
                        }
                    }
                
        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - 1) instanceof IEnergyNode) {
            this.connections[2] = ForgeDirection.NORTH;
        }
        else {
            this.connections[2] = null;
        }

                    if (this.connections[2] == null) {
                        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - 1) instanceof TileEntityWire) {
                            this.connections[2] = ForgeDirection.NORTH;
                        }
                        else {
                            this.connections[2] = null;
                        }
                    }

        if (this.worldObj.getTileEntity(this.xCoord + 1, this.yCoord, this.zCoord) instanceof IEnergyNode) {
            this.connections[3] = ForgeDirection.EAST;
        }
        else {
            this.connections[3] = null;
        }

                    if (this.connections[3] == null) {
                        if (this.worldObj.getTileEntity(this.xCoord + 1, this.yCoord, this.zCoord) instanceof TileEntityWire) {
                            this.connections[3] = ForgeDirection.EAST;
                        }
                        else {
                            this.connections[3] = null;
                        }
                    }

        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + 1) instanceof IEnergyNode) {
            this.connections[4] = ForgeDirection.SOUTH;
        }
        else {
            this.connections[4] = null;
        }
                    if (this.connections[4] == null) {
                        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + 1) instanceof TileEntityWire) {
                            this.connections[4] = ForgeDirection.SOUTH;
                        }
                        else {
                            this.connections[4] = null;
                        }
                    }



        if (this.worldObj.getTileEntity(this.xCoord - 1, this.yCoord, this.zCoord) instanceof IEnergyNode) {
            this.connections[5] = ForgeDirection.WEST;
        }
        else {
            this.connections[5] = null;
        }
        if (this.connections[5] == null) {
            if (this.worldObj.getTileEntity(this.xCoord - 1, this.yCoord, this.zCoord) instanceof TileEntityWire) {
                this.connections[5] = ForgeDirection.WEST;
            }
            else {
                this.connections[5] = null;
                        }
                    }
                }



    public boolean oneopisite(final ForgeDirection[] directions) {
        ForgeDirection mainDirection = null;
        boolean isOppisite = false;
        for (int i = 0; i < directions.length; ++i) {
            if (mainDirection == null && directions[i] != null) {
                mainDirection = directions[i];
            }
            if (directions[i] != null && mainDirection != directions[i]) {
                if (!this.isOppisite(mainDirection, directions[i])) {
                    return false;
                }
                isOppisite = true;
            }
        }
        return isOppisite;
    }

    public boolean isOppisite(final ForgeDirection fd, final ForgeDirection sd) {
        return (fd.equals((Object)ForgeDirection.NORTH) && sd.equals((Object)ForgeDirection.SOUTH)) || (fd.equals((Object)ForgeDirection.SOUTH) && sd.equals((Object)ForgeDirection.NORTH)) || ((fd.equals((Object)ForgeDirection.EAST) && sd.equals((Object)ForgeDirection.WEST)) || (fd.equals((Object)ForgeDirection.WEST) && sd.equals((Object)ForgeDirection.EAST))) || ((fd.equals((Object)ForgeDirection.UP) && sd.equals((Object)ForgeDirection.DOWN)) || (fd.equals((Object)ForgeDirection.DOWN) && sd.equals((Object)ForgeDirection.UP)));
    }
}
