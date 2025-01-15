package com.ids.ProgettoIDS.Services;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Repositories.ComuneRepository;
import org.springframework.stereotype.Service;

@Service
public class ComuneService implements IComuneService {

    private final ComuneRepository comuneRepository;
    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }

    @Override
    public Comune creaComune(Comune comune) {
        return comuneRepository.save(comune);
    }
}
