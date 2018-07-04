package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> {
	
	@Query("select max(idCuenta) from Cuenta a")
	public Integer maxId();

}
