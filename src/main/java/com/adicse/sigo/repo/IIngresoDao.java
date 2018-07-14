package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Ingreso;

public interface IIngresoDao extends CrudRepository<Ingreso, Integer>, 
	PagingAndSortingRepository<Ingreso,Integer>, 
	JpaRepository<Ingreso, Integer>,JpaSpecificationExecutor<Ingreso> {
	
	@Query("select max(idIngreso) from Ingreso e")
	public Integer maxId();
}
