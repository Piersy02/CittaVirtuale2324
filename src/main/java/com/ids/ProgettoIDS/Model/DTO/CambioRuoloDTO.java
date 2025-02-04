package com.ids.ProgettoIDS.Model.DTO;


import com.ids.ProgettoIDS.Model.RuoloUtente;
import jakarta.validation.constraints.NotNull;

public class CambioRuoloDTO {
    @NotNull(message = "Il campo Comune non può essere nullo")
    Integer comuneId;
    @NotNull(message = "Il campo Ruolo non può essere nullo")
    RuoloUtente nuovoRuolo;
    @NotNull(message = "Il campo Utente non può essere nullo")
    Integer idUtente;

    public CambioRuoloDTO(RuoloUtente nuovoRuolo, Integer comuneId, Integer idUtente) {
        this.nuovoRuolo = nuovoRuolo;
        this.comuneId = comuneId;
        this.idUtente = idUtente;
    }

    public RuoloUtente getNuovoRuolo() {
        return nuovoRuolo;
    }

    public Integer getComuneId() {
        return comuneId;
    }

    public Integer getIdUtente() {
        return idUtente;
    }
}
