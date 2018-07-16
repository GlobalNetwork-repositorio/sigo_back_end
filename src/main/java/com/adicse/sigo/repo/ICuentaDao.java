package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> , 
PagingAndSortingRepository<Cuenta,Integer>, 
JpaRepository<Cuenta, Integer>,JpaSpecificationExecutor<Cuenta> {
	
	@Query("select max(idCuenta) from Cuenta a")
	public Integer maxId();

}
