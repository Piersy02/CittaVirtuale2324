package com.ids.ProgettoIDS.Model.DTO;

import com.ids.ProgettoIDS.Model.Utente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UtenteDTO {
    @NotNull(message = "Il campo Username non può essere nullo")
    @NotEmpty(message = "Il campo Username non può essere vuoto")
    private String username;
    private String nomeCompleto;
    @NotNull(message = "Il campo Email non può essere nullo")
    @NotEmpty(message = "Il campo Email non può essere vuoto")
    @Email(message = "Il campo Email deve essere valido")
    private String email;
    private Date dataRegistrazione;
    @NotNull(message = "Il campo Comune non può essere nullo")
    private Integer comune;
    @NotNull(message = "Il campo Ruolo non può essere nullo")
    @Min(value = 0, message = "Il campo ruolo deve essere un numero positivo")
    private int ruolo;

    public UtenteDTO(String username, String nomeCompleto, String email, Date dataRegistrazione, Integer comune, int ruolo) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataRegistrazione = dataRegistrazione;
        this.comune = comune;
        this.ruolo = ruolo;
    }

    public Utente toUtente()
    {
        return new Utente(this.getUsername(), this.getNomeCompleto(), this.getEmail(), this.getDataRegistrazione());
    }
    public UtenteDTO(){

    }

    public String getUsername() {
        return username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataRegistrazione() {
        return dataRegistrazione;
    }

    public Integer getComune() {
        return comune;
    }

    public int getRuolo() {
        return ruolo;
    }
}
