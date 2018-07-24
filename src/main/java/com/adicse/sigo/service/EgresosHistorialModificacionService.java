package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.EgresosHistorialModificacion;
import com.adicse.sigo.repo.IEgresosHistorialModificacionDao;
import com.adicse.sigo.specification.Filter;
import com.adicse.sigo.utilitarios.FuncionesUtilesService;


@Service
@Transactional
public class EgresosHistorialModificacionService implements IAdicseCustom<EgresosHistorialModificacion, Integer> {
	
	@Autowired
	private IEgresosHistorialModificacionDao iEgresosHistorialModificacionDao;
	
	@Autowired
	private FuncionesUtilesService funcionesUtiles;

	@Override
	public EgresosHistorialModificacion create(EgresosHistorialModificacion entidad) {
		
		Integer IdMax = iEgresosHistorialModificacionDao.maxId() == null ? 1 : iEgresosHistorialModificacionDao.maxId() + 1 ; 
		entidad.setIdEgresosHistorialModificacion(IdMax);
		entidad.setFechaHora(funcionesUtiles.getFechaActual().toString() + " " + funcionesUtiles.getHoraActual());
		
		iEgresosHistorialModificacionDao.save(entidad);
		return entidad;
	}
	

	@Override
	public List<EgresosHistorialModificacion> readAll() {		
		return (List<EgresosHistorialModificacion>) iEgresosHistorialModificacionDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idEgresosHistorialModificacion");
    }

	@Override
	public EgresosHistorialModificacion update(EgresosHistorialModificacion entidad) {
		return iEgresosHistorialModificacionDao.save(entidad);
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
	public EgresosHistorialModificacion findById(Integer id) {
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
	public Optional<EgresosHistorialModificacion> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
