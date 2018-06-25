package com.adicse.sigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface IAdicseCustom <T, ID>{
	
	public Page<?> pagination(Integer pagenumber, Integer rows, String sortdireccion, String  sortcolumn, Object filter );
	
	public Page<?> paginationParmsExtra(Integer pagenumber, Integer rows, String sortdireccion, String  sortcolumn, Object filter, Object paramsExtra );
		
	public List<T> readAll();
	
	public T create(T entidad);
	
	
	
	public T update(T entidad);
	
	public T findById(ID id);
	
	public void deleteById(ID id);
	
	public Boolean exists(ID id);
	
	public Optional<T> findbyid(ID id);
	
	public Long count();

}
