package com.adicse.sigo.repo;

import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> {

}
