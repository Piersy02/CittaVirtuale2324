package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Model.Itinerario;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;

import java.util.List;


public interface IContenutoService {

    PuntoDiInteresse creaNuovoPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse);
    Itinerario creaNuovoItinerario (Itinerario itinerario,List<Integer> contenuti);
    Evento creaNuovoEvento(Evento evento);
    List<Evento> getAllEventi();
    List<Itinerario> getAllItinerari();
    List<PuntoDiInteresse> getAllPoi();
    Evento getEvento(int id);
    Itinerario getItinerario(int id);
    PuntoDiInteresse getPoi(int id);
    void modificaEvento(Evento event);
    void modificaPoi(PuntoDiInteresse pointOfInterest);
    void modificaItinerario(Itinerario itinerary);
    void approvaItinerario(Integer id);
    void approvaPuntoDiInteresse(Integer id);
    void approvaEvento(Integer id);
}