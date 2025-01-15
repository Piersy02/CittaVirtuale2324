package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Contest;
import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Services.ContestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contest")
public class ContestController implements IController<Contest, Integer> {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public ResponseEntity<Contest> crea (@RequestBody Contest contest)
    {
        Contest newContest = contestService.creaContest(contest);
        return ResponseEntity.ok(newContest);
    }

    @Override
    public ResponseEntity<?> getById(Integer integer) {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> modifica(Contest entity) {
        return null;//TODO Da Implementare
    }

    @Override
    public ResponseEntity<?> elimina(Integer integer) {
        return null;//TODO Da Implementare
    }
}