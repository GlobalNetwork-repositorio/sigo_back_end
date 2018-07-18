package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.ConceptoRegistro;
import com.adicse.sigo.repo.IConceptoRegistroDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class ConceptoRegistroService implements IAdicseCustom<ConceptoRegistro, Integer> {
	
	@Autowired
	private IConceptoRegistroDao iConceptoRegistroDao;

	@Override
	public ConceptoRegistro create(ConceptoRegistro entidad) {
		if ( entidad.getIdConceptoRegistro() == 0 ) { 
			Integer IdMax = iConceptoRegistroDao.maxId() == null ? 1 : iConceptoRegistroDao.maxId() + 1 ; 
			entidad.setIdConceptoRegistro(IdMax);
		}
		
		iConceptoRegistroDao.save(entidad);
		return entidad;
	}
	
	@Override
	public List<ConceptoRegistro> readAll() {		
		return (List<ConceptoRegistro>) iConceptoRegistroDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idConceptoRegistro");
    }
	
	@Override
	public ConceptoRegistro update(ConceptoRegistro entidad) {
		return iConceptoRegistroDao.save(entidad);
	}

	@Override
	public ConceptoRegistro findById(Integer id) {
		return iConceptoRegistroDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iConceptoRegistroDao.deleteById(id);		
	}
	
	@Override
	public Optional<ConceptoRegistro> findbyid(Integer id) {
		return iConceptoRegistroDao.findById(id);
	}
	
	
	public List<ConceptoRegistro> findByIdConcepto(Integer idConcepto) {
		return (List<ConceptoRegistro>) iConceptoRegistroDao.getByIdConcepto(idConcepto);
	}

	@Override
	public Page<?> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		// TODO Auto-generated method stub
		return null;
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
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
