package com.ids.ProgettoIDS.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notifica")
public class Notifica{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Id;
  private String titolo;
  private String descrizione;
  private LocalDateTime timeStamp;

  public Notifica(){

  }

  public Notifica (String titolo, String descrizione){
    if (titolo.isBlank() || descrizione.isBlank()){
      throw new IllegalArgumentException ("titolo o descrizione vuoti");
    }

    this.titolo= titolo;
    this.descrizione=descrizione;
    this.timeStamp = LocalDateTime.now();
  }

}
