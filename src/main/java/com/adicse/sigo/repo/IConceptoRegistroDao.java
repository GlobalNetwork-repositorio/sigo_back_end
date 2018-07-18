package com.adicse.sigo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.ConceptoRegistro;


public interface IConceptoRegistroDao extends CrudRepository<ConceptoRegistro, Integer>, 
PagingAndSortingRepository<ConceptoRegistro,Integer>, 
JpaRepository<ConceptoRegistro, Integer>,JpaSpecificationExecutor<ConceptoRegistro> {

	@Query("select max(idConceptoRegistro) from ConceptoRegistro a")
	public Integer maxId();
	
	@Query("select a from ConceptoRegistro a where concepto.idConcepto=:idconcepto order by idConceptoRegistro")
	public List<ConceptoRegistro> getByIdConcepto(@Param("idconcepto") Integer idProductoPresentacion);
	

}