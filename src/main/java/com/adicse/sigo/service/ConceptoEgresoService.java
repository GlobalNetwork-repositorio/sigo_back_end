package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.ConceptoEgreso;
import com.adicse.sigo.repo.IConceptoEgresoDao;

@Service
@Transactional
public class ConceptoEgresoService implements IAdicseCustom<ConceptoEgreso, Integer> {

	@Autowired
	private IConceptoEgresoDao iConceptoEgresoDao;
	
	@Override
	public ConceptoEgreso create(ConceptoEgreso entidad) {
		// TODO Auto-generated method stub
		return iConceptoEgresoDao.save(entidad);
	}

	@Override
	public List<ConceptoEgreso> readAll() {
		// TODO Auto-generated method stub
		return (List<ConceptoEgreso>) iConceptoEgresoDao.findAll();
	}

	@Override
	public ConceptoEgreso update(ConceptoEgreso entidad) {
		// TODO Auto-generated method stub
		return iConceptoEgresoDao.save(entidad);
	}

	@Override
	public ConceptoEgreso findById(Integer id) {
		// TODO Auto-generated method stub
		return iConceptoEgresoDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iConceptoEgresoDao.deleteById(id);
		
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
	public Optional<ConceptoEgreso> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
