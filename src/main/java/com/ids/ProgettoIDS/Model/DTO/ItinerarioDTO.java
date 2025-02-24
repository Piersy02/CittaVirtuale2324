package com.ids.ProgettoIDS.Model.DTO;

import com.ids.ProgettoIDS.Model.Itinerario;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class ItinerarioDTO extends ContenutoDTO{
    @Size(min = 1, max = 5, message = "Il livello di difficoltà deve essere compreso tra 1 e 5")
    private int livelloDifficolta;
    private List<Integer> contenuti;

    public ItinerarioDTO(String nome, String descrizione, Date dataCreazione,
                         Integer creatore, Integer comune, int livelloDifficolta, List<Integer> contenuti) {
        super(nome, descrizione, dataCreazione, creatore, comune);
        this.livelloDifficolta = livelloDifficolta;
        this.contenuti = contenuti;
    }

    public Itinerario toItinerario(){
        return new Itinerario(
                this.getNome(),
                this.getDescrizione(),
                this.getDataCreazione(),
                this.getCreatore(),
                this.getLivelloDifficolta(),
                this.getComune(),
                this.getContenuti());
    }

    public int getLivelloDifficolta() {
        return livelloDifficolta;
    }
    public List<Integer> getContenuti() {
        return contenuti;
    }
}
