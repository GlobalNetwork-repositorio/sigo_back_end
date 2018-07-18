package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;

//import model.OneToMany;

import java.util.List;


/**
 * The persistent class for the concepto database table.
 * 
 */
@Entity
@NamedQuery(name="Concepto.findAll", query="SELECT c FROM Concepto c")
public class Concepto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_concepto")
	private Integer idConcepto;

	private String descripcion;

	//bi-directional many-to-one association to Rubro
	@ManyToOne
	@JoinColumn(name="id_rubro")
	private Rubro rubro;
	

	//bi-directional many-to-one association to ConceptoRegistro		
	//@OneToMany(mappedBy="concepto" , cascade = CascadeType.ALL)
	@OneToMany(mappedBy="concepto")
	private List<ConceptoRegistro> conceptoRegistros;

	public Concepto() {
	}

	public Integer getIdConcepto() {
		return this.idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Rubro getRubro() {
		return this.rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public List<ConceptoRegistro> getConceptoRegistros() {
		return this.conceptoRegistros;
	}

	public void setConceptoRegistros(List<ConceptoRegistro> conceptoRegistros) {
		this.conceptoRegistros = conceptoRegistros;
	}

	public ConceptoRegistro addConceptoRegistro(ConceptoRegistro conceptoRegistro) {
		getConceptoRegistros().add(conceptoRegistro);
		conceptoRegistro.setConcepto(this);

		return conceptoRegistro;
	}

	public ConceptoRegistro removeConceptoRegistro(ConceptoRegistro conceptoRegistro) {
		getConceptoRegistros().remove(conceptoRegistro);
		conceptoRegistro.setConcepto(null);

		return conceptoRegistro;
	}

}