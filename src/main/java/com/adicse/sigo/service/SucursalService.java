package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.adicse.sigo.model.Sucursal;
import com.adicse.sigo.repo.ISucursalDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class SucursalService implements IAdicseCustom<Sucursal, Integer>{

	@Autowired
	private ISucursalDao iSucursalDao;
	
	@Override
	public Sucursal create(Sucursal entidad) {		
		if ( entidad.getIdSucursal() == 0 ) { 
			Integer IdMax = iSucursalDao.maxId() == null ? 1 : iSucursalDao.maxId() + 1 ; 
			entidad.setIdSucursal(IdMax);
		}
		
		iSucursalDao.save(entidad);
		return entidad;
	}

	@Override
	public List<Sucursal> readAll() {
		// TODO Auto-generated method stub		
		return (List<Sucursal>) iSucursalDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
	    return new Sort(Sort.Direction.ASC, "idSucursal");
	}
	
	@Override
	public Sucursal update(Sucursal entidad) {	
		return iSucursalDao.save(entidad);
	}

	@Override
	public Sucursal findById(Integer id) {
		// TODO Auto-generated method stub
		return iSucursalDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iSucursalDao.deleteById(id);
		
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
	public Optional<Sucursal> findbyid(Integer id) {
		return iSucursalDao.findById(id);		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<?> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
