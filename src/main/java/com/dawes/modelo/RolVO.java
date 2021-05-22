package com.dawes.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	
	@Column(nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
	private List<UsuarioVO> usuarios;

	public RolVO() {
		super();
	}

	public RolVO(List<UsuarioVO> usuarios, String nombre) {
		super();
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public RolVO(int idrol, List<UsuarioVO> usuarios, String nombre) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}
}