package com.ids.ProgettoIDS.Model;

import java.time.LocalDateTime;

public class Notifica{
  private Integer Id;
  private String titolo;
  private String descrizione;
  private LocalDateTime timeStamp;

public Notifica(){

}

public Notifica (String titolo, String dascrizione){
  if (titolo.isBlank() || descrizione.isBlank()){
    throw new IllegalArgumentException ("titolo o descrizione vuoti");
  }

  this.titolo= titolo;
  this.descrizione=descrizione;
  this.timeStamp = LocalDateTime.now();
}
}
