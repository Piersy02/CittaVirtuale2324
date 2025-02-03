package com.ids.ProgettoIDS.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class PuntoDiInteresse extends Contenuto {
    private CategoriaPOI categoria;
    @Embedded
    private Posizione posizione;

    public PuntoDiInteresse(String nome, String descrizione, Date dataCreazione, int IdCreatore, CategoriaPOI categoria,
                            Posizione posizione, Integer comune) {
        super(nome, descrizione, dataCreazione, IdCreatore);
        this.categoria = categoria;
        this.posizione = posizione;
        this.comune =new Comune();
        this.comune.setID(comune);
    }

    public PuntoDiInteresse() {

    }

    public TipoContenuto getTipoContenuto(){
        return TipoContenuto.PUNTO_DI_INTERESSE;
    }
}
