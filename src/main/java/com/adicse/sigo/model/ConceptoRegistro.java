package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the concepto_registro database table.
 * 
 */
@Entity
@Table(name="concepto_registro")
@NamedQuery(name="ConceptoRegistro.findAll", query="SELECT c FROM ConceptoRegistro c")
public class ConceptoRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_concepto_registro")
	private Integer idConceptoRegistro;

	private String descripcion;

	//bi-directional many-to-one association to Concepto
	@ManyToOne
	@JoinColumn(name="id_concepto")
	private Concepto concepto;

	//bi-directional many-to-one association to Egreso
	@OneToMany(mappedBy="conceptoRegistro")
	private List<Egreso> egresos;

	public ConceptoRegistro() {
	}

	public Integer getIdConceptoRegistro() {
		return this.idConceptoRegistro;
	}

	public void setIdConceptoRegistro(Integer idConceptoRegistro) {
		this.idConceptoRegistro = idConceptoRegistro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Concepto getConcepto() {
		return this.concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public List<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public Egreso addEgreso(Egreso egreso) {
		getEgresos().add(egreso);
		egreso.setConceptoRegistro(this);

		return egreso;
	}

	public Egreso removeEgreso(Egreso egreso) {
		getEgresos().remove(egreso);
		egreso.setConceptoRegistro(null);

		return egreso;
	}

}