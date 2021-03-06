package betterbreeds.entity.render;

import betterbreeds.entity.EntityJelly;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderJelly extends RenderLiving
{

	public RenderJelly(ModelBase par1ModelBase, float par3)
	{
		super(par1ModelBase, par3);
	}

	protected void preRenderStuff(EntityJelly par1EntityShadowGoliath, float par2)
	{
		float scale = 0.9f;
		GL11.glScalef(scale, scale, scale);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glFrontFace(GL11.GL_CCW);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11. GL_ONE_MINUS_SRC_ALPHA);
	}
	
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
    	
    	this.preRenderStuff((EntityJelly)par1EntityLiving, par2);
    }

}
