package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Egreso;

public interface IEgresoDao extends CrudRepository<Egreso, Integer> {
	
	@Query("select max(idEgreso) from Egreso e")
	public Integer maxId();
	
}
