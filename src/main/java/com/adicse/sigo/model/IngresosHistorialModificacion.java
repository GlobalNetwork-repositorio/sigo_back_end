package com.adicse.sigo.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingresos_historial_modificacion database table.
 * 
 */
@Entity
@Table(name="ingresos_historial_modificacion")
@NamedQuery(name="IngresosHistorialModificacion.findAll", query="SELECT i FROM IngresosHistorialModificacion i")
public class IngresosHistorialModificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ingresos_historial_modificacion")
	private Integer idIngresosHistorialModificacion;

	@Column(name="fecha_hora")
	private String fechaHora;

	private String modificacion;

	//bi-directional many-to-one association to Ingreso
	@ManyToOne
	@JoinColumn(name="id_ingreso")
	private Ingreso ingreso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public IngresosHistorialModificacion() {
	}

	public Integer getIdIngresosHistorialModificacion() {
		return this.idIngresosHistorialModificacion;
	}

	public void setIdIngresosHistorialModificacion(Integer idIngresosHistorialModificacion) {
		this.idIngresosHistorialModificacion = idIngresosHistorialModificacion;
	}

	public String getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getModificacion() {
		return this.modificacion;
	}

	public void setModificacion(String modificacion) {
		this.modificacion = modificacion;
	}

	public Ingreso getIngreso() {
		return this.ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}