package betterbreeds.entity.render;import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import betterbreeds.entity.EntityWolf3;



public class RenderWolf3 extends RenderLiving
{
    public RenderWolf3(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderWolf(EntityWolf3 b, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(b, par2, par4, par6, par8, par9);
        if(b.getName().length() >= 0){
    		this.renderLivingLabel(b, b.getName(), par2, par4, par6, 32);
    		}  
        
    }

    protected float getTailRotation(EntityWolf3 par1EntityWolf, float par2)
    {
        return par1EntityWolf.getTailRotation();
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLiving par1EntityLiving, float par2)
    {
        return this.getTailRotation((EntityWolf3)par1EntityLiving, par2);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderWolf((EntityWolf3)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderWolf((EntityWolf3)par1Entity, par2, par4, par6, par8, par9);
    }
}
