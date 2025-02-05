package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import com.ids.ProgettoIDS.Repositories.PuntoDiInteresseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntoDiInteresseService implements IPuntoDiInteresseService {

    private final PuntoDiInteresseRepository puntoDiInteresseRepository;

    public PuntoDiInteresseService(PuntoDiInteresseRepository puntoDiInteresseRepository) {
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }

    @Override
    public PuntoDiInteresse creaPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse) {
        return puntoDiInteresseRepository.save(puntoDiInteresse);
    }

    @Override
    public PuntoDiInteresse getPuntoDiInteresseById(Integer id) {
        return puntoDiInteresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Punto di Interesse non trovato con ID: " + id));
    }

    @Override
    public List<PuntoDiInteresse> getAllPuntiDiInteresse() {
        return (List<PuntoDiInteresse>) puntoDiInteresseRepository.findAll();
    }

    @Override
    public PuntoDiInteresse modificaPuntoDiInteresse(Integer id, PuntoDiInteresse nuovoPuntoDiInteresse) {
        Optional<PuntoDiInteresse> poiEsistente = puntoDiInteresseRepository.findById(id);

        if (poiEsistente.isPresent()) {
            PuntoDiInteresse poi = poiEsistente.get();
            poi.setNome(nuovoPuntoDiInteresse.getNome());
            poi.setDescrizione(nuovoPuntoDiInteresse.getDescrizione());
            poi.setCategoria(nuovoPuntoDiInteresse.getCategoria());
            poi.setPosizione(nuovoPuntoDiInteresse.getPosizione());
            return puntoDiInteresseRepository.save(poi);
        } else {
            throw new RuntimeException("Punto di Interesse non trovato con ID: " + id);
        }
    }

    @Override
    public void eliminaPuntoDiInteresse(Integer id) {
        if (!puntoDiInteresseRepository.existsById(id)) {
            throw new RuntimeException("Punto di Interesse non trovato con ID: " + id);
        }
        puntoDiInteresseRepository.deleteById(id);
    }
}
