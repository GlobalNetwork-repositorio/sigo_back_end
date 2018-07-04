package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.ConceptoEgreso;

public interface IConceptoEgresoDao extends CrudRepository<ConceptoEgreso, Integer> {
	
	@Query("select max(idConceptoEgreso) from ConceptoEgreso c")
	public Integer maxId();
	
}
