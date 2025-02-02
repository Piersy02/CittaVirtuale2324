package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.*;
import com.ids.ProgettoIDS.Repositories.ContenutoRepository;
import com.ids.ProgettoIDS.Repositories.ContestRepository;
import com.ids.ProgettoIDS.Repositories.NotificaRepository;
import com.ids.ProgettoIDS.Repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ContestService implements IContestService{

    private final ContestRepository contestRepository;
    private final RuoliComuneService ruoliComuneService;
    private final ComuneService comuneService;
    private final UtenteService utenteService;
    private final ContenutoRepository contenutoRepository;
    private final UtenteRepository utenteRepository;
    private final NotificaRepository notificaRepository;

    public ContestService(ContestRepository contestRepository, RuoliComuneService ruoliComuneService,
                          ComuneService comuneService, UtenteService utenteService,
                          ContenutoService contenutoService, ContenutoRepository contenutoRepository,
                          UtenteRepository utenteRepository, NotificaRepository notificaRepository) {
        this.contestRepository = contestRepository;
        this.ruoliComuneService = ruoliComuneService;
        this.comuneService = comuneService;
        this.utenteService = utenteService;
        this.contenutoRepository = contenutoRepository;
        this.utenteRepository = utenteRepository;
        this.notificaRepository = notificaRepository;
    }

    @Override
    public Contest creaContest(Contest contest, List<Integer> contenuti) {
        if (contest == null)
        {
            throw new IllegalArgumentException("Errore: contest nullo");
        }

        if (ruoliComuneService.getRuolo(contest.getCreatore().getID(), contest.getComune().getID())
                != RuoloUtente.ANIMATORE) {
            throw new IllegalStateException("Errore: Devi essere un animatore");
        }

        contest.setComune(comuneService.getById
                (contest.getComune().getID()));
        contest.setCreatore(utenteService.getUtente(contest.getCreatore().getID()));

        contenuti.forEach(c -> {
            contest.iscrizione(contenutoRepository.findById(c)
                    .orElseThrow(() -> new IllegalArgumentException("Errore: il contenuto non esiste ")));
        });

        return contestRepository.save(contest);
    }
    @Override
    public Contest getContest(Integer id) {
        return this.contestRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contest> getAllContest() {
        return StreamSupport.stream(contestRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public void modificaContest(Contest contest, List<Integer> contenuti) {
        if (contest == null) {
            throw new IllegalArgumentException("Errore: Contest Nullo");
        }

        Contest original = contestRepository.findById(contest.getID())
                .orElseThrow(() -> new IllegalArgumentException("Errore: Contest non esiste"));

        for (Integer id : contenuti)
        {
            Contenuto cont = this.contenutoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Errore: Contest non esiste"));
            contest.getContenuti().add(cont);
        }

        contest.setComune(original.getComune());
        contest.setCreatore(original.getCreatore());

        contestRepository.save(contest);
    }

    @Override
    public void iscrizioneContenuto(Integer idContenuto, Integer idContest) {
        Contest contest = contestRepository.findById(idContest)
                .orElseThrow(() -> new IllegalArgumentException("Errore: il contest non esiste"));

        Contenuto content = contenutoRepository.findById(idContenuto)
                .orElseThrow(() -> new IllegalArgumentException("Errore: il contenuto non esiste"));

        contest.iscrizione(content);
        contestRepository.save(contest);
    }

    @Override
    public void chiusuraContest(Integer idContest, Integer idContenutoVincitore) {
        Contest contest = contestRepository.findById(idContest)
                .orElseThrow(() -> new IllegalArgumentException("Errore: Il contest non esiste"));

        Contenuto contenutoVincitore = contenutoRepository.findById(idContenutoVincitore)
                .orElseThrow(() -> new IllegalArgumentException("Errore: Il contenuto non esiste"));

        // lista degli utenti che non hanno vinto il contest
        Set<Integer> perdenti = contest.chiusuraContest(idContenutoVincitore);

        contestRepository.save(contest);

        perdenti.remove(contenutoVincitore.getCreatore().getID());

        // invia notifica risultati ai partecipenti
        perdenti.forEach(idPerdenti -> {
            Utente utente = utenteRepository.findById(idPerdenti)
                    .orElseThrow(() -> new IllegalArgumentException("Errore: l'utente non esiste"));

            Notifica notifica = new Notifica(String.format("Mi dispiace! " + utente.getUsername()),
                    String.format("Purtroppo non hai vinto questo contest: ") + contest.getNome());
            notifica = notificaRepository.save(notifica);

            utente.aggiungiNotifica(notifica);

            utenteRepository.save(utente);
        });

        // utente vincitore
        Utente vincitore = contenutoVincitore.getCreatore();
        Notifica notifica = new Notifica(String.format("Complimenti ! " + vincitore.getUsername()),
                String.format("Hai vinto questo contest: ") + contest.getNome());
        notifica = notificaRepository.save(notifica);

        vincitore.aggiungiNotifica(notifica);
        utenteRepository.save(vincitore);
    }

}
