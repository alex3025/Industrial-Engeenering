package com.indeng.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBunkerCHeater extends ModelBase
{
    //fields
    ModelRenderer Bruciatore;
    ModelRenderer Scambiatore;
    ModelRenderer Scappamento;
    ModelRenderer PortaTubo;
    ModelRenderer PortaTubo2;
    ModelRenderer Paletto1;
    ModelRenderer Paletto2;
    ModelRenderer Mandata1;
    ModelRenderer Mandata2;
    ModelRenderer Ritorno1;
    ModelRenderer Ritorno2;
    ModelRenderer CaminoA;
    ModelRenderer CaminoB;
    ModelRenderer CaminoC;
    ModelRenderer CaminoD;
    ModelRenderer PortaTubo3;
  
  public ModelBunkerCHeater()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Bruciatore = new ModelRenderer(this, 0, 0);
      Bruciatore.addBox(0F, 0F, 0F, 16, 16, 7);
      Bruciatore.setRotationPoint(-8F, 8F, 0F);
      Bruciatore.setTextureSize(128, 32);
      Bruciatore.mirror = true;
      setRotation(Bruciatore, 0F, 0F, 0F);
      Scambiatore = new ModelRenderer(this, 49, 0);
      Scambiatore.addBox(0F, 0F, 0F, 8, 8, 8);
      Scambiatore.setRotationPoint(-4F, 12F, -8F);
      Scambiatore.setTextureSize(128, 32);
      Scambiatore.mirror = true;
      setRotation(Scambiatore, 0F, 0F, 0F);
      Scappamento = new ModelRenderer(this, 82, 0);
      Scappamento.addBox(0F, 0F, 0F, 2, 10, 2);
      Scappamento.setRotationPoint(-1F, -2F, 2.5F);
      Scappamento.setTextureSize(128, 32);
      Scappamento.mirror = true;
      setRotation(Scappamento, 0F, 0F, 0F);
      PortaTubo = new ModelRenderer(this, 49, 16);
      PortaTubo.addBox(0F, 0F, 0F, 1, 8, 8);
      PortaTubo.setRotationPoint(-8F, 12F, -4F);
      PortaTubo.setTextureSize(128, 32);
      PortaTubo.mirror = true;
      setRotation(PortaTubo, 0F, 0F, 0F);
      PortaTubo2 = new ModelRenderer(this, 0, 25);
      PortaTubo2.addBox(0F, 0F, 0F, 2, 2, 2);
      PortaTubo2.setRotationPoint(-7F, 15F, -2F);
      PortaTubo2.setTextureSize(128, 32);
      PortaTubo2.mirror = true;
      setRotation(PortaTubo2, 0F, 0F, 0F);
      Paletto1 = new ModelRenderer(this, 9, 25);
      Paletto1.addBox(0F, 0F, 0F, 1, 4, 1);
      Paletto1.setRotationPoint(2F, 20F, -7F);
      Paletto1.setTextureSize(128, 32);
      Paletto1.mirror = true;
      setRotation(Paletto1, 0F, 0F, 0F);
      Paletto2 = new ModelRenderer(this, 9, 25);
      Paletto2.addBox(0F, 0F, 0F, 1, 4, 1);
      Paletto2.setRotationPoint(-3F, 20F, -7F);
      Paletto2.setTextureSize(128, 32);
      Paletto2.mirror = true;
      setRotation(Paletto2, 0F, 0F, 0F);
      Mandata1 = new ModelRenderer(this, 17, 25);
      Mandata1.addBox(0F, 0F, 0F, 2, 1, 1);
      Mandata1.setRotationPoint(4F, 13F, -7F);
      Mandata1.setTextureSize(128, 32);
      Mandata1.mirror = true;
      setRotation(Mandata1, 0F, 0F, 0F);
      Mandata2 = new ModelRenderer(this, 17, 25);
      Mandata2.addBox(0F, 0F, 0F, 1, 1, 6);
      Mandata2.setRotationPoint(5F, 13F, -6F);
      Mandata2.setTextureSize(128, 32);
      Mandata2.mirror = true;
      setRotation(Mandata2, 0F, 0F, 0F);
      Ritorno1 = new ModelRenderer(this, 17, 25);
      Ritorno1.addBox(0F, 0F, 0F, 1, 1, 6);
      Ritorno1.setRotationPoint(5F, 18F, -6F);
      Ritorno1.setTextureSize(128, 32);
      Ritorno1.mirror = true;
      setRotation(Ritorno1, 0F, 0F, 0F);
      Ritorno2 = new ModelRenderer(this, 17, 25);
      Ritorno2.addBox(0F, 0F, 0F, 2, 1, 1);
      Ritorno2.setRotationPoint(4F, 18F, -7F);
      Ritorno2.setTextureSize(128, 32);
      Ritorno2.mirror = true;
      setRotation(Ritorno2, 0F, 0F, 0F);
      CaminoA = new ModelRenderer(this, 38, 25);
      CaminoA.addBox(0F, 0F, 0F, 4, 1, 1);
      CaminoA.setRotationPoint(-2F, -3F, 1.5F);
      CaminoA.setTextureSize(128, 32);
      CaminoA.mirror = true;
      setRotation(CaminoA, 0F, 0F, 0F);
      CaminoB = new ModelRenderer(this, 38, 25);
      CaminoB.addBox(0F, 0F, 0F, 4, 1, 1);
      CaminoB.setRotationPoint(-2F, -3F, 4.5F);
      CaminoB.setTextureSize(128, 32);
      CaminoB.mirror = true;
      setRotation(CaminoB, 0F, 0F, 0F);
      CaminoC = new ModelRenderer(this, 38, 25);
      CaminoC.addBox(0F, 0F, 0F, 1, 1, 2);
      CaminoC.setRotationPoint(-2F, -3F, 2.5F);
      CaminoC.setTextureSize(128, 32);
      CaminoC.mirror = true;
      setRotation(CaminoC, 0F, 0F, 0F);
      CaminoD = new ModelRenderer(this, 38, 25);
      CaminoD.addBox(0F, 0F, 0F, 1, 1, 2);
      CaminoD.setRotationPoint(1F, -3F, 2.5F);
      CaminoD.setTextureSize(128, 32);
      CaminoD.mirror = true;
      setRotation(CaminoD, 0F, 0F, 0F);
      PortaTubo3 = new ModelRenderer(this, 0, 0);
      PortaTubo3.addBox(0F, 0F, 0F, 8, 8, 1);
      PortaTubo3.setRotationPoint(-4F, 12F, 7F);
      PortaTubo3.setTextureSize(128, 32);
      PortaTubo3.mirror = true;
      setRotation(PortaTubo3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Bruciatore.render(f5);
    Scambiatore.render(f5);
    Scappamento.render(f5);
    PortaTubo.render(f5);
    PortaTubo2.render(f5);
    Paletto1.render(f5);
    Paletto2.render(f5);
    Mandata1.render(f5);
    Mandata2.render(f5);
    Ritorno1.render(f5);
    Ritorno2.render(f5);
    CaminoA.render(f5);
    CaminoB.render(f5);
    CaminoC.render(f5);
    CaminoD.render(f5);
    PortaTubo3.render(f5);
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
