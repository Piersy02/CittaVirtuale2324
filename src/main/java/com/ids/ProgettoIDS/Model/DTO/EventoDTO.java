package com.ids.ProgettoIDS.Model.DTO;

import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Model.Posizione;

import java.util.Date;

public class EventoDTO extends ContenutoDTO{
    private Date dataInizio;
    private Date dataFine;
    private Posizione posizione;


    public EventoDTO(String nome, String descrizione, Date dataCreazione, Integer creatore, Integer comune,
                     Date dataInizio, Date dataFine, Posizione posizione) {
        super(nome, descrizione, dataCreazione, creatore, comune);
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.posizione = posizione;
    }

    public Evento toEvento(){
        return new Evento(
                this.getNome(),
                this.getDescrizione(),
                this.getDataCreazione(),
                this.getCreatore(),
                this.getDataInizio(),
                this.getDataFine(),
                this.getPosizione(),
                this.getComune());
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public Posizione getPosizione() {
        return posizione;
    }
}