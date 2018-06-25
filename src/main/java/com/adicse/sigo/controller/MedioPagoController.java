package com.adicse.sigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.adicse.sigo.model.MedioPago;
import com.adicse.sigo.service.MedioPagoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mediopago")
public class MedioPagoController {

	@Autowired
	private MedioPagoService medioPagoService;
	
	@RequestMapping("/getall")
	public List<MedioPago>getAll(){
		return medioPagoService.readAll();
	}
}
