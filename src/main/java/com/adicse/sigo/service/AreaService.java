package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Area;
import com.adicse.sigo.repo.IAreaDao;

@Service
@Transactional
public class AreaService implements IAdicseCustom<Area, Integer> {
	
	@Autowired
	private IAreaDao iAreaDao;

	@Override
	public Area create(Area entidad) {
		Integer IdMax = iAreaDao.maxId() == null ? 1 : iAreaDao.maxId() + 1 ;
		entidad.setIdArea(IdMax);
		return iAreaDao.save(entidad);
	}

	@Override
	public List<Area> readAll() {
		
		return (List<Area>) iAreaDao.findAll();
	}

	@Override
	public Area update(Area entidad) {
	
		return iAreaDao.save(entidad);
	}

	@Override
	public Area findById(Integer id) {
		return iAreaDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iAreaDao.deleteById(id);
		
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
	public Optional<Area> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
