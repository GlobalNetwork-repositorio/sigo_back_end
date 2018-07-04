package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Sucursal;
import com.adicse.sigo.repo.ISucursalDao;

@Service
@Transactional
public class SucursalService implements IAdicseCustom<Sucursal, Integer>{

	@Autowired
	private ISucursalDao iSucursalDao;
	
	@Override
	public Sucursal create(Sucursal entidad) {
		// TODO Auto-generated method stub
		Integer IdMax = iSucursalDao.maxId() == null ? 1 : iSucursalDao.maxId() + 1 ;
		entidad.setIdSucursal(IdMax);
		return iSucursalDao.save(entidad);
	}

	@Override
	public List<Sucursal> readAll() {
		// TODO Auto-generated method stub
		return (List<Sucursal>) iSucursalDao.findAll();
	}

	@Override
	public Sucursal update(Sucursal entidad) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
