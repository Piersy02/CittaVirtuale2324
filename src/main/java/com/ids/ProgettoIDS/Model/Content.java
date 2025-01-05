package com.ids.ProgettoIDS.Model;

import java.util.Date;

public abstract class Content {
    private int ID;
    String nome;
    String descrizione;
    Date dataCreazione;
    Utente creatore;
    StatoApprovazione statoApprovazione;

    public Content(String nome, String descrizione, Date dataCreazione, int IdCreatore){
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.creatore = new Utente();
        this.creatore.setID(IdCreatore);
    }
}