package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the egresos database table.
 * 
 */
@Entity
@Table(name="egresos")
@NamedQuery(name="Egreso.findAll", query="SELECT e FROM Egreso e")
public class Egreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_egreso")
	private Integer idEgreso;

	private String cerrado;

	private String detalles;

	// @Temporal(TemporalType.DATE)
	@JsonFormat (pattern ="dd/MM/yyyy", timezone="EST")
	private Date fecha;

	@Column(name="fecha_registro")
	private String fechaRegistro;

	private String hora;

	private String imagen;

	private float monto;

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

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to EgresosHistorialModificacion
	@OneToMany(mappedBy="egreso")
	private List<EgresosHistorialModificacion> egresosHistorialModificacions;

	public Egreso() {
	}

	public Integer getIdEgreso() {
		return this.idEgreso;
	}

	public void setIdEgreso(Integer idEgreso) {
		this.idEgreso = idEgreso;
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

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getMonto() {
		return this.monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
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

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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

	public List<EgresosHistorialModificacion> getEgresosHistorialModificacions() {
		return this.egresosHistorialModificacions;
	}

	public void setEgresosHistorialModificacions(List<EgresosHistorialModificacion> egresosHistorialModificacions) {
		this.egresosHistorialModificacions = egresosHistorialModificacions;
	}

	public EgresosHistorialModificacion addEgresosHistorialModificacion(EgresosHistorialModificacion egresosHistorialModificacion) {
		getEgresosHistorialModificacions().add(egresosHistorialModificacion);
		egresosHistorialModificacion.setEgreso(this);

		return egresosHistorialModificacion;
	}

	public EgresosHistorialModificacion removeEgresosHistorialModificacion(EgresosHistorialModificacion egresosHistorialModificacion) {
		getEgresosHistorialModificacions().remove(egresosHistorialModificacion);
		egresosHistorialModificacion.setEgreso(null);

		return egresosHistorialModificacion;
	}

}