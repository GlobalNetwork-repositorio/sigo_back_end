package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Area;

public interface IAreaDao extends CrudRepository<Area, Integer>, 
	PagingAndSortingRepository<Area,Integer>, 
	JpaRepository<Area, Integer>,JpaSpecificationExecutor<Area> {
	
	@Query("select max(idArea) from Area a")
	public Integer maxId();

}