package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Proveedor;
import com.adicse.sigo.repo.IProveedorDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class ProveedorService implements IAdicseCustom<Proveedor, Integer> {
	
	@Autowired
	private IProveedorDao iProveedorDao;
	
	@Override
	public Proveedor create(Proveedor entidad) {		
		if ( entidad.getIdProveedor() == 0 ) { 
			Integer IdMax = iProveedorDao.maxId() == null ? 1 : iProveedorDao.maxId() + 1 ; 
			entidad.setIdProveedor(IdMax);
		}
		
		iProveedorDao.save(entidad);
		return entidad;
	}
	
	@Override
	public List<Proveedor> readAll() {
		// TODO Auto-generated method stub		
		return (List<Proveedor>) iProveedorDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
	    return new Sort(Sort.Direction.ASC, "idProveedor");
	}
	
	@Override
	public Proveedor update(Proveedor entidad) {	
		return iProveedorDao.save(entidad);
	}

	@Override
	public Proveedor findById(Integer id) {
		// TODO Auto-generated method stub
		return iProveedorDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iProveedorDao.deleteById(id);		
	}

	@Override
	public Page<Proveedor> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		
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
		return iProveedorDao.existsById(id);
	}

	@Override
	public Optional<Proveedor> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return iProveedorDao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return iProveedorDao.count();
	}

	@Override
	public Page<?> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
