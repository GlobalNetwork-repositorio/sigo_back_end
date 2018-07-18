package com.adicse.sigo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Rubro;
import com.adicse.sigo.service.RubroService;

@RestController
@RequestMapping("rubro")
public class RubroController {
	@Autowired
	private RubroService RubroService;
	
	@RequestMapping("/getall")
	public List<Rubro> getAll(){
		return RubroService.readAll();
	}
	
	@RequestMapping("/getFindByTipo/{tipo}")
	@ResponseBody
	public List<Rubro> getFindByTipo(@PathVariable Integer tipo){
		return RubroService.findByTipo(tipo);
	}
	
	
	
//	@RequestMapping("/save")
//	public Rubro save( @RequestBody Rubro entidad ) {				
//		return RubroService.create(entidad);
//	}
	
//	@RequestMapping("/update")	
//	public Rubro putUdate(@RequestBody Rubro rubro) {		
//		Rubro rubroUpdate = RubroService.findbyid(rubro.getIdRubro()).get();
//			
//		BeanUtils.copyProperties(rubro, rubroUpdate);		
//		return RubroService.create(rubroUpdate);
//	}	
//	
//	@RequestMapping("/delete/{id}")
//	@ResponseBody
//	public void delete(@PathVariable Integer id) {		
//		RubroService.deleteById(id);		
//	}
//	
//	@RequestMapping("/edit/{id}")
//	@ResponseBody
//	public Rubro getEdit(@PathVariable Integer id) {
//		return RubroService.findById(id);
//	}	
}

