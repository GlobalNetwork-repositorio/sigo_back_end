package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the egresos_historial_modificacion database table.
 * 
 */
@Entity
@Table(name="egresos_historial_modificacion")
@NamedQuery(name="EgresosHistorialModificacion.findAll", query="SELECT e FROM EgresosHistorialModificacion e")
public class EgresosHistorialModificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_egresos_historial_modificacion")
	private Integer idEgresosHistorialModificacion;

	@Column(name="fecha_hora")
	private String fechaHora;

	private String modificacion;

	//bi-directional many-to-one association to Egreso
	@ManyToOne
	@JoinColumn(name="id_egreso")
	private Egreso egreso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public EgresosHistorialModificacion() {
	}

	public Integer getIdEgresosHistorialModificacion() {
		return this.idEgresosHistorialModificacion;
	}

	public void setIdEgresosHistorialModificacion(Integer idEgresosHistorialModificacion) {
		this.idEgresosHistorialModificacion = idEgresosHistorialModificacion;
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

	public Egreso getEgreso() {
		return this.egreso;
	}

	public void setEgreso(Egreso egreso) {
		this.egreso = egreso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}