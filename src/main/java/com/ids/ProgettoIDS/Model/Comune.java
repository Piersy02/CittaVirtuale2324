package com.ids.ProgettoIDS.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comune")
public class Comune {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ID;
  private String nome;
  private String descrizione;
  @Embedded
  private Posizione posizione;
  private double area;
  private Date dataFondazione;

  public Comune(String nome, String descrizione, Posizione posizione, double area, Date dataFondazione){
    this.nome = nome;
    this.descrizione = descrizione;
    this.posizione=posizione;
    this.area=area;
    this.dataFondazione=dataFondazione;

  }

  public Comune(){}

  public Integer getID(){
    return ID;
  }

  public void setID(Integer ID){
    this.ID=ID;
  }
}
