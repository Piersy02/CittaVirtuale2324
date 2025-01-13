package com.ids.ProgettoIDS.Model;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Model.Contenuto;
import com.ids.ProgettoIDS.Model.Posizione;
import com.ids.ProgettoIDS.Model.TipoContenuto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
public class Evento extends Contenuto {
  private Date dataInizio;
  private Date dataFine;
  @Embedded
  private Posizione posizione;
  private Comune comune;

public Evento (String nome, String descrizione, Date dataCreazione, int IdCreatore, Date dataInizio, Date dataFine,
              Posizione posizione, Integer comune){
  super (nome, descrizione, dataCreazione, IdCreatore);

  this.dataInizio = dataInizio;
  this.dataFine = dataFine;
  this.posizione= posizione;
  this.comune = new Comune();
  this.comune.setID (comune);
}

public Evento(){}

public TipoContenuto getTipoContenuto(){
  return TipoContenuto.EVENTO;
}

}
