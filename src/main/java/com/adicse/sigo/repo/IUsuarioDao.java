package com.adicse.sigo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.sigo.model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{
	
	@Query ("Select p from Usuario p where usuario = :username and contrasena = :password") 	
	public Usuario getUsuarioByCredenciales ( @Param ("username") String username, @Param ("password") String password );  
	
	@Query("select max(idUsuario) from Usuario m")
	public Integer maxId();

}
