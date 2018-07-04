package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Area;

public interface IAreaDao extends CrudRepository<Area, Integer> {
	
	@Query("select max(idArea) from Area a")
	public Integer maxId();

}