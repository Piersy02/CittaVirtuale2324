package com.ids.ProgettoIDS.Model;

public class RuoloUtenteComune {
  private Integer ID;
  private Comune comune;
  private RuoloUtente ruolo;
  private Utente utente;

public void setRuolo (RuoloUtente ruolo){
  this.ruolo =ruolo;
}

public RuoloUtenteComune (Comune comune, RuoloUtente ruolo, Utente utente){
  this.comune = comune;
  this.ruolo = ruolo;
  this.utente =utente;
}
  public RuoloUtenteComune(){

  }

public RuoloUtente getRuolo(){
  return comune;
}

public Comune getComune(){
  return comune;
}

public Integer getID(){
  return ID;
}

public Utente getUtente(){
  return utente;
}

}
