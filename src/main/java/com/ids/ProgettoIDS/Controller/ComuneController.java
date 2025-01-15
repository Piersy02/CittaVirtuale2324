package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Services.ComuneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coumune")
public class ComuneController implements  IController<Comune, Integer>{
    private final ComuneService comuneService;

    public ComuneController(ComuneService comuneService) {
        this.comuneService = comuneService;
    }

    @Override
    public ResponseEntity<?> crea(@RequestBody Comune comune) {
        Comune nuovoComune= comuneService.creaComune(comune);
        return ResponseEntity.ok(nuovoComune);
    }
    @Override
    public ResponseEntity<?> getById(Integer integer) {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> modifica(Comune entity) {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> elimina(Integer integer) {
        return null;//TODO Da Implementare
    }
}
