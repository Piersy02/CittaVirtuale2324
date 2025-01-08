package com.ids.ProgettoIDS.Model;

import  java.util.Date;
import java.util.List;

public class Contest{
    int ID;
    private String nome;
    private String descrizione;
    private Date dataInizio;
    private Date dataFine;
    private String tipo;
    private String regole;
    private List<Contenuto> contenuti;
    private Contenuto contenutoVincitore;
    private Utente creatore;

    public Contest(String nome, String descrizione, Date dataInizio, Date dataFine,
                   String tipo, String regole, Utente creatore) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
        this.regole = regole;
        this.creatore = creatore;
    }

    public TipoContenuto getTipoContenuto(){
        return TipoContenuto.CONTEST;
    }
}
