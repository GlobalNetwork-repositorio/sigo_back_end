package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proveedor")
	private Integer idProveedor;

	private String correo;

	private String direccion;

	@Column(name="razon_social")
	private String razonSocial;

	@Column(name="rubro_servicio")
	private String rubroServicio;

	private String ruc;

	private String telefono;

	//bi-directional many-to-one association to Egreso
	@OneToMany(mappedBy="proveedor")
	private List<Egreso> egresos;

	public Proveedor() {
	}

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRubroServicio() {
		return this.rubroServicio;
	}

	public void setRubroServicio(String rubroServicio) {
		this.rubroServicio = rubroServicio;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public Egreso addEgreso(Egreso egreso) {
		getEgresos().add(egreso);
		egreso.setProveedor(this);

		return egreso;
	}

	public Egreso removeEgreso(Egreso egreso) {
		getEgresos().remove(egreso);
		egreso.setProveedor(null);

		return egreso;
	}

}