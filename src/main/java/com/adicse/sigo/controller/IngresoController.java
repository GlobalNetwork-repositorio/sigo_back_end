package com.adicse.sigo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.sigo.model.Ingreso;
import com.adicse.sigo.service.IngresoService;
import com.adicse.sigo.specification.Filter;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

	@Autowired
	private IngresoService ingresoService;
	
	@RequestMapping("/getall")
	public List<Ingreso>getAll(){
		return ingresoService.readAll();
	}
	
	@PostMapping("/paginacion")
    public Map<String,Object>  paginar(
    		@RequestParam("pagenumber") Integer pagenumber,
			@RequestParam("rows") Integer rows,
			@RequestParam("sortdireccion") String sortdireccion,
			@RequestParam("sortcolumn") String sortcolumn,
			@RequestBody Filter filter
    		){
		
		Map<String,Object> response = new HashMap<String, Object>();
		
		Page<Ingreso> page =  ingresoService.paginacion(pagenumber, rows, sortdireccion, sortcolumn, filter);
		List<Ingreso> lst = page.getContent();
		
		response.put("data", lst);
		response.put("totalPages", page.getTotalPages());
		response.put("success", true);
		response.put("totalCount", page.getTotalElements());
		
		return response; 
    }
	
	@RequestMapping("/save")
	public Ingreso save( @RequestBody Ingreso entidad ) {		
		// return entidad;
		return ingresoService.create(entidad);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		ingresoService.deleteById(id);		
	}
}
