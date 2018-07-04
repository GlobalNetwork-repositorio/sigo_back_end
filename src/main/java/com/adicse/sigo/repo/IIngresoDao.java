package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Ingreso;

public interface IIngresoDao extends CrudRepository<Ingreso, Integer>{
	@Query("select max(idIngreso) from Ingreso e")
	public Integer maxId();
}
