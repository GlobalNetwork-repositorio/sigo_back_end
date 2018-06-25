package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.ConceptoIngreso;
import com.adicse.sigo.repo.IConceptoIngresoDao;

@Service
@Transactional
public class ConceptoIngresoService implements IAdicseCustom<ConceptoIngreso, Integer> {

	@Autowired
	private IConceptoIngresoDao iConceptoIngresoDao;
	
	@Override
	public ConceptoIngreso create(ConceptoIngreso entidad) {
		// TODO Auto-generated method stub
		return iConceptoIngresoDao.save(entidad);
	}

	@Override
	public List<ConceptoIngreso> readAll() {
		// TODO Auto-generated method stub
		return (List<ConceptoIngreso>) iConceptoIngresoDao.findAll();
	}

	@Override
	public ConceptoIngreso update(ConceptoIngreso entidad) {
		// TODO Auto-generated method stub
		return iConceptoIngresoDao.save(entidad);
	}

	@Override
	public ConceptoIngreso findById(Integer id) {
		// TODO Auto-generated method stub
		return iConceptoIngresoDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		 iConceptoIngresoDao.deleteById(id);
		
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
	public Optional<ConceptoIngreso> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
