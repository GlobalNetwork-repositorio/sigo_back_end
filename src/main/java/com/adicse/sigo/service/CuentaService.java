package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Cuenta;
import com.adicse.sigo.repo.ICuentaDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class CuentaService implements IAdicseCustom<Cuenta, Integer> {

	@Autowired
	private ICuentaDao iCuentaDao;

	@Override
	public Cuenta create(Cuenta entidad) {		
		if ( entidad.getIdCuenta() == 0 ) { 
			Integer IdMax = iCuentaDao.maxId() == null ? 1 : iCuentaDao.maxId() + 1 ; 
			entidad.setIdCuenta(IdMax);
		}
		
		iCuentaDao.save(entidad);
		return entidad;
	}

	@Override
	public List<Cuenta> readAll() {
		// TODO Auto-generated method stub		
		return (List<Cuenta>) iCuentaDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
	    return new Sort(Sort.Direction.ASC, "idCuenta");
	}

	@Override
	public Cuenta update(Cuenta entidad) {
		// TODO Auto-generated method stub
		return iCuentaDao.save(entidad);
	}

	@Override
	public Cuenta findById(Integer id) {
		// TODO Auto-generated method stub
		return iCuentaDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iCuentaDao.deleteById(id);
		
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
	public Optional<Cuenta> findbyid(Integer id) {
		return iCuentaDao.findById(id);
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
