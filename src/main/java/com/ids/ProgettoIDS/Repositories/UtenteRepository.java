package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Utente u WHERE u.username = :username OR u.email = :email")
    boolean esisteUtente (@Param("username") String username, @Param("email") String email);
    @Query("SELECT u FROM Utente u WHERE u.email = :email")
    List<Utente> ricercaPerEmail(@Param("email")String email);
}
