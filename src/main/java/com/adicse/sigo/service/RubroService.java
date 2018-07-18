package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Rubro;
import com.adicse.sigo.repo.IRubroDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class RubroService implements IAdicseCustom<Rubro, Integer> {

	@Autowired
	private IRubroDao iRubroDao;

	@Override
	public Rubro create(Rubro entidad) {		
		iRubroDao.save(entidad);
		return entidad;
	}
	
	@Override
	public List<Rubro> readAll() {		
		return (List<Rubro>) iRubroDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idRubro");
    }
	
	@Override
	public Rubro update(Rubro entidad) {
		return iRubroDao.save(entidad);
	}
	
	public List<Rubro> findByTipo(Integer tipo){
		return iRubroDao.getFindByTipo(tipo);
	}

	@Override
	public Rubro findById(Integer id) {
		return iRubroDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iRubroDao.deleteById(id);		
	}
	
	@Override
	public Optional<Rubro> findbyid(Integer id) {
		return iRubroDao.findById(id);
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
