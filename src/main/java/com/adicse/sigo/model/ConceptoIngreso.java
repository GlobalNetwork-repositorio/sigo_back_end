package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="conceptoIngreso")
	private List<Ingreso> ingresos;

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

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setConceptoIngreso(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setConceptoIngreso(null);

		return ingreso;
	}

}