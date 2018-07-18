package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proveedor_detalle database table.
 * 
 */
@Entity
@Table(name="proveedor_detalle")
@NamedQuery(name="ProveedorDetalle.findAll", query="SELECT p FROM ProveedorDetalle p")
public class ProveedorDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proveedor_detalle")
	private Integer idProveedorDetalle;

	private String contacto;

	private String direccion;

	private String telefono;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;

	public ProveedorDetalle() {
	}

	public Integer getIdProveedorDetalle() {
		return this.idProveedorDetalle;
	}

	public void setIdProveedorDetalle(Integer idProveedorDetalle) {
		this.idProveedorDetalle = idProveedorDetalle;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}