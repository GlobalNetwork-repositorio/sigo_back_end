package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.MedioPago;
import com.adicse.sigo.repo.IMedioPagoDao;

@Service
@Transactional
public class MedioPagoService implements IAdicseCustom<MedioPago, Integer>{

	@Autowired
	private IMedioPagoDao iMedioPagoDao;
	
	@Override
	public MedioPago create(MedioPago entidad) {
		
		Integer IdMax = iMedioPagoDao.maxId() == null ? 1 : iMedioPagoDao.maxId() + 1 ;
		entidad.setIdMedioPago(IdMax);
		
		return iMedioPagoDao.save(entidad);
	}

	@Override
	public List<MedioPago> readAll() {
		// TODO Auto-generated method stub
		return (List<MedioPago>) iMedioPagoDao.findAll();
	}

	@Override
	public MedioPago update(MedioPago entidad) {
		// TODO Auto-generated method stub
		return iMedioPagoDao.save(entidad);
	}

	@Override
	public MedioPago findById(Integer id) {
		// TODO Auto-generated method stub
		return iMedioPagoDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iMedioPagoDao.deleteById(id);
		
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
	public Optional<MedioPago> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
