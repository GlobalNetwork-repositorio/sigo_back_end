package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Proveedor;
import com.adicse.sigo.repo.IProveedorDao;

@Service
@Transactional
public class ProveedorService implements IAdicseCustom<Proveedor, Integer> {
	
	@Autowired
	private IProveedorDao iProveedorDao;

	@Override
	public Page<?> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
		
		Page<Proveedor> lista = iProveedorDao.findAll(pageable);
 
		return lista;

		
		
	}

	@Override
	public Page<?> paginationParmsExtra(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter, Object paramsExtra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> readAll() {
		// TODO Auto-generated method stub
		System.out.println("aqui");
		List lst = (List) iProveedorDao.findAll();
		return lst;
	}

	@Override
	public Proveedor create(Proveedor entidad) {
		// TODO Auto-generated method stub
		return iProveedorDao.save(entidad);
	}

	@Override
	public Proveedor update(Proveedor entidad) {
		// TODO Auto-generated method stub
		Integer id = entidad.getIdProveedor();
		
		Proveedor tmp = iProveedorDao.findById(id).get() ;
		
		BeanUtils.copyProperties(entidad, tmp);
		
		tmp = iProveedorDao.save(tmp);
		
		return tmp;
	}

	@Override
	public Proveedor findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		iProveedorDao.deleteById(id);
		
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

}
