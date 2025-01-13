package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Itinerario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface ItinerarioRepository extends CrudRepository<Itinerario,Integer> {
    @Query("SELECT i FROM Itinerario i WHERE (:nome IS NULL OR i.nome LIKE %:nome%) AND (:descrizione IS NULL OR i.descrizione LIKE %:descrizione%) AND (:dataCreazione IS NULL OR i.dataCreazione = :dataCreazione) AND (:livelloDifficolta = 0 OR i.livelloDifficolta = :livelloDifficolta)")
    List<Itinerario> ricercaItinerario(
            @Param("nome") String nome,
            @Param("descrizione") String descrizione,
            @Param("dataCreazione") Date dataCreazione,
            @Param("livelloDifficolta") int livelloDifficolta);

}
