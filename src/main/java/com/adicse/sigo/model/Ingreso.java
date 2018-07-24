package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ingresos database table.
 * 
 */
@Entity
@Table(name="ingresos")
@NamedQuery(name="Ingreso.findAll", query="SELECT i FROM Ingreso i")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ingreso")
	private Integer idIngreso;

	private String cerrado;

	private String detalles;

	// @Temporal(TemporalType.DATE)
	@JsonFormat (pattern ="dd/MM/yyyy", timezone="EST")
	private Date fecha;

	@Column(name="fecha_registro")
	private String fechaRegistro;

	private String hora;

	@Column(name="monto_ingresado")
	private float montoIngresado;

	//bi-directional many-to-one association to ConceptoRegistro
	@ManyToOne
	@JoinColumn(name="id_concepto_registro")
	private ConceptoRegistro conceptoRegistro;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

	//bi-directional many-to-one association to MedioPago
	@ManyToOne
	@JoinColumn(name="id_medio_pago")
	private MedioPago medioPago;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to IngresosHistorialModificacion
	@OneToMany(mappedBy="ingreso")
	private List<IngresosHistorialModificacion> ingresosHistorialModificacions;

	public Ingreso() {
	}

	public Integer getIdIngreso() {
		return this.idIngreso;
	}

	public void setIdIngreso(Integer idIngreso) {
		this.idIngreso = idIngreso;
	}

	public String getCerrado() {
		return this.cerrado;
	}

	public void setCerrado(String cerrado) {
		this.cerrado = cerrado;
	}

	public String getDetalles() {
		return this.detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public float getMontoIngresado() {
		return this.montoIngresado;
	}

	public void setMontoIngresado(float montoIngresado) {
		this.montoIngresado = montoIngresado;
	}

	public ConceptoRegistro getConceptoRegistro() {
		return this.conceptoRegistro;
	}

	public void setConceptoRegistro(ConceptoRegistro conceptoRegistro) {
		this.conceptoRegistro = conceptoRegistro;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public MedioPago getMedioPago() {
		return this.medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<IngresosHistorialModificacion> getIngresosHistorialModificacions() {
		return this.ingresosHistorialModificacions;
	}

	public void setIngresosHistorialModificacions(List<IngresosHistorialModificacion> ingresosHistorialModificacions) {
		this.ingresosHistorialModificacions = ingresosHistorialModificacions;
	}

	public IngresosHistorialModificacion addIngresosHistorialModificacion(IngresosHistorialModificacion ingresosHistorialModificacion) {
		getIngresosHistorialModificacions().add(ingresosHistorialModificacion);
		ingresosHistorialModificacion.setIngreso(this);

		return ingresosHistorialModificacion;
	}

	public IngresosHistorialModificacion removeIngresosHistorialModificacion(IngresosHistorialModificacion ingresosHistorialModificacion) {
		getIngresosHistorialModificacions().remove(ingresosHistorialModificacion);
		ingresosHistorialModificacion.setIngreso(null);

		return ingresosHistorialModificacion;
	}

}