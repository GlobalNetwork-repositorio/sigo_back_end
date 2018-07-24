package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the concepto_ingreso database table.
 * 
 */
@Entity
@Table(name="concepto_ingreso")
@NamedQuery(name="ConceptoIngreso.findAll", query="SELECT c FROM ConceptoIngreso c")
public class ConceptoIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_concepto_ingreso")
	private Integer idConceptoIngreso;

	private String descripcion;

	public ConceptoIngreso() {
	}

	public Integer getIdConceptoIngreso() {
		return this.idConceptoIngreso;
	}

	public void setIdConceptoIngreso(Integer idConceptoIngreso) {
		this.idConceptoIngreso = idConceptoIngreso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}