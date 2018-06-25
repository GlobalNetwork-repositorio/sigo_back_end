package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
