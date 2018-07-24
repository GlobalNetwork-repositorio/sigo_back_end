package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Cuenta;
import com.adicse.sigo.service.CuentaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("cuenta")
public class CuentaController {	
	@Autowired
	private CuentaService cuentaService;
	
	@RequestMapping("/getall")
	public List<Cuenta> getAll(){
		return cuentaService.readAll();
	}
	
	@RequestMapping("/save")
	public Cuenta save( @RequestBody Cuenta entidad ) {				
		return cuentaService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public Cuenta putUdate(@RequestBody Cuenta entidad) {		
		Cuenta cuentaUpdate = cuentaService.findbyid(entidad.getIdCuenta()).get();
			
		BeanUtils.copyProperties(entidad, cuentaUpdate );		
		return cuentaService.create(cuentaUpdate );
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		cuentaService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Cuenta getEdit(@PathVariable Integer id) {
		return cuentaService.findById(id);
	}
}