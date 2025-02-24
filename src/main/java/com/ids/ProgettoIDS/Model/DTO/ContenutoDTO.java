package com.ids.ProgettoIDS.Model.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.util.Date;

public class ContenutoDTO {
    @NotNull(message = "Il campo Nome non può essere nullo")
    @NotEmpty(message = "Il campo Nome non può essere vuoto")
    private String nome;
    private String descrizione;
    private Date dataCreazione;
    @NotNull(message = "Il campo Creatore non può essere nullo")
    private Integer creatore;
    @NotNull(message = "Il campo Comune non può essere nullo")
    private Integer comune;

    public ContenutoDTO(String nome, String descrizione, Date dataCreazione, Integer creatore, Integer comune) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.creatore = creatore;
        this.comune = comune;
    }

    public ContenutoDTO(){

    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public Integer getCreatore() {
        return creatore;
    }

    public Integer getComune() {
        return comune;
    }
}
