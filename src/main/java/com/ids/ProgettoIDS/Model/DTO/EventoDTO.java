package com.ids.ProgettoIDS.Model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Model.Posizione;

import java.util.Date;

public class EventoDTO extends ContenutoDTO{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataInizio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataFine;
    private Posizione posizione;


    public EventoDTO(String nome, String descrizione, Date dataCreazione, Integer creatore, Integer comune,
                     Date dataInizio, Date dataFine, Posizione posizione) {
        super(nome, descrizione, dataCreazione, creatore, comune);
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.posizione = posizione;
    }

    public EventoDTO(Evento evento) {
        super(evento.getNome(), evento.getDescrizione(), evento.getDataCreazione(),
                evento.getCreatore().getID(), evento.getComune().getID());

        this.dataInizio = getDataInizio();
        this.dataFine = getDataFine();
        this.posizione = getPosizione();
    }

    public EventoDTO() {
        super(null, null, null, null, null);
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

    public String getNome() { return super.getNome(); }

    public String getDescrizione() { return super.getDescrizione(); }

    public Date getDataCreazione() { return super.getDataCreazione(); }

    public Integer getCreatore() { return super.getCreatore(); }

    public Integer getComune() { return super.getComune(); }
}