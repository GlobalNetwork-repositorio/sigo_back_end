package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Ingreso;
import com.adicse.sigo.repo.IIngresoDao;

@Service
@Transactional
public class IngresoService implements IAdicseCustom<Ingreso, Integer>{
	
	@Autowired
	private IIngresoDao iIngresoDao;

	@Override
	public Ingreso create(Ingreso entidad) {
		// TODO Auto-generated method stub
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
	

}
