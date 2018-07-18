package com.adicse.sigo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.ConceptoRegistro;
import com.adicse.sigo.service.ConceptoRegistroService;


@RestController
@RequestMapping("conceptoregistro")
public class ConceptoRegistroController {
	@Autowired
	private ConceptoRegistroService ConceptoRegistroService;
	
	@RequestMapping("/getall")
	public List<ConceptoRegistro> getAll(){
		return ConceptoRegistroService.readAll();
	}
	
	@RequestMapping("/save")
	public ConceptoRegistro save( @RequestBody ConceptoRegistro entidad ) {				
		return ConceptoRegistroService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public ConceptoRegistro putUdate(@RequestBody ConceptoRegistro conceptoRegistro) {		
		ConceptoRegistro conceptoRegistroUpdate = ConceptoRegistroService.findbyid(conceptoRegistro.getIdConceptoRegistro()).get();
			
		BeanUtils.copyProperties(conceptoRegistro, conceptoRegistroUpdate);		
		return ConceptoRegistroService.create(conceptoRegistroUpdate);
	}	
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		ConceptoRegistroService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public ConceptoRegistro getEdit(@PathVariable Integer id) {
		return ConceptoRegistroService.findById(id);
	}	
	
	@RequestMapping("/getFindByIdConcepto/{id}")
	@ResponseBody
	public List<ConceptoRegistro> getFindByIdConcepto(@PathVariable Integer id) {		
		return ConceptoRegistroService.findByIdConcepto(id);	
	}
	
}

