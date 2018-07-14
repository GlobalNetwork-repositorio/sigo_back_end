package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Sucursal;

public interface ISucursalDao extends CrudRepository<Sucursal, Integer>, 
PagingAndSortingRepository<Sucursal,Integer>, 
JpaRepository<Sucursal, Integer>,JpaSpecificationExecutor<Sucursal> {
	
	@Query("select max(idSucursal) from Sucursal s")
	public Integer maxId();
	
}
