package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Repositories.ComuneRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        return StreamSupport.stream(comuneRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    @Override
    public Comune getById(Integer id) {
        return comuneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Errore: comune non trovato"));
    }

    @Override
    public Comune modificaComune(Comune comune, Integer id) {

        comuneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Errore: comune non trovato"));
        comune.setID(id);
        comuneRepository.save(comune);

        return comune;
    }

    @Override
    public void elimina(Integer id) {
        comuneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Errore: comune non trovato"));

        contenutoService.eliminaContenutiComune(id);
        comuneRepository.deleteById(id);
    }
}
