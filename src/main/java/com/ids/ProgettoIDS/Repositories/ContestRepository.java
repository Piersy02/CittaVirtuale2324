package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Contest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContestRepository extends CrudRepository<Contest,Integer> {
    @Query("SELECT c FROM Contest c WHERE (:nome IS NULL OR c.nome = :nome) AND (:dataInizio IS NULL OR :dataFine IS NULL OR c.dataInizio BETWEEN :dataInizio AND :dataFine) AND (:tipo IS NULL OR c.tipo = :tipo)")
    List<Contest> ricercaContest(
            @Param("nome") String nome,
            @Param("dataInizio") Date dataInizio,
            @Param("dataFine") Date dataFine,
            @Param("tipo") String tipo);
}
