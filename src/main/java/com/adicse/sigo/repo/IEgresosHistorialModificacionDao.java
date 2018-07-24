package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.EgresosHistorialModificacion;


public interface IEgresosHistorialModificacionDao extends CrudRepository<EgresosHistorialModificacion, Integer>, 
PagingAndSortingRepository<EgresosHistorialModificacion,Integer>, 
JpaRepository<EgresosHistorialModificacion, Integer>,JpaSpecificationExecutor<EgresosHistorialModificacion> {

	@Query("select max(idEgresosHistorialModificacion) from EgresosHistorialModificacion a")
	public Integer maxId();
}
