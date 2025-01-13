package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Model.Itinerario;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import com.ids.ProgettoIDS.Services.ContenutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenuto")
public class ContenutoController {
    private final ContenutoService contenutoService;

    public ContenutoController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
    }

    @PostMapping("/add/itinerario")
    public ResponseEntity<Itinerario> creaItinerario(@RequestBody Itinerario itinerario) {
        Itinerario nuovoItinerario = contenutoService.creaNuovoItinerario(itinerario);
        return ResponseEntity.ok(nuovoItinerario);
    }

    @PostMapping("/add/evento")
    public ResponseEntity<Evento> creaEvento(@RequestBody Evento evento) {
        Evento nuovoEvento = contenutoService.creaNuovoEvento(evento);
        return ResponseEntity.ok(nuovoEvento);
    }

    @PostMapping("/add/poi")
    public ResponseEntity<PuntoDiInteresse> creaPoi(@RequestBody PuntoDiInteresse puntoDiInteresse) {
        PuntoDiInteresse nuovoPoi = contenutoService.creaNuovoPuntoDiInteresse(puntoDiInteresse);
        return ResponseEntity.ok(nuovoPoi);
    }

    @GetMapping("/getAll/poi")
    public ResponseEntity<List<PuntoDiInteresse>> getAllPoi() {
        return ResponseEntity.ok(contenutoService.getAllPoi());
    }

    @GetMapping("/getAll/eventi")
    public ResponseEntity<List<Evento>> getAllEventi() {
        return ResponseEntity.ok(contenutoService.getAllEventi());
    }

    @GetMapping("/getAll/itinerari")
    public ResponseEntity<List<Itinerario>> getAllItinerari() {
        return ResponseEntity.ok(contenutoService.getAllItinerari());
    }
}