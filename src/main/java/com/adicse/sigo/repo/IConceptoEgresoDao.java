package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Area;
import com.adicse.sigo.model.ConceptoEgreso;
import com.adicse.sigo.model.Egreso;

public interface IConceptoEgresoDao extends CrudRepository<ConceptoEgreso, Integer>, 
PagingAndSortingRepository<ConceptoEgreso,Integer>, 
JpaRepository<ConceptoEgreso, Integer>,JpaSpecificationExecutor<ConceptoEgreso> {
	
	@Query("select max(idConceptoEgreso) from ConceptoEgreso c")
	public Integer maxId();
	
}
