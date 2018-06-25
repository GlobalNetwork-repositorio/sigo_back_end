package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medio_pago database table.
 * 
 */
@Entity
@Table(name="medio_pago")
@NamedQuery(name="MedioPago.findAll", query="SELECT m FROM MedioPago m")
public class MedioPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_medio_pago")
	private Integer idMedioPago;

	@Column(name="descripcion_medio_pago")
	private String descripcionMedioPago;

	//bi-directional many-to-one association to Egreso
	@OneToMany(mappedBy="medioPago")
	private List<Egreso> egresos;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="medioPago")
	private List<Ingreso> ingresos;

	public MedioPago() {
	}

	public Integer getIdMedioPago() {
		return this.idMedioPago;
	}

	public void setIdMedioPago(Integer idMedioPago) {
		this.idMedioPago = idMedioPago;
	}

	public String getDescripcionMedioPago() {
		return this.descripcionMedioPago;
	}

	public void setDescripcionMedioPago(String descripcionMedioPago) {
		this.descripcionMedioPago = descripcionMedioPago;
	}

	public List<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public Egreso addEgreso(Egreso egreso) {
		getEgresos().add(egreso);
		egreso.setMedioPago(this);

		return egreso;
	}

	public Egreso removeEgreso(Egreso egreso) {
		getEgresos().remove(egreso);
		egreso.setMedioPago(null);

		return egreso;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setMedioPago(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setMedioPago(null);

		return ingreso;
	}

}