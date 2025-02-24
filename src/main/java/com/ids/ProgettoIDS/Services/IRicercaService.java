package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.*;


public interface IRicercaService {
    List<Contest> ricercaContest(String nome, Date dataInizio, Date dataFine, String tipo);
    List<Contenuto> ricercaContenuto(String nome, String descrizione, Date dataCreazione);
    List<Itinerario> ricercaItinerario(String nome, String descrizione, Date dataCreazione, int livelloDifficolta);
    List<PuntoDiInteresse> ricercaPuntoDiInteresse(String nome, String descrizione, CategoriaPOI categoria, Posizione luogo);
    List<Evento> ricercaEvento(String nome, String descrizione, Date dataInizio, Date dataFine);
    List<Utente> ricercaUtenteRuolo(int ruolo);
    List<Utente> ricercaUtenteEmail(String email);
}
