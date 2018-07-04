package com.adicse.sigo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.adicse.sigo.model.Egreso;
import com.adicse.sigo.repo.IEgresoDao;
import com.adicse.sigo.utilitarios.FuncionesUtilesService;

@Service
@Transactional
public class EgresoService implements IAdicseCustom<Egreso, Integer> {
	
	@Autowired
	private IEgresoDao iEgresoDao;
	
	@Autowired
	private FuncionesUtilesService funcionesUtiles;	

	
	@Override
	public Egreso create(Egreso entidad) {
		Integer IdMax = iEgresoDao.maxId() == null ? 1 : iEgresoDao.maxId() + 1 ;
				
		entidad.setFechaRegistro(funcionesUtiles.getFechaActual().toString() + " " + funcionesUtiles.getHoraActual());
		entidad.setIdEgreso(IdMax);
		
		return iEgresoDao.save(entidad);
	}

	@Override
	public List<Egreso> readAll() {
		// TODO Auto-generated method stub
		return (List<Egreso>) iEgresoDao.findAll();
	}

	@Override
	public Egreso update(Egreso entidad) {
		// TODO Auto-generated method stub
		return iEgresoDao.save(entidad);
	}

	@Override
	public Egreso findById(Integer id) {
		// TODO Auto-generated method stub
		return iEgresoDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iEgresoDao.deleteById(id);	
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
	public Optional<Egreso> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
}