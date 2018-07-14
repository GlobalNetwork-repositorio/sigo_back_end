package com.adicse.sigo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/save")
	public MedioPago save( @RequestBody MedioPago entidad ) {				
		return medioPagoService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public MedioPago putUdate(@RequestBody MedioPago entidad) {		
		MedioPago medioPagoUpdate = medioPagoService.findbyid(entidad.getIdMedioPago()).get();
			
		BeanUtils.copyProperties(entidad, medioPagoUpdate);		
		return medioPagoService.create(medioPagoUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		medioPagoService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public MedioPago getEdit(@PathVariable Integer id) {
		return medioPagoService.findById(id);
	}
}
