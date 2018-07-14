package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Proveedor;
import com.adicse.sigo.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;

	
	//mostrartodos
	@RequestMapping("/getall")	
	public List<Proveedor> getall(){		
		return proveedorService.readAll();
	}
	
	@RequestMapping("/save")
	public Proveedor save( @RequestBody Proveedor entidad ) {				
		return proveedorService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public Proveedor putUdate(@RequestBody Proveedor entidad) {		
		Proveedor areaUpdate = proveedorService.findbyid(entidad.getIdProveedor()).get();
			
		BeanUtils.copyProperties(entidad, areaUpdate);		
		return proveedorService.create(areaUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		proveedorService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Proveedor getEdit(@PathVariable Integer id) {
		return proveedorService.findById(id);
	}	
}
