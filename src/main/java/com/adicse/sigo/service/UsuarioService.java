package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.sigo.model.Usuario;
import com.adicse.sigo.repo.IUsuarioDao;

@Service
@Transactional
public class UsuarioService implements IAdicseCustom<Usuario, Integer>{

	@Autowired
	private IUsuarioDao iUsuarioDao;
	
	@Override
	public Usuario create(Usuario entidad) {
		// TODO Auto-generated method stub
		return iUsuarioDao.save(entidad);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) iUsuarioDao.findAll();
	}

	@Override
	public Usuario update(Usuario entidad) {
		// TODO Auto-generated method stub
		return iUsuarioDao.save(entidad);
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
