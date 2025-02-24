package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.DTO.EventoDTO;
import com.ids.ProgettoIDS.Model.Evento;
import com.ids.ProgettoIDS.Services.ContenutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<EventoDTO> crea(@Valid @RequestBody EventoDTO evento) {
        Evento nuovoEvento = contenutoService.creaNuovoEvento(evento.toEvento());
        return ResponseEntity.ok(new EventoDTO(nuovoEvento));
    }

    @Override
    public ResponseEntity<EventoDTO> getById(@PathVariable("id") Integer id) {
        Evento evento = contenutoService.getEvento(id);
        return ResponseEntity.ok(new EventoDTO(evento));
    }

    @Override
    public ResponseEntity<List<EventoDTO>> getAll() {
        List<EventoDTO> eventiDTO = contenutoService.getAllEventi()
                .stream()
                .map(EventoDTO::new) //Converte ogni Evento in un DTO
                .toList();
        return ResponseEntity.ok(eventiDTO);
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