package com.adicse.sigo.especificaciones;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.adicse.sigo.model.Egreso;


public class egresoEspecificacion implements Specification<Egreso> {

	private static final long serialVersionUID = 1L;
	private final Egreso filter;

	public egresoEspecificacion(Egreso filter) {
		this.filter = filter;
	}	

	@Override
	public Predicate toPredicate(Root<Egreso> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		Predicate p = cb.conjunction();
		
		if( filter.getIdEgreso() != null ){
			p.getExpressions().add(cb.equal(root.get("idEgreso") , filter.getIdEgreso() ));
		}
		
		if (StringUtils.isNotBlank(filter.getDetalles() )) {
			p.getExpressions().add(cb.like(cb.lower(root.get("detalles")),"%"+ filter.getDetalles().toLowerCase() + "%"));
		}
	

		return p;		
		
	}

	
}
