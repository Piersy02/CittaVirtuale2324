package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Model.Itinerario;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import com.ids.ProgettoIDS.Repositories.EventoRepository;
import com.ids.ProgettoIDS.Repositories.ItinerarioRepository;
import com.ids.ProgettoIDS.Repositories.PuntoDiInteresseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContenutoService implements IContenutoService{
    private final ItinerarioRepository itinerarioRepository;
    private final PuntoDiInteresseRepository puntoDiInteresseRepository;
    private final EventoRepository eventoRepository;

    public ContenutoService(ItinerarioRepository itinerarioRepository, PuntoDiInteresseRepository puntoDiInteresseRepository, EventoRepository eventoRepository) {
        this.itinerarioRepository = itinerarioRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.eventoRepository = eventoRepository;
    }
    @Override
    public PuntoDiInteresse creaNuovoPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse) {
        return puntoDiInteresseRepository.save(puntoDiInteresse);
    }

    @Override
    public Itinerario creaNuovoItinerario(Itinerario itinerario) {
        return itinerarioRepository.save(itinerario);
    }

    @Override
    public Evento creaNuovoEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public List<Evento> getAllEventi() {
        return StreamSupport.stream(eventoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Itinerario> getAllItinerari() {
        return StreamSupport.stream(itinerarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<PuntoDiInteresse> getAllPoi() {
        return StreamSupport.stream(puntoDiInteresseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
