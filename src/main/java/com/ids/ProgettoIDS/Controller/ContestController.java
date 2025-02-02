package com.ids.ProgettoIDS.Controller;

import com.ids.ProgettoIDS.Model.Contest;
import com.ids.ProgettoIDS.Model.DTO.ContestDTO;
import com.ids.ProgettoIDS.Model.Utente;
import com.ids.ProgettoIDS.Services.ContestService;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contest")
public class ContestController implements IController<ContestDTO, Integer> {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public ResponseEntity<Contest> crea (@Valid ContestDTO  contest)
    {
        Contest newContest = contestService.creaContest(contest.toContest(), contest.getContenuti());
        return ResponseEntity.ok(newContest);
    }

    @Override
    public ResponseEntity<?> getById(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(contestService.getContest(id));
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(contestService.getAllContest());
    }

    @Override
    public ResponseEntity<?> modifica(@Valid ContestDTO contestDTO, Integer id) {
        Contest cont = contestDTO.toContest();
        cont.setID(id);

        this.contestService.modificaContest(cont, contestDTO.getContenuti());
        return ResponseEntity.ok("{}");
    }

    @Override
    public ResponseEntity<?> elimina(@PathVariable("id") Integer id) {
        return ResponseEntity.badRequest().body("Non Implementato");
    }

    @PutMapping("/iscrizione/{idContest}")
    public ResponseEntity<?> iscrizioneContest(@PathVariable Integer idContenuto,
                                               @RequestBody Integer idContest){
        contestService.iscrizioneContenuto(idContenuto, idContest);
        return ResponseEntity.ok("");
    }

    @PutMapping("/chiusura/{idContest}")
    public ResponseEntity<?> chiusuraContest(@PathVariable Integer idContest, @RequestBody Integer idContenutoVincitore) {
        contestService.chiusuraContest(idContest, idContenutoVincitore);

        return ResponseEntity.ok("{}");
    }

}