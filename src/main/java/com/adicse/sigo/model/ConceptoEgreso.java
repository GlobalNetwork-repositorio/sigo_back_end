package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the concepto_egreso database table.
 * 
 */
@Entity
@Table(name="concepto_egreso")
@NamedQuery(name="ConceptoEgreso.findAll", query="SELECT c FROM ConceptoEgreso c")
public class ConceptoEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_concepto_egreso")
	private Integer idConceptoEgreso;

	private String descripcion;

	public ConceptoEgreso() {
	}

	public Integer getIdConceptoEgreso() {
		return this.idConceptoEgreso;
	}

	public void setIdConceptoEgreso(Integer idConceptoEgreso) {
		this.idConceptoEgreso = idConceptoEgreso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}