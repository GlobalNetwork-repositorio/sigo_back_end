package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Egreso
	@OneToMany(mappedBy="conceptoEgreso")
	private List<Egreso> egresos;

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

	public List<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public Egreso addEgreso(Egreso egreso) {
		getEgresos().add(egreso);
		egreso.setConceptoEgreso(this);

		return egreso;
	}

	public Egreso removeEgreso(Egreso egreso) {
		getEgresos().remove(egreso);
		egreso.setConceptoEgreso(null);

		return egreso;
	}

}