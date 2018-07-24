package com.adicse.sigo.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String contrasena;

	private String direccion;

	// @Temporal(TemporalType.DATE)	
	@Column(name="fecha_ingreso")
	@JsonFormat (pattern ="dd/MM/yyyy", timezone="EST")
	private Date fechaIngreso;

	// @Temporal(TemporalType.DATE)	
	@Column(name="fecha_nacimiento")
	@JsonFormat (pattern ="dd/MM/yyyy", timezone="EST")
	private Date fechaNacimiento;

	@Column(name="nombre_apellido")
	private String nombreApellido;

	private String sexo;

	private String telefono;

	private String usuario;

	//bi-directional many-to-one association to Egreso
	@OneToMany(mappedBy="usuario")
	private List<Egreso> egresos;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="usuario")
	private List<Ingreso> ingresos;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="id_area")
	private Area area;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaIngreso() {
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// return sdf.format(this.fechaIngreso);
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {		
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// return sdf.format(this.fechaNacimiento);
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreApellido() {
		return this.nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public Egreso addEgreso(Egreso egreso) {
		getEgresos().add(egreso);
		egreso.setUsuario(this);

		return egreso;
	}

	public Egreso removeEgreso(Egreso egreso) {
		getEgresos().remove(egreso);
		egreso.setUsuario(null);

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
		ingreso.setUsuario(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setUsuario(null);

		return ingreso;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}