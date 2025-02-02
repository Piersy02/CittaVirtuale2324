package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.RuoloUtente;
import com.ids.ProgettoIDS.Model.RuoloUtenteComune;

public interface IRuoliComuneService {
    /**
     * Crea un nuovo ruolo per un utente all'interno di un comune
     * @return il nuovo ruolo dell'utente all'interno del comune
     */
    RuoloUtenteComune creaNuovoRuolo(RuoloUtenteComune ruoloComune);
    RuoloUtente getRuolo(Integer idUtente, Integer idComune);
    void setRuolo(Integer idUtente, Integer idComune, RuoloUtente ruoloUtente);
}
