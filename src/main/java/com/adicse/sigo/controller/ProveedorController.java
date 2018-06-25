package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Proveedor;
import com.adicse.sigo.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;

	
	//paginacion
	@RequestMapping("/pagination")
	public List<Proveedor> pagination(){
		return null;
	}
	
	//mostrartodos
	@RequestMapping("/getall")
	@ResponseBody
	public List<Proveedor> getall(){
		List lst = proveedorService.readAll();
		return proveedorService.readAll();
	}
	
	
	//edit
	@RequestMapping("/edit")
	public Proveedor edit(@RequestParam("id") Integer id) {
		return proveedorService.findById(id);
	}
	
	//grabar
	@RequestMapping("/save")
	public Proveedor save(Proveedor entidad) {
		return proveedorService.create(entidad);
	}
	
	//update
	@RequestMapping("/update")
	public Proveedor update(Proveedor entidad) {
		return proveedorService.update(entidad);
	}
	
	//eliminar
	@RequestMapping("/delete")
	public void eliminar(@RequestParam("id") Integer id) {
		proveedorService.deleteById(id);
	}
	
	
	
	
}
