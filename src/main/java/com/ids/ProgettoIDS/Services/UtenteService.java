package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UtenteService implements IUtenteService{
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public Utente creaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public List<Utente> getAll() {
        return StreamSupport.stream(utenteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    @Override
    public Utente getUtente(int id) {
        return utenteRepository.findById(id).orElse(null);
    }
}