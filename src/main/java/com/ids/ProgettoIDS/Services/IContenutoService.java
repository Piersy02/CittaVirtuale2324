package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Model.Itinerario;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface IContenutoService {

    PuntoDiInteresse creaNuovoPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse);
    Itinerario creaNuovoItinerario (Itinerario itinerario);
    Evento creaNuovoEvento(Evento evento);

    List<Evento> getAllEventi();

    List<Itinerario> getAllItinerari();

    List<PuntoDiInteresse> getAllPoi();

}
