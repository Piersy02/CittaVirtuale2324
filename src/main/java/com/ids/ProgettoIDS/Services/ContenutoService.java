package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.*;
import com.ids.ProgettoIDS.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.Optional;

@Service
public class ContenutoService implements IContenutoService{
    private final ItinerarioRepository itinerarioRepository;
    private final PuntoDiInteresseRepository puntoDiInteresseRepository;
    private final EventoRepository eventoRepository;
    private final UtenteRepository utenteRepository;
    private final ComuneRepository comuneRepository;
    private final RuoliComuneRepository ruoliComuneRepository;
    private final ContenutoRepository contenutoRepository;

    public ContenutoService(ItinerarioRepository itinerarioRepository, PuntoDiInteresseRepository puntoDiInteresseRepository, EventoRepository eventoRepository, UtenteRepository utenteRepository, ComuneRepository comuneRepository, RuoliComuneRepository ruoliComuneRepository, ContenutoRepository contenutoRepository) {
        this.itinerarioRepository = itinerarioRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.eventoRepository = eventoRepository;
        this.utenteRepository = utenteRepository;
        this.comuneRepository = comuneRepository;
        this.ruoliComuneRepository = ruoliComuneRepository;
        this.contenutoRepository = contenutoRepository;
    }
    private StatoApprovazione approvazioneDefault(RuoloUtente ruolo) {
        return switch (ruolo) {
            case GESTORE_PIATTAFORMA, ANIMATORE, CURATORE,CONTRIBUTOR_AUTORIZZATO -> StatoApprovazione.APPROVATO;
            default -> StatoApprovazione.PENDING;
        };
    }

    private Optional<StatoApprovazione> approvazioneDefaultUtente(Integer id, Integer comuneID) {
        Utente utente = utenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Errore: l'utente non esiste"));

        comuneRepository.findById(comuneID).
                orElseThrow(() -> new IllegalArgumentException("Errore: il comune non esiste"));

        List<RuoloUtenteComune> ruoli = ruoliComuneRepository.cercaRuoliPerId(id);
        for (RuoloUtenteComune ruolo : ruoli) {
            if (ruolo.getComune().getID().equals(comuneID)) {
                return Optional.of(approvazioneDefault(ruolo.getRuolo()));
            }
        }

        return Optional.empty();
    }
    @Override
    public PuntoDiInteresse creaNuovoPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse) {
        if (puntoDiInteresse == null) {
            throw new NullPointerException("Errore: Il punto di iteresse è nullo");
        }
        puntoDiInteresse.setCreatore(utenteRepository.findById(puntoDiInteresse.getCreatore().getID())
                .orElseThrow(() -> new IllegalArgumentException("Erroe: Il creatore non è registrato nel sistema")));

        puntoDiInteresse.setComune(comuneRepository.findById(puntoDiInteresse.getComune().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: Il comune non è presente nel sistema")));

        puntoDiInteresse.setStatoApprovazione(approvazioneDefaultUtente(puntoDiInteresse.getCreatore().getID(),
                puntoDiInteresse.getComune().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: l'utente non ha i permessi sufficienti " +
                        "per creare un nuovo punto di interesse")));

        return puntoDiInteresseRepository.save(puntoDiInteresse);
    }
    @Override
    public Itinerario creaNuovoItinerario(Itinerario itinerario,  List<Integer> contenuti) {
        if (itinerario == null) {
            throw new IllegalArgumentException("Errore: l'itinerario è nullo");
        }

        itinerario.setCreatore(utenteRepository.findById(itinerario.getCreatore().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: il creatore non esiste")));

        itinerario.setComune(comuneRepository.findById(itinerario.getComune().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: il comune non esiste")));

        for (Integer id : contenuti)
        {
            Contenuto contenuto = contenutoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Errore: il contenuto non esiste"));

            itinerario.getContenuti().add(contenuto);
        }

        itinerario.setStatoApprovazione(approvazioneDefaultUtente(itinerario.getCreatore().getID(), itinerario.getComune().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: l'utente non ha i permessi sufficienti " +
                        "per creare un nuovo itinerario")));

        return itinerarioRepository.save(itinerario);
    }

    @Override
    public Evento creaNuovoEvento(Evento evento) {
        if (evento == null)
            throw new IllegalArgumentException("L'evento è nullo");

        evento.setComune(comuneRepository.findById(evento.getComune().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: il comune non esiste")));

        evento.setCreatore(utenteRepository.findById(evento.getCreatore().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: il creatore non esiste")));

        evento.setStatoApprovazione(approvazioneDefaultUtente(evento.getCreatore().getID(),
                evento.getComune().getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: l'utente non può approvare il contenuto")));

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

    @Override
    public Evento getEvento(int id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public Itinerario getItinerario(int id) {
        return itinerarioRepository.findById(id).orElse(null);
    }

    @Override
    public PuntoDiInteresse getPoi(int id) {
        return puntoDiInteresseRepository.findById(id).orElse(null);
    }

    @Override
    public void modificaEvento(Evento event) {
        eventoRepository.save(event);
    }

    @Override
    public void modificaPoi(PuntoDiInteresse puntoDiInteresse) {
        puntoDiInteresseRepository.save(puntoDiInteresse);
    }

    @Override
    public void modificaItinerario(Itinerario itinerario) {
        itinerarioRepository.save(itinerario);
    }

    @Override
    public void approvaItinerario(Integer id) {
        itinerarioRepository.findById(id).ifPresent(
                i -> {
                    i.setStatoApprovazione(StatoApprovazione.APPROVATO);
                    itinerarioRepository.save(i);
                }
        );
    }

    @Override
    public void approvaPuntoDiInteresse(Integer id) {
        puntoDiInteresseRepository.findById(id).ifPresent(
                p -> {
                    p.setStatoApprovazione(StatoApprovazione.APPROVATO);
                    puntoDiInteresseRepository.save(p);
                }
        );
    }

    @Override
    public void approvaEvento(Integer id) {
        eventoRepository.findById(id).ifPresent(
                e -> {
                    e.setStatoApprovazione(StatoApprovazione.APPROVATO);
                    eventoRepository.save(e);
                }
        );
    }
    public boolean verificaRuoliApprovazione(Integer idContenuto, Integer idUtente){
        Contenuto contenuto = contenutoRepository.findById(idContenuto)
                .orElseThrow(() -> new IllegalArgumentException("Errore: il contenuto non esiste"));
        RuoloUtente ruolo = ruoliComuneRepository.cercaRuoliPerId(idUtente)
                .stream()
                .filter(ruoloUtenteComune -> ruoloUtenteComune.getComune().getID().equals(
                        contenuto.getComune().getID()))
                .map(RuoloUtenteComune::getRuolo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Errore: l'utente non ha un ruole in questo comune"));

        return ruolo == RuoloUtente.CURATORE;
    }

    public void eliminaContenutiComune(Integer idComune) {
        List<Integer> lista = new ArrayList<>();

        contenutoRepository.findAll().forEach(c -> {
            if (c.getComune().getID().equals(idComune)) {
                lista.add(c.getID());
            }
        });
        lista.forEach(contenutoRepository::deleteById);
        lista.clear();
        ruoliComuneRepository.findAll().forEach(rcr -> {
            if (rcr.getComune().getID().equals(idComune)) {
                lista.add(rcr.getID());
            }
        });
        lista.forEach(ruoliComuneRepository::deleteById);
    }

}