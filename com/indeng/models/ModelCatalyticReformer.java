package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCatalyticReformer extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape14a;
    ModelRenderer Shape11a;
    ModelRenderer Shape15;
  
  public ModelCatalyticReformer()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 12, 16);
      Shape1.setRotationPoint(-8F, 12F, -8F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 65, 0);
      Shape2.addBox(0F, 0F, 0F, 6, 24, 6);
      Shape2.setRotationPoint(-3F, -12F, 1F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 90, 0);
      Shape3.addBox(0F, 0F, 0F, 6, 26, 6);
      Shape3.setRotationPoint(-3F, -14F, -7F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 115, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 26, 1);
      Shape4.setRotationPoint(-5F, -14F, 3.5F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 29);
      Shape5.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape5.setRotationPoint(-4F, -14F, 3.5F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 115, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 8, 1);
      Shape6.setRotationPoint(0F, -20F, 3.5F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 65, 33);
      Shape7.addBox(0F, 0F, 0F, 1, 1, 8);
      Shape7.setRotationPoint(0F, -16F, -4.5F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 115, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape8.setRotationPoint(0F, -15F, -4.5F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0.0174533F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 60, 30);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape9.setRotationPoint(-4F, 0F, -4.5F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 120, 16);
      Shape10.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape10.setRotationPoint(-0.5F, -21F, 3F);
      Shape10.setTextureSize(128, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 115, 0);
      Shape11.addBox(0F, 0F, 0F, 1, 12, 1);
      Shape11.setRotationPoint(-5F, 0F, -4.5F);
      Shape11.setTextureSize(128, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 35);
      Shape12.addBox(0F, 0F, 0F, 3, 3, 10);
      Shape12.setRotationPoint(4F, 8F, -5F);
      Shape12.setTextureSize(128, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 28, 35);
      Shape13.addBox(0F, 0F, 0F, 1, 1, 12);
      Shape13.setRotationPoint(5F, 9F, -6F);
      Shape13.setTextureSize(128, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 51, 29);
      Shape14.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape14.setRotationPoint(5F, 9F, 6F);
      Shape14.setTextureSize(128, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape14a = new ModelRenderer(this, 51, 29);
      Shape14a.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape14a.setRotationPoint(5F, 9F, -7F);
      Shape14a.setTextureSize(128, 64);
      Shape14a.mirror = true;
      setRotation(Shape14a, 0F, 0F, 0F);
      Shape11a = new ModelRenderer(this, 115, 0);
      Shape11a.addBox(0F, 0F, 0F, 1, 12, 1);
      Shape11a.setRotationPoint(5F, -4F, -3.5F);
      Shape11a.setTextureSize(128, 64);
      Shape11a.mirror = true;
      setRotation(Shape11a, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 120, 0);
      Shape15.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape15.setRotationPoint(3F, -4F, -3.5F);
      Shape15.setTextureSize(128, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
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
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape14a.render(f5);
    Shape11a.render(f5);
    Shape15.render(f5);
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
