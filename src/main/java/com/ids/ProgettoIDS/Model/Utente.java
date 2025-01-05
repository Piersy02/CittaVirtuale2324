package com.ids.ProgettoIDS.Model;

import java.util.Date;

public class Utente {
    private int ID;
    private String username;
    private String nomeCompleto;
    private String email;
    private Date dataRegistrazione;

    public Utente(String username, String nomeCompleto, String email, Date dataRegistrazione) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataRegistrazione = dataRegistrazione;
    }

    public Utente(){

    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
}
