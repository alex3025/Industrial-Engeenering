package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPolymerizationUnit extends ModelBase
{
  //fields
    ModelRenderer Tr1;
    ModelRenderer Tr2;
    ModelRenderer Tr3;
    ModelRenderer TrA;
    ModelRenderer Tr4;
    ModelRenderer TrB;
    ModelRenderer TrC;
    ModelRenderer TrD;
    ModelRenderer Tr1A;
    ModelRenderer Tr1B;
    ModelRenderer Tr1C;
    ModelRenderer Tr1D;
    ModelRenderer Serb1;
    ModelRenderer serb2;
    ModelRenderer Uscita;
    ModelRenderer Entr;
    ModelRenderer Cb1;
    ModelRenderer Cb2;
  
  public ModelPolymerizationUnit()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Tr1 = new ModelRenderer(this, 0, 0);
      Tr1.addBox(0F, 0F, 0F, 16, 1, 1);
      Tr1.setRotationPoint(-8F, 23F, -8F);
      Tr1.setTextureSize(64, 64);
      Tr1.mirror = true;
      setRotation(Tr1, 0F, 0F, 0F);
      Tr2 = new ModelRenderer(this, 0, 0);
      Tr2.addBox(0F, 0F, 0F, 16, 1, 1);
      Tr2.setRotationPoint(-8F, 23F, 7F);
      Tr2.setTextureSize(64, 64);
      Tr2.mirror = true;
      setRotation(Tr2, 0F, 0F, 0F);
      Tr3 = new ModelRenderer(this, 0, 0);
      Tr3.addBox(0F, 0F, 0F, 16, 1, 1);
      Tr3.setRotationPoint(-8F, 8F, -8F);
      Tr3.setTextureSize(64, 64);
      Tr3.mirror = true;
      setRotation(Tr3, 0F, 0F, 0F);
      TrA = new ModelRenderer(this, 0, 0);
      TrA.addBox(0F, 0F, 0F, 1, 14, 1);
      TrA.setRotationPoint(-8F, 9F, 7F);
      TrA.setTextureSize(64, 64);
      TrA.mirror = true;
      setRotation(TrA, 0F, 0F, 0F);
      Tr4 = new ModelRenderer(this, 0, 0);
      Tr4.addBox(0F, 0F, 0F, 16, 1, 1);
      Tr4.setRotationPoint(-8F, 8F, 7F);
      Tr4.setTextureSize(64, 64);
      Tr4.mirror = true;
      setRotation(Tr4, 0F, 0F, 0F);
      TrB = new ModelRenderer(this, 0, 0);
      TrB.addBox(0F, 0F, 0F, 1, 14, 1);
      TrB.setRotationPoint(7F, 9F, 7F);
      TrB.setTextureSize(64, 64);
      TrB.mirror = true;
      setRotation(TrB, 0F, 0F, 0F);
      TrC = new ModelRenderer(this, 0, 0);
      TrC.addBox(0F, 0F, 0F, 1, 14, 1);
      TrC.setRotationPoint(7F, 9F, -8F);
      TrC.setTextureSize(64, 64);
      TrC.mirror = true;
      setRotation(TrC, 0F, 0F, 0F);
      TrD = new ModelRenderer(this, 0, 0);
      TrD.addBox(0F, 0F, 0F, 1, 14, 1);
      TrD.setRotationPoint(-8F, 9F, -8F);
      TrD.setTextureSize(64, 64);
      TrD.mirror = true;
      setRotation(TrD, 0F, 0F, 0F);
      Tr1A = new ModelRenderer(this, 0, 0);
      Tr1A.addBox(0F, 0F, 0F, 1, 1, 14);
      Tr1A.setRotationPoint(7F, 23F, -7F);
      Tr1A.setTextureSize(64, 64);
      Tr1A.mirror = true;
      setRotation(Tr1A, 0F, 0F, 0F);
      Tr1B = new ModelRenderer(this, 0, 0);
      Tr1B.addBox(0F, 0F, 0F, 1, 1, 14);
      Tr1B.setRotationPoint(-8F, 8F, -7F);
      Tr1B.setTextureSize(64, 64);
      Tr1B.mirror = true;
      setRotation(Tr1B, 0F, 0F, 0F);
      Tr1C = new ModelRenderer(this, 0, 0);
      Tr1C.addBox(0F, 0F, 0F, 1, 1, 14);
      Tr1C.setRotationPoint(7F, 8F, -7F);
      Tr1C.setTextureSize(64, 64);
      Tr1C.mirror = true;
      setRotation(Tr1C, 0F, 0F, 0F);
      Tr1D = new ModelRenderer(this, 0, 0);
      Tr1D.addBox(0F, 0F, 0F, 1, 1, 14);
      Tr1D.setRotationPoint(-8F, 23F, -7F);
      Tr1D.setTextureSize(64, 64);
      Tr1D.mirror = true;
      setRotation(Tr1D, 0F, 0F, 0F);
      Serb1 = new ModelRenderer(this, 0, 16);
      Serb1.addBox(0F, 0F, 0F, 14, 14, 6);
      Serb1.setRotationPoint(-7F, 9F, -7F);
      Serb1.setTextureSize(64, 64);
      Serb1.mirror = true;
      setRotation(Serb1, 0F, 0F, 0F);
      serb2 = new ModelRenderer(this, 0, 16);
      serb2.addBox(0F, 0F, 0F, 14, 14, 6);
      serb2.setRotationPoint(-7F, 9F, 1F);
      serb2.setTextureSize(64, 64);
      serb2.mirror = true;
      setRotation(serb2, 0F, 0F, 0F);
      Uscita = new ModelRenderer(this, 40, 0);
      Uscita.addBox(0F, 0F, 0F, 8, 8, 1);
      Uscita.setRotationPoint(-4F, 12F, -8F);
      Uscita.setTextureSize(64, 64);
      Uscita.mirror = true;
      setRotation(Uscita, 0F, 0F, 0F);
      Entr = new ModelRenderer(this, 40, 0);
      Entr.addBox(0F, 0F, 0F, 8, 8, 1);
      Entr.setRotationPoint(-4F, 12F, 7F);
      Entr.setTextureSize(64, 64);
      Entr.mirror = true;
      setRotation(Entr, 0F, 0F, 0F);
      Cb1 = new ModelRenderer(this, 0, 39);
      Cb1.addBox(0F, 0F, 0F, 1, 1, 21);
      Cb1.setRotationPoint(6.9F, 8F, -7F);
      Cb1.setTextureSize(64, 64);
      Cb1.mirror = true;
      setRotation(Cb1, -0.7853982F, 0F, 0F);
      Cb2 = new ModelRenderer(this, 0, 39);
      Cb2.addBox(0F, 0F, 0F, 1, 1, 21);
      Cb2.setRotationPoint(-7.9F, 8F, -7F);
      Cb2.setTextureSize(64, 64);
      Cb2.mirror = true;
      setRotation(Cb2, -0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Tr1.render(f5);
    Tr2.render(f5);
    Tr3.render(f5);
    TrA.render(f5);
    Tr4.render(f5);
    TrB.render(f5);
    TrC.render(f5);
    TrD.render(f5);
    Tr1A.render(f5);
    Tr1B.render(f5);
    Tr1C.render(f5);
    Tr1D.render(f5);
    Serb1.render(f5);
    serb2.render(f5);
    Uscita.render(f5);
    Entr.render(f5);
    Cb1.render(f5);
    Cb2.render(f5);
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
