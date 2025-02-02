package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Model.DTO.ComuneDTO;
import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Services.ComuneService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coumune")
public class ComuneController implements  IController<ComuneDTO, Integer>{
    private final ComuneService comuneService;

    public ComuneController(ComuneService comuneService) {
        this.comuneService = comuneService;
    }

    @Override
    public ResponseEntity<?> crea(@Valid @RequestBody ComuneDTO comune) {
        Comune nuovoComune= comuneService.creaComune(comune.toComune());
        return ResponseEntity.ok(nuovoComune);
    }
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(comuneService.getAll());
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(comuneService.getAll());
    }

    @Override
    public ResponseEntity<?> modifica(ComuneDTO comune, Integer id) {

        return ResponseEntity.ok(comuneService.modificaComune(comune.toComune(),id));
    }

    @Override
    public ResponseEntity<?> elimina(@PathVariable("id") Integer id) {
        comuneService.elimina(id);
        return ResponseEntity.ok("Comune eliminato correttamente");
    }
}
