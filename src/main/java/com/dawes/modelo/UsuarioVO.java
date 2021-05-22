package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	
	@Column(unique = true, nullable = false, length = 30)
	private String nombre;

	@Column(nullable = false, length = 30)
	private String contrasena;
	
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	
	private LocalDate fcreacion;
	private LocalDate fnacimiento;
	
	@Column(nullable = true, length = 50)
	private String localidad;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<RutinaVO> rutinas;
	
	@ManyToOne
	@JoinColumn(name = "idrol")
	private RolVO rol;

	public UsuarioVO() {
		super();
	}

	public UsuarioVO(String nombre, String contrasena, String email, LocalDate fcreacion, LocalDate fnacimiento,
			String localidad, List<RutinaVO> rutinas, RolVO rol) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.fcreacion = fcreacion;
		this.fnacimiento = fnacimiento;
		this.localidad = localidad;
		this.rutinas = rutinas;
		this.rol = rol;
	}

	public UsuarioVO(int idusuario, String nombre, String contrasena, String email, LocalDate fcreacion,
			LocalDate fnacimiento, String localidad, List<RutinaVO> rutinas, RolVO rol) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.fcreacion = fcreacion;
		this.fnacimiento = fnacimiento;
		this.localidad = localidad;
		this.rutinas = rutinas;
		this.rol = rol;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFcreacion() {
		return fcreacion;
	}

	public void setFcreacion(LocalDate fcreacion) {
		this.fcreacion = fcreacion;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<RutinaVO> getRutinas() {
		return rutinas;
	}

	public void setRutinas(List<RutinaVO> rutinas) {
		this.rutinas = rutinas;
	}

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}
}