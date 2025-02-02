package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.DTO.EventoDTO;
import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Services.ContenutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController implements IController<EventoDTO, Integer> {
    private final ContenutoService contenutoService;

    public EventoController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
    }
    @Override
    public ResponseEntity<Evento> crea(@Valid EventoDTO evento) {
        Evento nuovoEvento = contenutoService.creaNuovoEvento(evento.toEvento());
        return ResponseEntity.ok(nuovoEvento);
    }

    @Override
    public ResponseEntity<Evento> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(contenutoService.getEvento(id));
    }

    @Override
    public ResponseEntity<List<Evento>> getAll() {
        return ResponseEntity.ok(contenutoService.getAllEventi());
    }

    @Override
    public ResponseEntity<?> modifica(EventoDTO  evento, Integer id) {
        contenutoService.modificaEvento(evento.toEvento());
        return ResponseEntity.ok("{}");
    }

    @Override
    public ResponseEntity<?> elimina(@PathVariable("id") Integer id) {
        return ResponseEntity.badRequest().body("Non Implementato");
    }
}