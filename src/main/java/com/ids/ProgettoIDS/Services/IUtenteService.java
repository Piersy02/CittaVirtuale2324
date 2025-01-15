package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Utente;

import java.util.List;

public interface IUtenteService {
    /**
     * Crea un nuovo utente
     * @param utente l'utente da creare
     * @return il nuovo utente aggiunto al repository
     */
    Utente creaUtente(Utente utente);

    /**
     * Restituisce tutti gli utenti presenti nel repository
     * @return la lista di tutti gli utenti
     */
    List<Utente> getAll();

    /**
     * Restituisce uno specifico utente
     * @param id l'ID dell'utente che si vuole ottenere
     * @return l'utente in base al suo id
     */
    Utente getUtente(int id);
}