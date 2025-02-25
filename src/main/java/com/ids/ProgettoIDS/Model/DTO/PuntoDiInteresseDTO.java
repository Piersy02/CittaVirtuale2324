package com.ids.ProgettoIDS.Model.DTO;

import com.ids.ProgettoIDS.Model.CategoriaPOI;
import com.ids.ProgettoIDS.Model.Posizione;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;

import java.util.Date;

public class PuntoDiInteresseDTO extends ContenutoDTO{
    private CategoriaPOI categoria;
    private Posizione posizione;

    public PuntoDiInteresseDTO(String nome, String descrizione, Date dataCreazione,
                               Integer creatore, Integer comune, CategoriaPOI categoria, Posizione posizione) {
        super(nome, descrizione, dataCreazione, creatore, comune);
        this.categoria = categoria;
        this.posizione = posizione;
    }
    public PuntoDiInteresseDTO() {
        super(null, null, null, null, null);
    }

    public PuntoDiInteresseDTO(PuntoDiInteresse poi) {
        super(poi.getNome(), poi.getDescrizione(), poi.getDataCreazione(), poi.getCreatore().getID(), poi.getComune().getID());
        this.categoria = poi.getCategoria();
        this.posizione = poi.getPosizione();
    }
    public PuntoDiInteresse toPuntoDiInteresse(){
        return new PuntoDiInteresse(
                this.getNome(),
                this.getDescrizione(),
                this.getDataCreazione(),
                this.getCreatore(),
                this.getCategoria(),
                this.getPosizione(),
                this.getComune()
        );
    }

    public CategoriaPOI getCategoria() {
        return categoria;
    }

    public Posizione getPosizione() {
        return posizione;
    }
}
