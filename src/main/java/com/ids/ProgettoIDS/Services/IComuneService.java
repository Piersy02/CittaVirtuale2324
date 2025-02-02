package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Comune;
import java.util.List;

public interface IComuneService {
    /**
     * Crea un nuovo comune
     * @param comune il comune da creare
     * @return il nuoco comune aggiunto al repository
     */
    Comune creaComune(Comune comune);
    /**
     * Ritorna tutti i comuni registrati
     * @return tutti i comuni presenti nel repository
     */
    List<Comune> getAll();

    /**
     * Restituisce il comune corrispondente all'id passato
     * @param id l'id del comune che si vuole ottenere
     * @return il comune dell'id corrispondente
     */
    Comune getById(Integer id);

    /**
     * Modifica un comune esistente
     * @param comune le informazioni che si voglione modificare del comune
     * @param id l'id del comune da modificare
     * @return il comune modificato
     */
    Comune modificaComune(Comune comune, Integer id);

    /**
     * Elimina un comune
     * @param id l'id del comune da eliminare
     */
    void elimina(Integer id);
}