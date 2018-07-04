package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.MedioPago;

public interface IMedioPagoDao extends CrudRepository<MedioPago, Integer>{
	
	@Query("select max(idMedioPago) from MedioPago m")
	public Integer maxId();

}
