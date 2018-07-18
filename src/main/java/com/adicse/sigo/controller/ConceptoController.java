package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Concepto;

import com.adicse.sigo.service.ConceptoService;


@RestController
@RequestMapping("concepto")
public class ConceptoController {
	@Autowired
	private ConceptoService ConceptoService;
	
	@RequestMapping("/getall")
	public List<Concepto> getAll(){
		return ConceptoService.readAll();
	}
	
	@RequestMapping("/getFindByTipoRubro/{tipo}")
	@ResponseBody
	public List<Concepto> getFindByTipo(@PathVariable Integer tipo){
		return ConceptoService.findByTipoRubro(tipo);
	}
	
	@RequestMapping("/save")
	public Concepto save( @RequestBody Concepto entidad ) {				
		return ConceptoService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public Concepto putUdate(@RequestBody Concepto concepto) {		
		Concepto conceptoUpdate = ConceptoService.findbyid(concepto.getIdConcepto()).get();
			
		BeanUtils.copyProperties(concepto, conceptoUpdate);		
		return ConceptoService.create(conceptoUpdate);
	}	
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		ConceptoService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Concepto getEdit(@PathVariable Integer id) {
		return ConceptoService.findById(id);
	}	
}

