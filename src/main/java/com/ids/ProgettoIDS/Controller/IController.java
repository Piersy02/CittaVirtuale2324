package com.ids.ProgettoIDS.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interfaccia che gestisce i metodi standard CRUD
 * @param <T> il tipo dell'entità da gesstire
 * @param <ID> l'ID dell'entità
 */
public interface IController<T, ID> {

    /**
     * Crea una nuova istanza di un entità
     * @param entity l'entità da creare
     * @return l'entità creata all'interno del repository
     */
    @PostMapping
    ResponseEntity<?> crea(@RequestBody T entity);

    /**
     * Restituisce una specifica enità
     * @param id l'ID dell'entità che si vuole ottenre
     * @return l'entità con l'ID corrispondente
     */
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable ID id);

    /**
     * Ritorna tutte le entità
     * @return la lista di entità desiderata
     */
    @GetMapping("/getAll")
    ResponseEntity<?> getAll();

    /**
     * Modifica un entità esistente
     * @param entity l'entità da modificare
     * @return l'entità modificata all'interno del repository
     */
    @PutMapping
    ResponseEntity<?> modifica(@RequestBody T entity);

    /**
     * Elimina un entità
     * @param id l'ID dell'entità da eliminare
     * @return il risultato dell'operazione
     */
    @DeleteMapping("/{id}")
    ResponseEntity<?> elimina(@PathVariable ID id);
}
