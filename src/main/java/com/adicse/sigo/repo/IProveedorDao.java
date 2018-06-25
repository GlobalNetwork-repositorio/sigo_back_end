package com.adicse.sigo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.sigo.model.Proveedor;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer> ,
PagingAndSortingRepository<Proveedor, Integer>{

}
