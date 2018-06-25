package com.adicse.sigo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Usuario;
import com.adicse.sigo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/getall")
	public List<Usuario>getAll(){
		return usuarioService.readAll();
	}
	
	public Map<String, Object> login (@RequestBody Map <String, Object> json) {
		String username = (String) json.get("username");
		String password = (String) json.get("password");
		
		Usuario usuario = usuarioService.getUsuarioByCredenciales(username, password);
		
		if ( usuario != null ) {
			
		}
		
		return null;
	}
}
