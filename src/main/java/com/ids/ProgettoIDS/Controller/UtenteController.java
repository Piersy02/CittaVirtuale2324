package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.DTO.CambioRuoloDTO;
import com.ids.ProgettoIDS.Model.DTO.UtenteDTO;
import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Services.RuoliComuneService;
import com.ids.ProgettoIDS.Services.UtenteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/utenti")
public class UtenteController implements IController<UtenteDTO, Integer> {
    private final UtenteService utenteService;
    private final RuoliComuneService ruoliComuneService;

    public UtenteController(UtenteService utenteService,RuoliComuneService ruoliComuneService) {
        this.utenteService = utenteService;
        this.ruoliComuneService = ruoliComuneService;
    }

    @Override
    public ResponseEntity<?> crea(@Valid UtenteDTO utente)
    {
        Utente nuovoUtente= utenteService.creaUtente(utente.toUtente(), utente.getComune(), utente.getRuolo());
        return ResponseEntity.ok(nuovoUtente);
    }
    @Override
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(utenteService.getAll());
    }

    @Override
    public ResponseEntity<?> modifica(UtenteDTO utente, Integer id) {
        return ResponseEntity.badRequest().body("Funzionalità non ancora implementata");
    }

    @Override
    public ResponseEntity<?> elimina(@PathVariable("id") Integer id) {
        return ResponseEntity.badRequest().body("Non implementato");
    }

    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(utenteService.getUtente(id));
    }

    @PutMapping("/ruolo")
    public ResponseEntity<?> cambiaRuolo(@Valid @RequestBody CambioRuoloDTO dto) {
        try {
            if (ruoliComuneService.getRuolo(dto.getIdUtente(), dto.getComuneId()) == dto.getNuovoRuolo()) {
                return ResponseEntity.badRequest().body("L'utente ha già quel ruolo");
            }

            ruoliComuneService.setRuolo(dto.getIdUtente(), dto.getComuneId(), dto.getNuovoRuolo());

            return ResponseEntity.ok().body("cambio ruolo avvenuto");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
