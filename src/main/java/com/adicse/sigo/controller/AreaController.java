package com.adicse.sigo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.adicse.sigo.model.Area;
import com.adicse.sigo.service.AreaService;
import com.adicse.sigo.specification.ConvertObjectToFormatJson;
import com.adicse.sigo.specification.Filter;
@RestController
@RequestMapping("area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson;
	
	@RequestMapping("/getall")
	public List<Area> getAll(){
		return areaService.readAll();
	}
	
	@RequestMapping("/save")
	public Area save( @RequestBody Area entidad ) {				
		return areaService.create(entidad);
	}
	
	@RequestMapping("/update")	
	public Area putUdate(@RequestBody Area area) {		
		Area areaUpdate = areaService.findbyid(area.getIdArea()).get();
			
		BeanUtils.copyProperties(area, areaUpdate);		
		return areaService.create(areaUpdate);
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
		
		Page<Area> page =  areaService.paginacion(pagenumber, rows, sortdireccion, sortcolumn, filter);
		List<Area> lst = page.getContent();
		
		response.put("data", lst);
		response.put("totalPages", page.getTotalPages());
		response.put("success", true);
		response.put("totalCount", page.getTotalElements());
		
		return response; 
    }
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {		
		areaService.deleteById(id);		
	}
	
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public Area getEdit(@PathVariable Integer id) {
		return areaService.findById(id);
	}	
}