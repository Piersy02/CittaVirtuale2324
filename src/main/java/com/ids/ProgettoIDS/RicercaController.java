package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.*;
import com.ids.ProgettoIDS.Services.RicercaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ricerca")
public class RicercaController {
    private final RicercaService ricercaService;
    public RicercaController(RicercaService ricercaService) {
        this.ricercaService = ricercaService;
    }
    @GetMapping("/contenuto")
    public List<Contenuto> ricercaContenuto (@RequestParam(required = false) String nome,
                                             @RequestParam(required = false) String descrizione,
                                             @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataCreazione){
        return ricercaService.ricercaContenuto(nome, descrizione, dataCreazione);
    }

    @GetMapping("/itinerario")
    public List<Itinerario> ricercaItinerario(@RequestParam(required = false) String nome,
                                              @RequestParam(required = false) String descrizione,
                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataCreazione,
                                              @RequestParam(required = false) int livelloDifficolta){
        return ricercaService.ricercaItinerario(nome, descrizione, dataCreazione, livelloDifficolta);
    }

    @GetMapping("/contest")
    public List<Contest> ricercaContest(@RequestParam(required = false) String nome,
                                        @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInizio,
                                        @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataFine,
                                        @RequestParam(required = false) String tipo) {
        return ricercaService.ricercaContest(nome, dataInizio, dataFine, tipo);
    }

    @GetMapping("/poi")
    public List<PuntoDiInteresse> ricercaPuntDiInteresse(@RequestParam(required = false) String nome,
                                                         @RequestParam(required = false) String descrizione,
                                                         @RequestParam(required = false) CategoriaPOI categoria,
                                                         @RequestParam(required = false) Posizione posizione) {
        return ricercaService.ricercaPuntoDiInteresse(nome, descrizione, categoria, posizione);
    }

    @GetMapping("/evento")
    public List<Evento> ricercaEvento(@RequestParam(required = false) String nome,
                                      @RequestParam(required = false) String descrizione,
                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInizio,
                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataFine) {
        return ricercaService.ricercaEvento(nome, descrizione, dataInizio, dataFine);
    }

    @GetMapping("/ricercaUtenteRuolo")
    public List<Utente> ricercaUtente(@RequestParam int role){
        return ricercaService.ricercaUtenteRuolo(role);
    }
    @GetMapping("/ricercaUtenteEmail")
    public List<Utente> ricercaUtente(@RequestParam String email){
        return ricercaService.ricercaUtenteEmail(email);
    }

}
