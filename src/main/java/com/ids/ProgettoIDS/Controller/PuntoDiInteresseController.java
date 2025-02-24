package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.DTO.PuntoDiInteresseDTO;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import com.ids.ProgettoIDS.Services.PuntoDiInteresseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/punto-di-interesse")
@CrossOrigin(origins = "*")
public class PuntoDiInteresseController {

    private final PuntoDiInteresseService puntoDiInteresseService;

    public PuntoDiInteresseController(PuntoDiInteresseService puntoDiInteresseService) {
        this.puntoDiInteresseService = puntoDiInteresseService;
    }

    /** Creazione di un Punto di Interesse **/
    @PostMapping
    public ResponseEntity<PuntoDiInteresseDTO> crea(@Valid @RequestBody PuntoDiInteresseDTO puntoDiInteresseDTO) {
        PuntoDiInteresse nuovoPuntoDiInteresse = puntoDiInteresseService.creaPuntoDiInteresse(puntoDiInteresseDTO.toPuntoDiInteresse());
        return ResponseEntity.ok(new PuntoDiInteresseDTO(nuovoPuntoDiInteresse));
    }

    /** Recupero di un Punto di Interesse per ID **/
    @GetMapping("/{id}")
    public ResponseEntity<PuntoDiInteresseDTO> getById(@PathVariable Integer id) {
        PuntoDiInteresse poi = puntoDiInteresseService.getPuntoDiInteresseById(id);
        return ResponseEntity.ok(new PuntoDiInteresseDTO(poi));
    }

    /** Recupero di tutti i Punti di Interesse **/
    @GetMapping("/getAll")
    public ResponseEntity<List<PuntoDiInteresseDTO>> getAll() {
        List<PuntoDiInteresseDTO> pois = puntoDiInteresseService.getAllPuntiDiInteresse()
                .stream()
                .map(PuntoDiInteresseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pois);
    }

    /** Modifica di un Punto di Interesse **/
    @PutMapping("/{id}")
    public ResponseEntity<PuntoDiInteresseDTO> modifica(@PathVariable Integer id, @Valid @RequestBody PuntoDiInteresseDTO puntoDiInteresseDTO) {
        PuntoDiInteresse aggiornato = puntoDiInteresseService.modificaPuntoDiInteresse(id, puntoDiInteresseDTO.toPuntoDiInteresse());
        return ResponseEntity.ok(new PuntoDiInteresseDTO(aggiornato));
    }

    /** Eliminazione di un Punto di Interesse **/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimina(@PathVariable Integer id) {
        puntoDiInteresseService.eliminaPuntoDiInteresse(id);
        return ResponseEntity.ok("Punto di Interesse eliminato con successo.");
    }
}
