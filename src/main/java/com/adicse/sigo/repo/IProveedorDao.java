package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Proveedor;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> , 
PagingAndSortingRepository<Proveedor,Integer>, 
JpaRepository<Proveedor, Integer>,JpaSpecificationExecutor<Proveedor> {

	
	@Query("select max(idProveedor) from Proveedor p")
	public Integer maxId();
}
