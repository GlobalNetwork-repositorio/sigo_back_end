package com.adicse.sigo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.adicse.sigo.model.Egreso;
import com.adicse.sigo.service.EgresoService;
import com.adicse.sigo.specification.ConvertObjectToFormatJson;
import com.adicse.sigo.specification.Filter;

import org.springframework.web.bind.annotation.*;


// import com.adicse.sigo.specification.Filter;

@RestController
@RequestMapping("/egreso")
public class EgresoController {

	@Autowired
	private EgresoService egresoService;
	
	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson;

//	@PostMapping("/paginacion")
//    public Map<String,Object>  paginar(
//    		@RequestParam("pagenumber") Integer pagenumber,
//			@RequestParam("rows") Integer rows,
//			@RequestParam("sortdireccion") String sortdireccion,
//			@RequestParam("sortcolumn") String sortcolumn,
//			@RequestBody Filter filter
//    		){
//		
//		// Filter f = convertObjectToFormatJson.ConvertObjectToFormatSpecification(filter);
//		// Filter f = (Filter) filter;
//		Map<String,Object> response = new HashMap<String, Object>();
//		
//		Page<Egreso> page =  egresoService.paginacion(pagenumber, rows, sortdireccion, sortcolumn, filter);
//		List<Egreso> lst = page.getContent();
//		
//		response.put("data", lst);
//		response.put("totalPages", page.getTotalPages());
//		response.put("success", true);
//		response.put("totalCount", page.getTotalElements());
//		
//		return response; 
//    }
	
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
		
		Page<Egreso> page =  egresoService.paginacion(pagenumber, rows, sortdireccion, sortcolumn, filter);
		List<Egreso> lst = page.getContent();
		
		response.put("data", lst);
		response.put("totalPages", page.getTotalPages());
		response.put("success", true);
		response.put("totalCount", page.getTotalElements());
		
		return response; 
    }
	
	@RequestMapping("/getall")
	public List<Egreso>getAll(){
		return egresoService.readAll();
	}
	
	@RequestMapping("/save")
	public Egreso save( @RequestBody Egreso entidad ) {		
		// return entidad;		
		return egresoService.create(entidad);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		egresoService.deleteById(id);		
	}
		
	
}
