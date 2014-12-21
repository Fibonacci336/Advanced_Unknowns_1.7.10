package com.fibonacci.advanced_unknowns.block.tileentity.render;

import com.fibonacci.advanced_unknowns.block.tileentity.TileEntityDiamondDetector;
import com.fibonacci.advanced_unknowns.main.Advanced_Unknowns;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Fibonacci on 11/25/14.
 */
public class TileEntityRenderDiamondDetector extends TileEntitySpecialRenderer {
    private final ResourceLocation textureBullBlock;
    private int twidth;
    private int theight;

    public TileEntityRenderDiamondDetector() {
        super();
        this.textureBullBlock = new ResourceLocation("advancedunknowns", "textures/blocks/tileentity/diamond_detector.png");
        this.twidth = 64;
        this.theight = 64;
    }

    public void renderTileEntityAt(TileEntity te, final double dx, double dy,double dz,  float f) {

         int x1 = te.xCoord;
         int y1 = te.yCoord;
         int z1 = te.zCoord;
         TileEntityDiamondDetector randomblock = (TileEntityDiamondDetector)te;
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslated(dx, dy, dz);
         Tessellator t = Tessellator.instance;
        this.bindTexture(this.textureBullBlock);
        t.startDrawingQuads();

        t.addVertexWithUV(0.65, 0.0, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.0, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.0, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.0, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.7, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.7, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.7, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.7, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.0, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.7, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.7, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.0, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.0, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.7, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.7, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.0, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.0, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.7, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.7, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.65, 0.0, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.0, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.7, 0.65, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.7, 0.45, 0.0, 0.0);
        t.addVertexWithUV(0.45, 0.0, 0.45, 0.0, 0.0);
        t.draw();
        this.drawcube(te);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

    }

    public void drawcube( TileEntity te) {
        TileEntityDiamondDetector randomblock = (TileEntityDiamondDetector)te;
         Tessellator t = Tessellator.instance;
        this.bindTexture(this.textureBullBlock);
        t.startDrawingQuads();
        if (randomblock.orefound >= 1) {
            GL11.glTranslated(0.55, 0.0, 0.55);
            GL11.glRotated(randomblock.rotation, 0.0, 1.0, 0.0);
            GL11.glTranslated(-0.55, 0.0, -0.55);
        }
        t.addVertexWithUV(0.65, 1.0, 0.65, 0.921875, 0.078125);
        t.addVertexWithUV(0.65, 1.0, 0.45, 1.0, 0.078125);
        t.addVertexWithUV(0.45, 1.0, 0.45, 1.0, 0.0);
        t.addVertexWithUV(0.45, 1.0, 0.65, 0.921875, 0.0);
        t.addVertexWithUV(0.45, 0.8, 0.65, 0.921875, 0.078125);
        t.addVertexWithUV(0.45, 0.8, 0.45, 1.0, 0.078125);
        t.addVertexWithUV(0.65, 0.8, 0.45, 1.0, 0.0);
        t.addVertexWithUV(0.65, 0.8, 0.65, 0.921875, 0.0);
        t.addVertexWithUV(0.65, 0.8, 0.65, 0.921875, 0.078125);
        t.addVertexWithUV(0.65, 1.0, 0.65, 1.0, 0.078125);
        t.addVertexWithUV(0.45, 1.0, 0.65, 1.0, 0.0);
        t.addVertexWithUV(0.45, 0.8, 0.65, 0.921875, 0.0);
        t.addVertexWithUV(0.45, 0.8, 0.45, 0.921875, 0.078125);
        t.addVertexWithUV(0.45, 1.0, 0.45, 1.0, 0.078125);
        t.addVertexWithUV(0.65, 1.0, 0.45, 1.0, 0.0);
        t.addVertexWithUV(0.65, 0.8, 0.45, 0.921875, 0.0);
        t.addVertexWithUV(0.45, 0.8, 0.65, 0.921875, 0.078125);
        t.addVertexWithUV(0.45, 1.0, 0.65, 1.0, 0.078125);
        t.addVertexWithUV(0.45, 1.0, 0.45, 1.0, 0.0);
        t.addVertexWithUV(0.45, 0.8, 0.45, 0.921875, 0.0);
        t.addVertexWithUV(0.65, 0.8, 0.45, 0.921875, 0.078125);
        t.addVertexWithUV(0.65, 1.0, 0.45, 1.0, 0.078125);
        t.addVertexWithUV(0.65, 1.0, 0.65, 1.0, 0.0);
        t.addVertexWithUV(0.65, 0.8, 0.65, 0.921875, 0.0);
        t.draw();
    }
}
