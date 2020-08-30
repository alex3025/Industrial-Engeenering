package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDistillationTower extends ModelBase {
	//fields
    ModelRenderer Corpo;
    ModelRenderer LatoB;
    ModelRenderer LatoA;
    ModelRenderer LatoC;
    ModelRenderer LatoD;
    ModelRenderer Shape1;
  
  public ModelDistillationTower()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Corpo = new ModelRenderer(this, 0, 0);
      Corpo.addBox(0F, 0F, 0F, 12, 16, 12);
      Corpo.setRotationPoint(-6F, 8F, -6F);
      Corpo.setTextureSize(64, 64);
      Corpo.mirror = true;
      setRotation(Corpo, 0F, 0F, 0F);
      LatoB = new ModelRenderer(this, 0, 0);
      LatoB.addBox(0F, 0F, 0F, 10, 16, 1);
      LatoB.setRotationPoint(-5F, 8F, -7F);
      LatoB.setTextureSize(64, 64);
      LatoB.mirror = true;
      setRotation(LatoB, 0F, 0F, 0F);
      LatoA = new ModelRenderer(this, 0, 0);
      LatoA.addBox(0F, 0F, 0F, 10, 16, 1);
      LatoA.setRotationPoint(-5F, 8F, 6F);
      LatoA.setTextureSize(64, 64);
      LatoA.mirror = true;
      setRotation(LatoA, 0F, 0F, 0F);
      LatoC = new ModelRenderer(this, 0, 0);
      LatoC.addBox(0F, 0F, 0F, 1, 16, 10);
      LatoC.setRotationPoint(6F, 8F, -5F);
      LatoC.setTextureSize(64, 64);
      LatoC.mirror = true;
      setRotation(LatoC, 0F, 0F, 0F);
      LatoD = new ModelRenderer(this, 0, 0);
      LatoD.addBox(0F, 0F, 0F, 1, 16, 10);
      LatoD.setRotationPoint(-7F, 8F, -5F);
      LatoD.setTextureSize(64, 64);
      LatoD.mirror = true;
      setRotation(LatoD, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 32);
      Shape1.addBox(0F, 0F, 0F, 1, 8, 8);
      Shape1.setRotationPoint(-8F, 12F, -4F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Corpo.render(f5);
    LatoB.render(f5);
    LatoA.render(f5);
    LatoC.render(f5);
    LatoD.render(f5);
    Shape1.render(f5);
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
