package com.ids.ProgettoIDS.Model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Contenuto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Contenuto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    String nome;
    String descrizione;
    Date dataCreazione;
    @ManyToOne
    Utente creatore;
    StatoApprovazione statoApprovazione;
    @ManyToOne
    Comune comune;

    public Contenuto(String nome, String descrizione, Date dataCreazione, Integer IdCreatore){
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.creatore = new Utente();
        this.creatore.setID(IdCreatore);
    }

    public Contenuto(){

    }
    public Utente getCreatore() {
        return creatore;
    }

    public Comune getComune() {
        return comune;
    }

    public Integer getID() {
        return ID;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public void setStatoApprovazione(StatoApprovazione statoApprovazione) {
        this.statoApprovazione = statoApprovazione;
    }

    public void setCreatore(Utente creatore) {
        this.creatore = creatore;
    }
}