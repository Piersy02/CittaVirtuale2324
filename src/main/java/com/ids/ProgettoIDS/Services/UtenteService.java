package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.RuoloUtente;
import com.ids.ProgettoIDS.Model.RuoloUtenteComune;
import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Repositories.ComuneRepository;
import com.ids.ProgettoIDS.Repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UtenteService implements IUtenteService{
    private final UtenteRepository utenteRepository;
    private final ComuneRepository comuneRepository;
    private final RuoliComuneService ruoliComuneService;

    public UtenteService(UtenteRepository utenteRepository, ComuneRepository comuneRepository, RuoliComuneService ruoliComuneService) {
        this.utenteRepository = utenteRepository;
        this.comuneRepository = comuneRepository;
        this.ruoliComuneService = ruoliComuneService;
    }

    @Override
    public Utente creaUtente(Utente utente, Integer IdComune, int ruolo) {
        if (utenteRepository.esisteUtente(utente.getUsername(), utente.getEmail()))
            throw new IllegalArgumentException("L'utente è già presente nella piattaforma");
        if (!this.comuneRepository.existsById(IdComune))
            throw new IllegalArgumentException("Il comune non esiste");
        if (ruolo < 0 || ruolo > RuoloUtente.values().length){
            throw new IllegalArgumentException("Il ruolo non esiste");
        }
        Utente nuovoUtente =  utenteRepository.save(utente);
        ruoliComuneService.creaNuovoRuolo((new RuoloUtenteComune(
                comuneRepository.findById(IdComune).get(), RuoloUtente.values()[ruolo], nuovoUtente)));
        return nuovoUtente;
    }

    @Override
    public List<Utente> getAll() {
        return StreamSupport.stream(utenteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    @Override
    public Utente getUtente(Integer id) {
        return utenteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminaUtente(Integer id) {
        if(!utenteRepository.existsById(id))
            throw new IllegalArgumentException("L'utente non esiste");
        utenteRepository.delete((utenteRepository.findById(id).get()));

    }
}