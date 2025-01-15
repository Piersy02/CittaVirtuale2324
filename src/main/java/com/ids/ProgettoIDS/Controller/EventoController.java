package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Services.ContenutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController implements IController<Evento, Integer> {
    private final ContenutoService contenutoService;

    public EventoController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
    }
    @Override
    public ResponseEntity<Evento> crea(Evento entity) {
        Evento nuovoEvento = contenutoService.creaNuovoEvento(entity);
        return ResponseEntity.ok(nuovoEvento);
    }

    @Override
    public ResponseEntity<Evento> getById(Integer id) {
        return ResponseEntity.ok(contenutoService.getEvento(Math.toIntExact(id))); //Da rivedere
    }

    @Override
    public ResponseEntity<List<Evento>> getAll() {
        return ResponseEntity.ok(contenutoService.getAllEventi());
    }

    @Override
    public ResponseEntity<?> modifica(Evento  entity) {
        contenutoService.modificaEvento(entity);
        return ResponseEntity.ok("{}");
    }

    @Override
    public ResponseEntity<?> elimina(Integer aLong) {
        return null;//TODO Da Implementare
    }
}