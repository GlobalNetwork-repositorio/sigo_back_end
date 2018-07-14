package com.adicse.sigo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Usuario;
import com.adicse.sigo.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/getall")
	public List<Usuario>getAll(){
		return usuarioService.readAll();
	}
	
	@RequestMapping("/save")
	public Usuario save( @RequestBody Usuario entidad ) {				
		return usuarioService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public Usuario putUdate(@RequestBody Usuario entidad) {		
		Usuario usuarioUpdate = usuarioService.findbyid(entidad.getIdUsuario()).get();
			
		BeanUtils.copyProperties(entidad, usuarioUpdate);		
		return usuarioService.create(usuarioUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		usuarioService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Usuario getEdit(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}	
	
	@RequestMapping("/login")
	public Map<String, Object> login (@RequestBody Map <String, Object> json) {		
		String username = (String) json.get("username");
		String password = (String) json.get("password");
		Map <String, Object> response = new HashMap<String, Object>();
		String sreturn; 	
		
		Usuario usuario = usuarioService.getUsuarioByCredenciales(username, password);
		
			
		if ( usuario != null ) {
			
			Map <String, Object> claims = new HashMap<String, Object>();
			claims.put("role", "admin");
			
			String s = Jwts.builder().setSubject(username)				
					.setClaims(claims)
					.setIssuedAt(new Date())
					//.setExpiration(expirationTime)
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

			sreturn = "okkk";
			
			
			usuario.setContrasena("!");
			response.put("token", s);
			response.put("sucess", true);			
		} else {
			sreturn = "Login incorrecto";
			response.put("sucess", false);			
		}
		
		response.put("msg", sreturn);
		response.put("usuario", usuario);
		
		return response;
	}
}
