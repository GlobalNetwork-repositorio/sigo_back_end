package com.adicse.sigo.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rubro database table.
 * 
 */
@Entity
@NamedQuery(name="Rubro.findAll", query="SELECT r FROM Rubro r")
public class Rubro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rubro")
	private String idRubro;

	private String descripcion;

	private Integer tipo;

	public Rubro() {
	}

	public String getIdRubro() {
		return this.idRubro;
	}

	public void setIdRubro(String idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}