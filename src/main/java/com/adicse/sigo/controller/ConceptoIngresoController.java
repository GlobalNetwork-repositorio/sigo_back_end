package com.adicse.sigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.ConceptoIngreso;
import com.adicse.sigo.service.ConceptoIngresoService;

import java.util.List;

@RestController
@RequestMapping("/conceptoingreso")
public class ConceptoIngresoController {

	@Autowired
	private ConceptoIngresoService conceptoIngresoService;
	
	@RequestMapping("/getall")
	public List<ConceptoIngreso>getAll(){
		return conceptoIngresoService.readAll();
		
	}
	
}
