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
@Table(name = "rutinas")
public class RutinaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrutina;
	
	@Column(nullable = false, length = 200)
	private String descripcion;
	
	private LocalDate fcreacion;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "idetiqueta")
	private EtiquetaVO etiqueta;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioVO usuario;
	
	@OneToMany(mappedBy = "rutina")
	private List<ComentarioVO> comentarios;
	
	@OneToMany(mappedBy = "rutina", fetch = FetchType.EAGER)
	private List<RutinaEjercicioVO> ejercicios;
	
	public RutinaVO() {
		super();
	}

	public RutinaVO(String descripcion, LocalDate fcreacion, String nombre, EtiquetaVO etiqueta, UsuarioVO usuario, 
			List<ComentarioVO> comentarios, List<RutinaEjercicioVO> ejercicios) {
		super();
		this.descripcion = descripcion;
		this.fcreacion = fcreacion;
		this.nombre = nombre;
		this.etiqueta = etiqueta;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.ejercicios = ejercicios;
	}

	public RutinaVO(int idrutina, String descripcion, LocalDate fcreacion, String nombre, EtiquetaVO etiqueta,
			UsuarioVO usuario, List<ComentarioVO> comentarios, List<RutinaEjercicioVO> ejercicios) {
		super();
		this.idrutina = idrutina;
		this.descripcion = descripcion;
		this.fcreacion = fcreacion;
		this.nombre = nombre;
		this.etiqueta = etiqueta;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.ejercicios = ejercicios;
	}

	public int getIdrutina() {
		return idrutina;
	}

	public void setIdrutina(int idrutina) {
		this.idrutina = idrutina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFcreacion() {
		return fcreacion;
	}

	public void setFcreacion(LocalDate fcreacion) {
		this.fcreacion = fcreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EtiquetaVO getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(EtiquetaVO etiqueta) {
		this.etiqueta = etiqueta;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public List<ComentarioVO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioVO> comentarios) {
		this.comentarios = comentarios;
	}

	public List<RutinaEjercicioVO> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<RutinaEjercicioVO> ejercicios) {
		this.ejercicios = ejercicios;
	}
}