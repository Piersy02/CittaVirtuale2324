package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Itinerario;
import com.ids.ProgettoIDS.Services.ContenutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itinerario")
public class ItinerarioController implements IController<Itinerario, Integer> {
    private final ContenutoService contenutoService;

    public ItinerarioController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
    }
    @Override
    public ResponseEntity<Itinerario> crea(Itinerario entity) {
        Itinerario nuovoItinerario = contenutoService.creaNuovoItinerario(entity);
        return ResponseEntity.ok(nuovoItinerario);
    }

    @Override
    public ResponseEntity<Itinerario> getById(Integer id) {
        return ResponseEntity.ok(contenutoService.getItinerario(Math.toIntExact(id))); //Da migliorare
    }

    @Override
    public ResponseEntity<List<Itinerario>> getAll() {
        return ResponseEntity.ok(contenutoService.getAllItinerari());
    }

    @Override
    public ResponseEntity<?> modifica(Itinerario entity) {
        contenutoService.modificaItinerario(entity);
        return ResponseEntity.ok("{}");
    }

    @Override
    public ResponseEntity<?> elimina(Integer aLong) {
        return null;//TODO Da Implementare
    }
}
