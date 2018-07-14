package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Usuario;
import com.adicse.sigo.repo.IUsuarioDao;
import com.adicse.sigo.specification.Filter;

@Service
@Transactional
public class UsuarioService implements IAdicseCustom<Usuario, Integer>{

	@Autowired
	private IUsuarioDao iUsuarioDao;
	
	@Override
	public Usuario create(Usuario entidad) {
		if ( entidad.getIdUsuario() == 0 ) { 
			Integer IdMax = iUsuarioDao.maxId() == null ? 1 : iUsuarioDao.maxId() + 1 ; 
			entidad.setIdUsuario(IdMax);
		}
		
		iUsuarioDao.save(entidad);
		return entidad;
	}
	

	@Override
	public List<Usuario> readAll() {		
		return (List<Usuario>) iUsuarioDao.findAll(sortByIdAsc());
	}
	
	// orden por defecto
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "idUsuario");
    }

	@Override
	public Usuario update(Usuario entidad) {
		return iUsuarioDao.save(entidad);
	}

	@Override
	public Usuario findById(Integer id) {
		return iUsuarioDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		iUsuarioDao.deleteById(id);		
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
	public Optional<Usuario> findbyid(Integer id) {
		return iUsuarioDao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getUsuarioByCredenciales ( String username, String password ) {
		return iUsuarioDao.getUsuarioByCredenciales(username, password);
	}

	@Override
	public Page<?> paginacion(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
