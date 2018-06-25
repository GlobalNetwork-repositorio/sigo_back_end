package com.adicse.sigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Usuario;
import com.adicse.sigo.service.UsuarioService;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/getall")
	public List<Usuario>getAll(){
		return usuarioService.readAll();
	}
}
