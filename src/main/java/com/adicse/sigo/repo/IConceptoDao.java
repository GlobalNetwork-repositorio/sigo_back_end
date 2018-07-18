package com.adicse.sigo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.sigo.model.Concepto;


public interface IConceptoDao extends CrudRepository<Concepto, Integer>, 
PagingAndSortingRepository<Concepto,Integer>, 
JpaRepository<Concepto, Integer>,JpaSpecificationExecutor<Concepto> {

	@Query("select max(idConcepto) from Concepto a")
	public Integer maxId();
	
	// listas
	@Query("select c from Concepto c where rubro.tipo=:tipo order by descripcion")
	public List<Concepto> getFindByTipoRubro(@Param("tipo") Integer tipo);
}