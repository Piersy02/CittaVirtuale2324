package com.ids.ProgettoIDS.Model.DTO;

import com.ids.ProgettoIDS.Model.Contest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class ContestDTO {
    @NotNull(message = "Il campo Nome non può essere nullo")
    @NotEmpty(message = "Il campo Nome non può essere vuoto")
    private String nome;
    private String descrizione;
    private Date dataInizio;
    private Date dataFine;
    private String tipo;
    private String regole;
    private List<Integer> contenuti;
    @NotNull(message = "Il campo Creatore non può essere nullo")
    private Integer idCreatore;
    @NotNull(message = "Il campo Creatore non può essere nullo")
    private Integer idComune;

    public ContestDTO(String nome, String descrizione, Date dataInizio, Date dataFine, String tipo,
                      String regole, List<Integer> contenuti, Integer idCreatore, Integer idComune) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
        this.regole = regole;
        this.contenuti = contenuti;
        this.idCreatore = idCreatore;
        this.idComune = idComune;
    }

    public Contest toContest(){
        return new Contest(
                this.getNome(),
                this.getDescrizione(),
                this.getDataInizio(),
                this.getDataFine(),
                this.getContenuti(),
                this.getTipo(),
                this.getRegole(),
                this.getIdComune(),
                this.getIdCreatore());
    }

    public ContestDTO(){

    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRegole() {
        return regole;
    }

    public Integer getIdCreatore() {
        return idCreatore;
    }

    public Integer getIdComune() {
        return idComune;
    }

    public List<Integer> getContenuti() {
        return contenuti;
    }
}