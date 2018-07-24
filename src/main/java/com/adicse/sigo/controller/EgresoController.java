package com.adicse.sigo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.adicse.sigo.model.Egreso;
import com.adicse.sigo.model.EgresosHistorialModificacion;
import com.adicse.sigo.service.EgresoService;
import com.adicse.sigo.service.EgresosHistorialModificacionService;
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
	private EgresosHistorialModificacionService egresoHistorialModificacionService;
	
	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson;
	
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
	
	// @RequestMapping("/save")
	@RequestMapping("/save")
	public Egreso save( @RequestBody Egreso entidad , @RequestParam("historial") String historial) {
		if ( historial != null ) {
			// guarda en historial de modificaciones		
			EgresosHistorialModificacion entididaHistorial = new EgresosHistorialModificacion();
			entididaHistorial.setUsuario(entidad.getUsuario());
			entididaHistorial.setEgreso(entidad);
			entididaHistorial.setModificacion(historial);
			egresoHistorialModificacionService.create(entididaHistorial);				
		}
				
		return egresoService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public Egreso putUdate(@RequestBody Egreso entidad, @RequestParam("historial") String historial) {		
		Egreso egresoUpdate = egresoService.findbyid(entidad.getIdEgreso()).get();
		
		// guarda en historial de modificaciones		
		EgresosHistorialModificacion egresoHistorial = new EgresosHistorialModificacion();
		egresoHistorial.setUsuario(entidad.getUsuario());
		egresoHistorial.setEgreso(entidad);
		egresoHistorialModificacionService.create(egresoHistorial);
		
		// Egreso egresoUpdate = new Egreso();
		BeanUtils.copyProperties(entidad, egresoUpdate);
		return egresoUpdate;
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		egresoService.deleteById(id);
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Egreso getEdit(@PathVariable Integer id) {
		return egresoService.findById(id);
	}
}
