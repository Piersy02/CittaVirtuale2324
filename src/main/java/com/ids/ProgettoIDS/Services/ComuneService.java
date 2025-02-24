package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Repositories.ComuneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComuneService implements IComuneService {
    private  final ContenutoService contenutoService;
    private final ComuneRepository comuneRepository;
    public ComuneService(ContenutoService contenutoService, ComuneRepository comuneRepository) {
        this.contenutoService = contenutoService;
        this.comuneRepository = comuneRepository;
    }

    @Override
    public Comune creaComune(Comune comune) {
        return comuneRepository.save(comune);
    }

    @Override
    public List<Comune> getAll() {

        return (List<Comune>) comuneRepository.findAll();
    }
    @Override
    public Comune getById(Integer id) {
        return comuneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Errore: comune non trovato"));
    }

    @Override
    @Transactional
    public Comune modificaComune(Comune comune, Integer id) {
        Comune existingComune = comuneRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Errore: comune non trovato"));

        // Aggiorna solo i campi necessari senza sovrascrivere tutto
        existingComune.setNome(comune.getNome());
        existingComune.setDescrizione(comune.getDescrizione());
        existingComune.setPosizione(comune.getPosizione());
        existingComune.setArea(comune.getArea());
        existingComune.setDataFondazione(comune.getDataFondazione());

        return comuneRepository.save(existingComune);
    }

    @Override
    public void elimina(Integer id) {
        comuneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Errore: comune non trovato"));

        contenutoService.eliminaContenutiComune(id);
        comuneRepository.deleteById(id);
    }
}
