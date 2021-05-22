package com.dawes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios")
public class ComentarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcomentario;
	
	@Column(nullable = false, length = 255)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idrutina")
	private RutinaVO rutina;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioVO usuario;

	public ComentarioVO() {
		super();
	}

	public ComentarioVO(String descripcion, RutinaVO rutina, UsuarioVO usuario) {
		super();
		this.descripcion = descripcion;
		this.rutina = rutina;
		this.usuario = usuario;
	}

	public ComentarioVO(int idcomentario, String descripcion, RutinaVO rutina, UsuarioVO usuario) {
		super();
		this.idcomentario = idcomentario;
		this.descripcion = descripcion;
		this.rutina = rutina;
		this.usuario = usuario;
	}

	public int getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RutinaVO getRutina() {
		return rutina;
	}

	public void setRutina(RutinaVO rutina) {
		this.rutina = rutina;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
}