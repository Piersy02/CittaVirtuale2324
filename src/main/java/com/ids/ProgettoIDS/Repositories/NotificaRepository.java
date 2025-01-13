package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Notifica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificaRepository extends CrudRepository<Notifica, Integer> {

}
