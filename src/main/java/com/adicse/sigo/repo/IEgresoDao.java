package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Egreso;
 // import com.adicse.sigo.service.Pageable;

public interface IEgresoDao extends CrudRepository<Egreso, Integer>, 
		PagingAndSortingRepository<Egreso,Integer>, 
		JpaRepository<Egreso, Integer>,JpaSpecificationExecutor<Egreso> {
	
	@Query("select max(idEgreso) from Egreso e")
	public Integer maxId();
	
}
