package com.ids.ProgettoIDS.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "ontenuto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Contenuto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    String nome;
    String descrizione;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
    //Getters per accedere ai dati nei DTO
    public Integer getID() { return ID; }
    public String getNome() { return nome; }
    public String getDescrizione() { return descrizione; }
    public Date getDataCreazione() { return dataCreazione; }
    public Utente getCreatore() { return creatore; }
    public Comune getComune() { return comune; }
    public StatoApprovazione getStatoApprovazione() { return statoApprovazione; }

    //Setters per aggiornare i valori
    public void setComune(Comune comune) { this.comune = comune; }
    public void setStatoApprovazione(StatoApprovazione statoApprovazione) { this.statoApprovazione = statoApprovazione; }
    public void setCreatore(Utente creatore) { this.creatore = creatore; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public void setDataCreazione(Date dataCreazione) { this.dataCreazione = dataCreazione; }
}
