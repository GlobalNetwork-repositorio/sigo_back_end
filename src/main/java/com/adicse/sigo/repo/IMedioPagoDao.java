package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.MedioPago;
public interface IMedioPagoDao extends CrudRepository<MedioPago, Integer>, 
PagingAndSortingRepository<MedioPago,Integer>, 
JpaRepository<MedioPago, Integer>,JpaSpecificationExecutor<MedioPago> {
	
	@Query("select max(idMedioPago) from MedioPago m")
	public Integer maxId();

}
