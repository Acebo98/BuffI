package com.dawes.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
public class UsuarioVO implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	
	@Column(unique = true, nullable = false, length = 30)
	private String username;

	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	
	private LocalDate fcreacion;
	
	@Column(nullable = true)
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
		this.username = nombre;
		this.password = contrasena;
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
		this.username = nombre;
		this.password = contrasena;
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
		return username;
	}

	public void setNombre(String nombre) {
		this.username = nombre;
	}

	public String getContrasena() {
		return password;
	}

	public void setContrasena(String contrasena) {
		this.password = contrasena;
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

	/*
	 * MÉTODOS PARA LOS ROLES
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> privilegios = new ArrayList<>();
		privilegios.add(new SimpleGrantedAuthority(rol.getNombre()));
		return privilegios;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return this.password;	
	}

	@Override
	public String getUsername() {
		return this.username;
	}
}