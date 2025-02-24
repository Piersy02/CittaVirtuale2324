package com.ids.ProgettoIDS.Repositories;

import com.ids.ProgettoIDS.Model.Comune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuneRepository extends CrudRepository<Comune,Integer> {

}