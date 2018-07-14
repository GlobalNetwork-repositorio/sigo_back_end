package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Area;
import com.adicse.sigo.repo.IAreaDao;
import com.adicse.sigo.specification.Filter;
import static com.adicse.sigo.specification.SpecificationBuilder.selectFrom;

@Service
@Transactional
public class AreaService implements IAdicseCustom<Area, Integer> {
	
	@Autowired
	private IAreaDao iAreaDao;

	@Override
	public Area create(Area entidad) {
		if ( entidad.getIdArea() == 0 ) { 
			Integer IdMax = iAreaDao.maxId() == null ? 1 : iAreaDao.maxId() + 1 ; 
			entidad.setIdArea(IdMax);
		}
		
		iAreaDao.save(entidad);
		return entidad;
	}
	

	@Override
	public List<Area> readAll() {		
		return (List<Area>) iAreaDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idArea");
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
		return iAreaDao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Area> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
				
		return selectFrom(iAreaDao).where(filter).findPage(pageable);
		
	}

}
