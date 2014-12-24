package com.fibonacci.advanced_unknowns.entity.throwable.render;


import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * Created by Fibonacci on 12/22/14.
 */
public class RenderLaserBolt extends Render {

    private ResourceLocation texture = new ResourceLocation("advancedunknowns", "textures/entity/throwable/laserbolt.png");
    @Override
    public void doRender(Entity par1EntityArrow, double par2, double par4, double par6, float par8, float par9) {
        //this.bindTexture(texture);

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        Tessellator t = Tessellator.instance;
        t.startDrawingQuads();
        {
            t.setColorRGBA(250,40,40,120);
            t.addVertexWithUV(1, 1.0, 1, 0.921875, 0.078125);
            t.addVertexWithUV(1, 1.0, 0, 1.0, 0.078125);
            t.addVertexWithUV(0, 1.0, 0, 1.0, 0.0);
            t.addVertexWithUV(0, 1.0, 1, 0.921875, 0.0);
            t.addVertexWithUV(0, 0, 1, 0.921875, 0.078125);
            t.addVertexWithUV(0, 0, 0, 1.0, 0.078125);
            t.addVertexWithUV(1, 0, 0, 1.0, 0.0);
            t.addVertexWithUV(1, 0, 1, 0.921875, 0.0);
            t.addVertexWithUV(1, 0, 1, 0.921875, 0.078125);
            t.addVertexWithUV(1, 1.0, 1, 1.0, 0.078125);
            t.addVertexWithUV(0, 1.0, 1, 1.0, 0.0);
            t.addVertexWithUV(0, 0, 1, 0.921875, 0.0);
            t.addVertexWithUV(0, 0, 0, 0.921875, 0.078125);
            t.addVertexWithUV(0, 1.0, 0, 1.0, 0.078125);
            t.addVertexWithUV(1, 1.0, 0, 1.0, 0.0);
            t.addVertexWithUV(1, 0, 0, 0.921875, 0.0);
            t.addVertexWithUV(0, 0, 1, 0.921875, 0.078125);
            t.addVertexWithUV(0, 1.0, 1, 1.0, 0.078125);
            t.addVertexWithUV(0, 1.0, 0, 1.0, 0.0);
            t.addVertexWithUV(0, 0, 0, 0.921875, 0.0);
            t.addVertexWithUV(1, 0, 0, 0.921875, 0.078125);
            t.addVertexWithUV(1, 1.0, 0, 1.0, 0.078125);
            t.addVertexWithUV(1, 1.0, 1, 1.0, 0.0);
            t.addVertexWithUV(1, 0, 1, 0.921875, 0.0);

        }
        t.draw();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return texture;
    }
}
