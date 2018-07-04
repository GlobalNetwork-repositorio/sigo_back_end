package com.adicse.sigo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adicse.sigo.model.Area;
import com.adicse.sigo.model.Egreso;
import com.adicse.sigo.service.AreaService;
@RestController
@RequestMapping("area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/getall")
	public List<Area> getAll(){
		return areaService.readAll();
	}
	
	@RequestMapping("/save")
	public Area save( @RequestBody Area entidad ) {				
		return areaService.create(entidad);
	}
}