package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventoRepository extends CrudRepository<Evento,Integer> {
    @Query("SELECT e FROM Evento e WHERE (:nome IS NULL OR e.nome LIKE %:nome%) AND (:descrizione IS NULL OR e.descrizione LIKE %:descrizione%) AND ((:dataInizio IS NULL OR :dataFine IS NULL) OR (e.dataInizio BETWEEN :dataInizio AND :dataFine OR e.dataFine BETWEEN :dataInizio AND :dataFine))")
    List<Evento> ricercaEvento(
            @Param("nome") String nome,
            @Param("descrizione") String descrizione,
            @Param("dataInizio") Date dataInizio,
            @Param("dataFine") Date dataFine);
}
