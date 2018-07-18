package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Concepto;
import com.adicse.sigo.repo.IConceptoDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class ConceptoService implements IAdicseCustom<Concepto, Integer> {

	@Autowired
	private IConceptoDao iConceptoDao;

	@Override
	public Concepto create(Concepto entidad) {
		if ( entidad.getIdConcepto() == 0 ) { 
			Integer IdMax = iConceptoDao.maxId() == null ? 1 : iConceptoDao.maxId() + 1 ; 
			entidad.setIdConcepto(IdMax);
		}
		
		iConceptoDao.save(entidad);
		return entidad;
	}
	
	@Override
	public List<Concepto> readAll() {		
		return (List<Concepto>) iConceptoDao.findAll(sortByIdAsc());
	}	
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idConcepto");
    }
	
	@Override
	public Concepto update(Concepto entidad) {
		return iConceptoDao.save(entidad);
	}

	@Override
	public Concepto findById(Integer id) {
		return iConceptoDao.findById(id).get();
	}
	
	public List<Concepto> findByTipoRubro(Integer tipo){
		return iConceptoDao.getFindByTipoRubro(tipo);
	}

	@Override
	public void deleteById(Integer id) {
		iConceptoDao.deleteById(id);		
	}
	
	@Override
	public Optional<Concepto> findbyid(Integer id) {
		return iConceptoDao.findById(id);
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
