package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.IngresosHistorialModificacion;
import com.adicse.sigo.repo.IIngresosHistorialModificacionDao;
import com.adicse.sigo.specification.Filter;
import com.adicse.sigo.utilitarios.FuncionesUtilesService;

@Service
@Transactional
public class IngresosHistorialModificacionService implements IAdicseCustom<IngresosHistorialModificacion, Integer> {

	@Autowired
	private IIngresosHistorialModificacionDao iIngresosHistorialModificacionDao;
	
	@Autowired
	private FuncionesUtilesService funcionesUtiles;

	@Override
	public IngresosHistorialModificacion create(IngresosHistorialModificacion entidad) {
		
		Integer IdMax = iIngresosHistorialModificacionDao.maxId() == null ? 1 : iIngresosHistorialModificacionDao.maxId() + 1 ; 
		entidad.setIdIngresosHistorialModificacion(IdMax);
		entidad.setFechaHora(funcionesUtiles.getFechaActual().toString() + " " + funcionesUtiles.getHoraActual());
		
		iIngresosHistorialModificacionDao.save(entidad);
		return entidad;
	}
	

	@Override
	public List<IngresosHistorialModificacion> readAll() {		
		return (List<IngresosHistorialModificacion>) iIngresosHistorialModificacionDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idIngresosHistorialModificacion");
    }
	
	
	@Override
	public Page<?> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<?> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<?> paginationParmsExtra(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter, Object paramsExtra) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public IngresosHistorialModificacion update(IngresosHistorialModificacion entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IngresosHistorialModificacion findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<IngresosHistorialModificacion> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
