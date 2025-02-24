package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.*;
import com.ids.ProgettoIDS.Repositories.*;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RicercaService implements IRicercaService{
    private final ContestRepository contestRepository;
    private final ItinerarioRepository itinerarioRepository;
    private final PuntoDiInteresseRepository puntoDiInteresseRepository;
    private final EventoRepository eventoRepository;
    private final ContenutoRepository contenutoRepository;
    private final RuoliComuneRepository ruoliComuneRepository;
    private final UtenteRepository utenteRepository;

    public RicercaService(ContestRepository contestRepository, ItinerarioRepository itinerarioRepository, PuntoDiInteresseRepository puntoDiInteresseRepository, EventoRepository eventoRepository, ContenutoRepository contenutoRepository, ComuneRepository comuneRepository, RuoliComuneRepository ruoliComuneRepository, UtenteRepository utenteRepository) {
        this.contestRepository = contestRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.eventoRepository = eventoRepository;
        this.contenutoRepository = contenutoRepository;
        this.ruoliComuneRepository = ruoliComuneRepository;
        this.utenteRepository = utenteRepository;
    }


    @Override
    public List<Contest> ricercaContest(String nome, Date dataInizio, Date dataFine, String tipo) {
        return contestRepository.ricercaContest(nome, dataInizio, dataFine, tipo);
    }

    @Override
    public List<Contenuto> ricercaContenuto(String nome, String descrizione, Date dataCreazione) {
        return contenutoRepository.cercaPerNomeDescrizioneData(nome, descrizione, dataCreazione);
    }

    @Override
    public List<Itinerario> ricercaItinerario(String nome, String descrizione, Date dataCreazione, int livelloDifficolta) {
        return itinerarioRepository.ricercaItinerario(nome, descrizione, dataCreazione, livelloDifficolta);
    }

    @Override
    public List<PuntoDiInteresse> ricercaPuntoDiInteresse(String nome, String descrizione, CategoriaPOI categoria, Posizione luogo) {
        return puntoDiInteresseRepository.ricercaPoi(nome, descrizione, categoria, luogo);
    }

    @Override
    public List<Evento> ricercaEvento(String nome, String descrizione, Date dataInizio, Date dataFine) {
        return eventoRepository.ricercaEvento(
                nome, descrizione, dataInizio, dataFine);
    }

    @Override
    public List<Utente> ricercaUtenteRuolo(int ruolo) {
        return ruoliComuneRepository.cercaUtenteRuolo(RuoloUtente.values()[ruolo]);
    }

    @Override
    public List<Utente> ricercaUtenteEmail(String email) {
        return utenteRepository.ricercaPerEmail(email);
    }
}
