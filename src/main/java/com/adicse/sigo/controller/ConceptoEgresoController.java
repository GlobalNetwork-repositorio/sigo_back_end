package com.adicse.sigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.ConceptoEgreso;
import com.adicse.sigo.service.ConceptoEgresoService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/conceptoegreso")
public class ConceptoEgresoController {

	@Autowired
	private ConceptoEgresoService conceptoEgresoService;
	
	@RequestMapping("/getall")
	public List<ConceptoEgreso>getAll(){
		return conceptoEgresoService.readAll();
	}
}
