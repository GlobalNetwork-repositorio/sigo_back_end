package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Ingreso;
import com.adicse.sigo.service.IngresoService;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

	@Autowired
	private IngresoService ingresoService;
	
	@RequestMapping("/getall")
	public List<Ingreso>getAll(){
		return ingresoService.readAll();
	}
	
	@RequestMapping("/save")
	public Ingreso save( @RequestBody Ingreso entidad ) {		
		// return entidad;
		return ingresoService.create(entidad);
	}
	
	@RequestMapping("/delete")
	public void delete( @RequestBody Integer id) { 
		ingresoService.deleteById(id);
	}
}
