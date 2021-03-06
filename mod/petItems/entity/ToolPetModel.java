// Date: 14/05/2013 15:18:16
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package petItems.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ToolPetModel extends ModelBase
{
  //fields
    ModelRenderer bipedHead;
    ModelRenderer bipedLeftLeg;
    ModelRenderer bipedRightLeg;
  
  public ToolPetModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      bipedHead = new ModelRenderer(this, 0, 0);
      bipedHead.addBox(-4F, -4F, -4F, 8, 8, 8);
      bipedHead.setRotationPoint(0F, 18F, 0F);
      bipedHead.setTextureSize(64, 32);
      bipedHead.mirror = true;
      setRotation(bipedHead, 0F, 0F, 0F);
      bipedLeftLeg = new ModelRenderer(this, 0, 21);
      bipedLeftLeg.addBox(0F, 0F, -3F, 3, 1, 4);
      bipedLeftLeg.setRotationPoint(1F, 23F, 0F);
      bipedLeftLeg.setTextureSize(64, 32);
      bipedLeftLeg.mirror = true;
      setRotation(bipedLeftLeg, 0F, 0F, 0F);
      bipedRightLeg = new ModelRenderer(this, 0, 21);
      bipedRightLeg.addBox(-3F, 0F, -3F, 3, 1, 4);
      bipedRightLeg.setRotationPoint(-1F, 23F, 0F);
      bipedRightLeg.setTextureSize(64, 32);
      bipedRightLeg.mirror = true;
      setRotation(bipedRightLeg, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bipedHead.render(f5);
    bipedLeftLeg.render(f5);
    bipedRightLeg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.bipedHead.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.bipedHead.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.bipedRightLeg.rotateAngleY = 0.0F;
    this.bipedLeftLeg.rotateAngleY = 0.0F;
  }

}
