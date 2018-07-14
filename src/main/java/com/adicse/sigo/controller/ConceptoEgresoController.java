package com.adicse.sigo.controller;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.ConceptoEgreso;
import com.adicse.sigo.service.ConceptoEgresoService;
import com.adicse.sigo.specification.ConvertObjectToFormatJson;
import com.adicse.sigo.specification.Filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/conceptoegreso")
public class ConceptoEgresoController {

	@Autowired
	private ConceptoEgresoService conceptoEgresoService;

	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson;
	
	@RequestMapping("/getall")
	public List<ConceptoEgreso>getAll(){
		return conceptoEgresoService.readAll();
	}
	
	@RequestMapping("/save")
	public ConceptoEgreso save( @RequestBody ConceptoEgreso entidad ) {				
		return conceptoEgresoService.create(entidad);
	}
		
	@PostMapping("/paginacion")
    public Map<String,Object>  paginar(
    		@RequestParam("pagenumber") Integer pagenumber,
			@RequestParam("rows") Integer rows,
			@RequestParam("sortdireccion") String sortdireccion,
			@RequestParam("sortcolumn") String sortcolumn,
			@RequestBody Object f			
    		){
		
		// @RequestBody Object f
		
		Filter filter = convertObjectToFormatJson.ConvertObjectToFormatSpecification(f);
		
		Map<String,Object> response = new HashMap<String, Object>();
		
		Page<ConceptoEgreso> page =  conceptoEgresoService.paginacion(pagenumber, rows, sortdireccion, sortcolumn, filter);
		List<ConceptoEgreso> lst = page.getContent();
		
		response.put("data", lst);
		response.put("totalPages", page.getTotalPages());
		response.put("success", true);
		response.put("totalCount", page.getTotalElements());
		
		return response; 
    }
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		conceptoEgresoService.deleteById(id);		
	}
}
