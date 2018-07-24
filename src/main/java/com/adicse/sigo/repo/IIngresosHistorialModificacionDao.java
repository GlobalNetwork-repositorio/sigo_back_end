package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.IngresosHistorialModificacion;

public interface IIngresosHistorialModificacionDao extends CrudRepository<IngresosHistorialModificacion, Integer>, 
PagingAndSortingRepository<IngresosHistorialModificacion,Integer>, 
JpaRepository<IngresosHistorialModificacion, Integer>,JpaSpecificationExecutor<IngresosHistorialModificacion> {

	@Query("select max(idIngresosHistorialModificacion) from IngresosHistorialModificacion a")
	public Integer maxId();
	
}
