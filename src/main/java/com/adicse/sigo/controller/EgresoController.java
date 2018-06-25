package com.adicse.sigo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
}
