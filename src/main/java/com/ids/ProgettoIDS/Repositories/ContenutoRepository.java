package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Contenuto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContenutoRepository extends CrudRepository<Contenuto,Integer> {
    @Query("SELECT c FROM Contenuto c WHERE (:nome IS NULL OR c.nome LIKE %:nome%) AND (:descrizione IS NULL OR c.descrizione LIKE %:descrizione%) AND (:dataCreazione IS NULL OR c.dataCreazione = :dataCreazione)")
    List<Contenuto> cercaPerNomeDescrizioneData(
            @Param("nome") String nome,
            @Param("descrizione") String descrizione,
            @Param("dataCreazione") Date dataCreazione);
}