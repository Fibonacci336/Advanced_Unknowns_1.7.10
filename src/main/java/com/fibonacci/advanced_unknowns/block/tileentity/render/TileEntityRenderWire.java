package com.fibonacci.advanced_unknowns.block.tileentity.render;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityWire;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

/**
 * Created by Fibonacci on 12/21/14.
 */
public class TileEntityRenderWire extends TileEntitySpecialRenderer {
    ResourceLocation texture;
    boolean drawInside;
    float pixel;
    float texturePixel;

    public TileEntityRenderWire() {
        super();
        this.texture = new ResourceLocation("advancedunknowns", "textures/blocks/tileentity/wire.png");
        this.drawInside = true;
        this.pixel = 0.0625f;
        this.texturePixel = 0.03125f;
    }

    public void renderTileEntityAt(final TileEntity ti, final double tx, final double ty, final double tz, final float f) {
        GL11.glTranslated(tx, ty, tz);
        GL11.glDisable(2896);
        this.bindTexture(this.texture);
        final TileEntityWire wire = (TileEntityWire)ti;
        this.drawCore(ti);
        for (int i = 0; i < wire.connections.length; ++i) {
            if (wire.connections[i] != null) {
                this.drawConnection(wire.connections[i]);
            }
        }
        GL11.glEnable(2896);
        GL11.glTranslated(-tx, -ty, -tz);
    }

    public void drawConnection(final ForgeDirection d) {
        final Tessellator t = Tessellator.instance;
        t.startDrawingQuads();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        if (!d.equals((Object)ForgeDirection.UP)) {
            if (d.equals((Object)ForgeDirection.DOWN)) {
                GL11.glRotated(180.0, 1.0, 0.0, 0.0);
            }
            else if (d.equals((Object)ForgeDirection.SOUTH)) {
                GL11.glRotated(90.0, 1.0, 0.0, 0.0);
            }
            else if (d.equals((Object)ForgeDirection.NORTH)) {
                GL11.glRotated(270.0, 1.0, 0.0, 0.0);
            }
            else if (d.equals((Object)ForgeDirection.WEST)) {
                GL11.glRotated(90.0, 0.0, 0.0, 1.0);
            }
            else if (d.equals((Object)ForgeDirection.EAST)) {
                GL11.glRotated(270.0, 0.0, 0.0, 1.0);
            }
        }
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        if (this.drawInside) {
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), 1.0, (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (10.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        }
        t.draw();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        if (!d.equals((Object)ForgeDirection.UP)) {
            if (d.equals((Object)ForgeDirection.DOWN)) {
                GL11.glRotated(-180.0, 1.0, 0.0, 0.0);
            }
            else if (d.equals((Object)ForgeDirection.SOUTH)) {
                GL11.glRotated(-90.0, 1.0, 0.0, 0.0);
            }
            else if (d.equals((Object)ForgeDirection.NORTH)) {
                GL11.glRotated(-270.0, 1.0, 0.0, 0.0);
            }
            else if (d.equals((Object)ForgeDirection.WEST)) {
                GL11.glRotated(-90.0, 0.0, 0.0, 1.0);
            }
            else if (d.equals((Object) ForgeDirection.EAST)) {
                GL11.glRotated(-270.0, 0.0, 0.0, 1.0);
            }
        }
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
    }

    public void drawCore(final TileEntity ti) {
        final Tessellator t = Tessellator.instance;
        t.startDrawingQuads();
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
        t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        if (this.drawInside) {
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
            t.addVertexWithUV((double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (0.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (0.0f * this.texturePixel));
            t.addVertexWithUV((double) (11.0f * this.pixel / 2.0f), (double) (11.0f * this.pixel / 2.0f), (double) (1.0f - 11.0f * this.pixel / 2.0f), (double) (5.0f * this.texturePixel), (double) (5.0f * this.texturePixel));
        }
        t.draw();
    }
}


