package com.ids.ProgettoIDS.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

  public String getNome() {
    return nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public Posizione getPosizione() {
    return posizione;
  }

  public double getArea() {
    return area;
  }

  public Date getDataFondazione() {
    return dataFondazione;
  }

  // Setter
  public void setID(Integer ID){
    this.ID=ID;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public void setPosizione(Posizione posizione) {
    this.posizione = posizione;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public void setDataFondazione(Date dataFondazione) {
    this.dataFondazione = dataFondazione;
  }
}
