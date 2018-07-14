package com.adicse.sigo.service;

import static com.adicse.sigo.specification.SpecificationBuilder.selectFrom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Ingreso;
import com.adicse.sigo.repo.IIngresoDao;

import com.adicse.sigo.utilitarios.FuncionesUtilesService;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class IngresoService implements IAdicseCustom<Ingreso, Integer>{
	
	@Autowired
	private IIngresoDao iIngresoDao;
	
	@Autowired
	private FuncionesUtilesService funcionesUtiles;	
	
	@Override
	public Ingreso create(Ingreso entidad) {
		
		Integer IdMax = iIngresoDao.maxId() == null ? 1 : iIngresoDao.maxId() + 1 ;
		entidad.setFechaRegistro(funcionesUtiles.getFechaActual().toString() + " " + funcionesUtiles.getHoraActual());
		entidad.setIdIngreso(IdMax);
		
		return iIngresoDao.save(entidad);
	}

	@Override
	public List<Ingreso> readAll() {
		// TODO Auto-generated method stub
		return (List<Ingreso>) iIngresoDao.findAll();
	}
	
	@Override
	public Ingreso update(Ingreso entidad) {
		// TODO Auto-generated method stub
		return iIngresoDao.save(entidad);
	}

	@Override
	public Ingreso findById(Integer id) {
		// TODO Auto-generated method stub
		return iIngresoDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		iIngresoDao.deleteById(id);
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
	public Boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ingreso> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ingreso> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
		
		// Filter f = convertObjectToFormatJson.ConvertObjectToFormatSpecification(filter);
		
		return selectFrom(iIngresoDao).where(filter).findPage(pageable);		
	}
	

}
