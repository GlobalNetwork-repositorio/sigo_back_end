package com.adicse.sigo.repo;

import org.springframework.data.repository.CrudRepository;

import com.adicse.sigo.model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{
	

}
