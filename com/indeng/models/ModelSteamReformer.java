package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSteamReformer extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape5a;
    ModelRenderer Shape5b;
    ModelRenderer Shape4a;
    ModelRenderer Shape4b;
    ModelRenderer Shape4c;
    ModelRenderer Shape6;
    ModelRenderer Shape6c;
    ModelRenderer Shape6a;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
  
  public ModelSteamReformer()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 12, 16);
      Shape1.setRotationPoint(-8F, 12F, -8F);
      Shape1.setTextureSize(128, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 65, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 20, 1);
      Shape2.setRotationPoint(4F, -8F, -5F);
      Shape2.setTextureSize(128, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 65, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 20, 1);
      Shape3.setRotationPoint(4F, -8F, -0.5F);
      Shape3.setTextureSize(128, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 65, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 20, 1);
      Shape4.setRotationPoint(4F, -8F, 4F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 71, 0);
      Shape5.addBox(0F, 0F, 0F, 3, 16, 3);
      Shape5.setRotationPoint(3F, -6F, 3F);
      Shape5.setTextureSize(128, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape5a = new ModelRenderer(this, 71, 0);
      Shape5a.addBox(0F, 0F, 0F, 3, 16, 3);
      Shape5a.setRotationPoint(3F, -6F, -1.5F);
      Shape5a.setTextureSize(128, 32);
      Shape5a.mirror = true;
      setRotation(Shape5a, 0F, 0F, 0F);
      Shape5b = new ModelRenderer(this, 71, 0);
      Shape5b.addBox(0F, 0F, 0F, 3, 16, 3);
      Shape5b.setRotationPoint(3F, -6F, -6F);
      Shape5b.setTextureSize(128, 32);
      Shape5b.mirror = true;
      setRotation(Shape5b, 0F, 0F, 0F);
      Shape4a = new ModelRenderer(this, 65, 0);
      Shape4a.addBox(0F, 0F, 0F, 1, 20, 1);
      Shape4a.setRotationPoint(1F, -8F, 4F);
      Shape4a.setTextureSize(128, 32);
      Shape4a.mirror = true;
      setRotation(Shape4a, 0F, 0F, 0F);
      Shape4b = new ModelRenderer(this, 65, 0);
      Shape4b.addBox(0F, 0F, 0F, 1, 20, 1);
      Shape4b.setRotationPoint(1F, -8F, -5F);
      Shape4b.setTextureSize(128, 32);
      Shape4b.mirror = true;
      setRotation(Shape4b, 0F, 0F, 0F);
      Shape4c = new ModelRenderer(this, 65, 0);
      Shape4c.addBox(0F, 0F, 0F, 1, 20, 1);
      Shape4c.setRotationPoint(1F, -8F, -0.5F);
      Shape4c.setTextureSize(128, 32);
      Shape4c.mirror = true;
      setRotation(Shape4c, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 85, 0);
      Shape6.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape6.setRotationPoint(1F, -9F, -5F);
      Shape6.setTextureSize(128, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape6c = new ModelRenderer(this, 85, 0);
      Shape6c.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape6c.setRotationPoint(1F, -9F, 4F);
      Shape6c.setTextureSize(128, 32);
      Shape6c.mirror = true;
      setRotation(Shape6c, 0F, 0F, 0F);
      Shape6a = new ModelRenderer(this, 85, 0);
      Shape6a.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape6a.setRotationPoint(1F, -9F, -0.5F);
      Shape6a.setTextureSize(128, 32);
      Shape6a.mirror = true;
      setRotation(Shape6a, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 85, 3);
      Shape7.addBox(0F, 0F, 0F, 5, 12, 12);
      Shape7.setRotationPoint(-6F, 0F, -6F);
      Shape7.setTextureSize(128, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 120, 0);
      Shape8.addBox(0F, 0F, 0F, 2, 17, 2);
      Shape8.setRotationPoint(-4.5F, -17F, -1F);
      Shape8.setTextureSize(128, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape5a.render(f5);
    Shape5b.render(f5);
    Shape4a.render(f5);
    Shape4b.render(f5);
    Shape4c.render(f5);
    Shape6.render(f5);
    Shape6c.render(f5);
    Shape6a.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
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
  }

}
