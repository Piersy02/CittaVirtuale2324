package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Comune;
import com.ids.ProgettoIDS.Model.DTO.ComuneDTO;
import com.ids.ProgettoIDS.Services.ComuneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comune")
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

        return ResponseEntity.ok(comuneService.getById(id));
    }

    @Override
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(comuneService.getAll());
    }

    @PutMapping("/comune/{id}")
    public ResponseEntity<?> modifica(@RequestBody ComuneDTO comune, @PathVariable Integer id) {
        try {
            Comune comuneAggiornato = comuneService.modificaComune(comune.toComune(), id);
            return ResponseEntity.ok(comuneAggiornato);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Errore: comune non trovato");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno");
        }
    }


    @Override
    public ResponseEntity<?> elimina(@PathVariable("id") Integer id) {
        comuneService.elimina(id);
        return ResponseEntity.ok("Comune eliminato correttamente");
    }
}
