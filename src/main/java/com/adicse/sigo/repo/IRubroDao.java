package com.adicse.sigo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.sigo.model.Rubro;

public interface IRubroDao extends CrudRepository<Rubro, Integer>, 
PagingAndSortingRepository<Rubro,Integer>, 
JpaRepository<Rubro, Integer>,JpaSpecificationExecutor<Rubro> {
	
	@Query("select c from Rubro c where tipo=:tipo order by idRubro")
	public List<Rubro> getFindByTipo(@Param("tipo") Integer tipo);

}