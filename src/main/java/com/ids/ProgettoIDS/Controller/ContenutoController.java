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
    public ContenutoController(ContenutoService contenutoService) {this.contenutoService = contenutoService;}

    @PutMapping("/approva/evento/{idEvento}")
    public ResponseEntity<?> approvaEvento(@PathVariable Integer idEvento, @RequestBody Integer utenterId)
    {
        if (contenutoService.verificaRuoliApprovazione(idEvento, utenterId))
            return ResponseEntity.badRequest().body("Non hai i permessi per approvare il contenuto");

        contenutoService.approvaEvento(idEvento);
        return ResponseEntity.ok().body("Evento approvato con successo");
    }
    @PutMapping("/approva/poi/{idPoi}")
    public ResponseEntity<?> approvaPuntoDiInteresse(@PathVariable Integer idPoi, @RequestBody Integer idUtente){
        if (contenutoService.verificaRuoliApprovazione(idPoi, idUtente))
            return ResponseEntity.badRequest().body("Non hai i permessi per approvare il contenuto");
        contenutoService.approvaPuntoDiInteresse(idPoi);
        return ResponseEntity.ok().body("Punto di interesse approvato con successo");
    }

    @PutMapping("/approva/itinerario/{idItinerario}")
    public ResponseEntity<?> approvaItinerario(@PathVariable Integer idItinerario, @RequestBody Integer idUtente)
    {
        if (contenutoService.verificaRuoliApprovazione(idItinerario, idUtente))
            return ResponseEntity.badRequest().body("Non hai i permessi per approvare il contenuto");
        contenutoService.approvaItinerario(idItinerario);
        return ResponseEntity.ok().body("itinerario approvato con successo");
    }
}