package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Area;
import com.adicse.sigo.model.Sucursal;
import com.adicse.sigo.service.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;
	
	@RequestMapping("/getall")
	public List<Sucursal>getAll(){
		return sucursalService.readAll();
	}
	
	@RequestMapping("/save")
	public Sucursal save( @RequestBody Sucursal entidad ) {				
		return sucursalService.create(entidad);
	}
	
}
