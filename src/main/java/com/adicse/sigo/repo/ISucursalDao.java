package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Sucursal;

public interface ISucursalDao extends CrudRepository<Sucursal, Integer> {
	
	@Query("select max(idSucursal) from Sucursal s")
	public Integer maxId();
}
