package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCatalyticCracker extends ModelBase
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape5a;
    ModelRenderer Shape6;
    ModelRenderer Shape6a;
    ModelRenderer Shape7;
    ModelRenderer Shape7a;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
  
  public ModelCatalyticCracker()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 12, 16);
      Shape1.setRotationPoint(-8F, 12F, -8F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 30);
      Shape2.addBox(0F, 0F, 0F, 12, 12, 12);
      Shape2.setRotationPoint(-5F, -4F, -6F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 49, 30);
      Shape3.addBox(0F, 0F, 0F, 8, 4, 8);
      Shape3.setRotationPoint(-3F, 8F, -4F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 49, 30);
      Shape4.addBox(0F, 0F, 0F, 8, 4, 8);
      Shape4.setRotationPoint(-3F, -8F, -4F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 65, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 24, 1);
      Shape5.setRotationPoint(-7F, -12F, -2F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape5a = new ModelRenderer(this, 65, 0);
      Shape5a.addBox(0F, 0F, 0F, 1, 24, 1);
      Shape5a.setRotationPoint(-7F, -12F, 1F);
      Shape5a.setTextureSize(128, 64);
      Shape5a.mirror = true;
      setRotation(Shape5a, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 71, 0);
      Shape6.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape6.setRotationPoint(-6F, -12F, -2F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape6a = new ModelRenderer(this, 71, 0);
      Shape6a.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape6a.setRotationPoint(-6F, -12F, 1F);
      Shape6a.setTextureSize(128, 64);
      Shape6a.mirror = true;
      setRotation(Shape6a, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 100, 0);
      Shape7.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape7.setRotationPoint(0F, -12F, -2F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape7a = new ModelRenderer(this, 100, 0);
      Shape7a.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape7a.setRotationPoint(0F, -12F, 1F);
      Shape7a.setTextureSize(128, 64);
      Shape7a.mirror = true;
      setRotation(Shape7a, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape8.setRotationPoint(5F, -7F, -0.5F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 0F, 1, 11, 1);
      Shape9.setRotationPoint(6F, -17F, -0.5F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 4, 0);
      Shape10.addBox(0F, 0F, 0F, 2, 4, 2);
      Shape10.setRotationPoint(5.5F, -21F, -1F);
      Shape10.setTextureSize(128, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
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
    Shape6.render(f5);
    Shape6a.render(f5);
    Shape7.render(f5);
    Shape7a.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
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
