package com.adicse.sigo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Egreso;
import com.adicse.sigo.service.EgresoService;

@RestController
@RequestMapping("/egreso")
public class EgresoController {

	@Autowired
	private EgresoService egresoService;

	@RequestMapping("/getall")
	public List<Egreso>getAll(){
		return egresoService.readAll();
	}
	
	@RequestMapping("/save")
	public Egreso save( @RequestBody Egreso entidad ) {		
		// return entidad;
		return egresoService.create(entidad);
	}
	
	@RequestMapping("/delete")
	public void delete( @RequestBody Integer id) { 
		egresoService.deleteById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/pagination")
	public List<Egreso>pagination( @RequestBody Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn, Object filter){
		return (List<Egreso>) egresoService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filter);
	}
	
	
	
	
	
}
