package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.ConceptoIngreso;

public interface IConceptoIngresoDao extends CrudRepository<ConceptoIngreso, Integer> {
	
	@Query("select max(idConceptoIngreso) from ConceptoIngreso c")
	public Integer maxId();

}
