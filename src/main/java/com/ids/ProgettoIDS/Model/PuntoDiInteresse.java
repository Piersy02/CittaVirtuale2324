package com.ids.ProgettoIDS.Model;

import java.util.Date;

public class PuntoDiInteresse extends Content{
    private CategoriaPOI categoria;


    public PuntoDiInteresse(String nome, String descrizione, Date dataCreazione, int IdCreatore, CategoriaPOI categoria) {
        super(nome, descrizione, dataCreazione, IdCreatore);
        this.categoria = categoria;
    }
    public TipoContenuto getTipoContenuto(){
        return TipoContenuto.PUNTO_DI_INTERESSE;
    }
}
