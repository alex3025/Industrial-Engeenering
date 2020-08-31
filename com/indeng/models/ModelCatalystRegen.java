package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCatalystRegen extends ModelBase {
	//fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape6a;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public ModelCatalystRegen()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 12, 16);
      Shape1.setRotationPoint(-8F, 12F, -8F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 68, 0);
      Shape2.addBox(0F, 0F, 0F, 3, 1, 6);
      Shape2.setRotationPoint(-5F, 11F, -3F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 66, 13);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 12);
      Shape3.setRotationPoint(-4F, 8.5F, -6F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 89, 0);
      Shape4.addBox(0F, 0F, 0F, 4, 4, 7);
      Shape4.setRotationPoint(-5.5F, 7F, -3.5F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape6a = new ModelRenderer(this, 68, 8);
      Shape6a.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape6a.setRotationPoint(-4F, 9.5F, 5F);
      Shape6a.setTextureSize(64, 32);
      Shape6a.mirror = true;
      setRotation(Shape6a, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 68, 8);
      Shape5.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape5.setRotationPoint(-4F, 9.5F, -6F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 68, 8);
      Shape6.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape6.setRotationPoint(3F, 9.5F, -6F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 68, 27);
      Shape7.addBox(0F, 0F, 0F, 7, 1, 1);
      Shape7.setRotationPoint(-3F, 8.5F, -6F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 68, 8);
      Shape8.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape8.setRotationPoint(3F, 9F, 6F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 93, 13);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 11);
      Shape9.setRotationPoint(3F, 9F, -5F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape6a.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
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
