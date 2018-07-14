package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/update")	
	public Sucursal putUdate(@RequestBody Sucursal sucursal) {		
		Sucursal sucursalUpdate = sucursalService.findbyid(sucursal.getIdSucursal()).get();
			
		BeanUtils.copyProperties(sucursal, sucursalUpdate );		
		return sucursalService.create(sucursalUpdate );
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		sucursalService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Sucursal getEdit(@PathVariable Integer id) {
		return sucursalService.findById(id);
	}
}
