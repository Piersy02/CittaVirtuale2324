package com.ids.ProgettoIDS.Model

public class Posizione {
  private float latitudine;
  private float longitudine;

public Posizione (float latitudine, float longitudine){
  this.latitudine = latitudine;
  this.longitudine = longitudine;
}
  public Posizione(){

  }

public float getLatitudine(){
  return latitudine;
}
  public float getLongitudine(){
    return longitudine;
  }

public void setLatitudine (float latitudine){
  this.latitudine = latitudine;
}

public void setLongitudine (float longitudine){
  this.longitudine = longitudine;
}

}
