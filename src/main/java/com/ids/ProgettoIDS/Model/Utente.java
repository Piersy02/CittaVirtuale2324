package com.ids.ProgettoIDS.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String username;
    private String nomeCompleto;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataRegistrazione;
    @OneToMany
    private List<Notifica> notifiche;

    public Utente(String username, String nomeCompleto, String email, Date dataRegistrazione) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataRegistrazione = dataRegistrazione;
        this.notifiche = null;
    }

    public Utente(){

    }
    public void setID(int ID) {

        this.ID = ID;
    }
    public Integer getID() {

        return ID;
    }
    public String getUsername(){

        return this.username;
    }
    public String getEmail() {

        return email;
    }

    /**
     * Aggiunge una notifica alla lista dell'utente
     * @param notifica la notifica da aggiungere
     */
    public void aggiungiNotifica(Notifica notifica){

        this.notifiche.add(notifica);
    }

}
