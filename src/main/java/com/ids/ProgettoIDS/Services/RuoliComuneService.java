package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.RuoloUtente;
import com.ids.ProgettoIDS.Model.RuoloUtenteComune;
import com.ids.ProgettoIDS.Repositories.RuoliComuneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuoliComuneService implements IRuoliComuneService{
    private final RuoliComuneRepository ruoliComuneRepository;
    private final ComuneService comuneService;

    public RuoliComuneService(RuoliComuneRepository ruoliComuneRepository, ComuneService comuneService) {
        this.ruoliComuneRepository = ruoliComuneRepository;
        this.comuneService = comuneService;
    }
    @Override
    public RuoloUtenteComune creaNuovoRuolo(RuoloUtenteComune ruoloComune) {
        for (RuoloUtenteComune r : ruoliComuneRepository.findAll()) {
            if (r.getComune().equals(ruoloComune.getComune()) && r.getUtente().equals(ruoloComune.getUtente()))
                throw new IllegalArgumentException(("L'utente ha già questo ruolo all'intero del comune"));
        }
        return ruoliComuneRepository.save(ruoloComune);
    }
    @Override
    public RuoloUtente getRuolo(Integer idUtente, Integer idComune) {
        List<RuoloUtenteComune> ruoli = ruoliComuneRepository.cercaRuoliPerId(idUtente);

        for (RuoloUtenteComune i : ruoli) {
            if (i.getComune().getID().equals(idComune)) {
                comuneService.getById(idComune);

                return i.getRuolo();
            }
        }

        throw new IllegalArgumentException("L'utente non ha i permessi in questo comune");
    }
    @Override
    public void setRuolo(Integer idUtente, Integer idComune, RuoloUtente ruoloUtente) {
        List<RuoloUtenteComune> ruoli = ruoliComuneRepository.cercaRuoliPerId(idUtente);

        for (RuoloUtenteComune i : ruoli) {
            if (i.getComune().getID().equals(idComune)) {
                comuneService.getById(idComune);
                i.setRuolo(ruoloUtente);
                ruoliComuneRepository.save(i);
                return;
            }
        }

        throw new IllegalArgumentException("L'utente non ha un ruolo in questo comune");
    }
}
