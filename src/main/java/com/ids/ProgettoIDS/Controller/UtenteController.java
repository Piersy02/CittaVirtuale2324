package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Services.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UtenteController implements IController<Utente, Integer> {
    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Override
    public ResponseEntity<?> crea(@RequestBody Utente utente)
    {
        Utente nuovoUtente= utenteService.creaUtente(utente);
        return ResponseEntity.ok(nuovoUtente);
    }
    @Override
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(utenteService.getAll());
    }

    @Override
    public ResponseEntity<?> modifica(Utente entity) {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> elimina(Integer integer) {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> getById(@PathVariable("ID") Integer ID)
    {
        return ResponseEntity.ok(utenteService.getUtente(ID));
    }

}
