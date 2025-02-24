package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.CategoriaPOI;
import com.ids.ProgettoIDS.Model.Posizione;
import com.ids.ProgettoIDS.Model.PuntoDiInteresse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntoDiInteresseRepository extends CrudRepository<PuntoDiInteresse,Integer> {
    @Query("SELECT p FROM PuntoDiInteresse p WHERE (:nome IS NULL OR p.nome LIKE %:nome%) AND (:descrizione IS NULL OR p.descrizione LIKE %:descrizione%) AND (:categoria IS NULL OR p.categoria = :categoria) AND (:posizione IS NULL OR p.posizione = :posizione)")
    List<PuntoDiInteresse> ricercaPoi(
            @Param("nome") String nome,
            @Param("descrizione") String descrizione,
            @Param("categoria") CategoriaPOI categoria,
            @Param("posizione") Posizione posizione);

}
