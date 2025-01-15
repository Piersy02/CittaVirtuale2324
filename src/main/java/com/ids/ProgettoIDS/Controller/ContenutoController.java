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

    //TODO: Aggiungere approvazioni

    public ContenutoController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
    }

}