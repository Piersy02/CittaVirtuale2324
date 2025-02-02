package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.DTO.ItinerarioDTO;
import com.ids.ProgettoIDS.Model.Itinerario;
import com.ids.ProgettoIDS.Services.ContenutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itinerario")
public class ItinerarioController implements IController<ItinerarioDTO, Integer> {
    private final ContenutoService contenutoService;

    public ItinerarioController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
    }
    @Override
    public ResponseEntity<Itinerario> crea(@Valid ItinerarioDTO itinerario) {
        Itinerario nuovoItinerario = contenutoService.creaNuovoItinerario(itinerario.toItinerario(), itinerario.getContenuti());
        return ResponseEntity.ok(nuovoItinerario);
    }

    @Override
    public ResponseEntity<Itinerario> getById(Integer id) {
        return ResponseEntity.ok(contenutoService.getItinerario(Math.toIntExact(id)));
    }

    @Override
    public ResponseEntity<List<Itinerario>> getAll() {
        return ResponseEntity.ok(contenutoService.getAllItinerari());
    }

    @Override
    public ResponseEntity<?> modifica(ItinerarioDTO entity, Integer id) {
        contenutoService.modificaItinerario(entity.toItinerario());
        return ResponseEntity.ok("{}");
    }

    @Override
    public ResponseEntity<?> elimina(@PathVariable("id") Integer id) {
        return ResponseEntity.badRequest().body("Non Implementato");
    }
}
