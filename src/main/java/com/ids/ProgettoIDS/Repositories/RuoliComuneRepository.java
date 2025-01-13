package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.RuoloUtente;
import com.ids.ProgettoIDS.Model.RuoloUtenteComune;
import com.ids.ProgettoIDS.Model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuoliComuneRepository extends CrudRepository<RuoloUtenteComune, Integer> {
    @Query("SELECT c FROM RuoloUtenteComune c WHERE c.utente.ID = :IdUtente")
    List<RuoloUtenteComune> cercaRuoliPerId(@Param("IdUtente") Integer IdUtente);
    @Query("SELECT ruc.utente FROM RuoloUtenteComune ruc WHERE ruc.ruolo = :ruolo")
    List<Utente> cercaUtenteRuolo(@Param("ruolo") RuoloUtente ruoloUtente);
}
