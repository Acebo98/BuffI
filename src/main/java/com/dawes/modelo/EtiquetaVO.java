package com.dawes.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etiquetas")
public class EtiquetaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idetiqueta;
	
	@Column(unique = true, nullable = false, length = 30)
	private String nombre;
	
	@OneToMany(mappedBy = "etiqueta", fetch = FetchType.EAGER)
	private List<RutinaVO> rutinas;

	public EtiquetaVO() {
		super();
	}

	public EtiquetaVO(String nombre, List<RutinaVO> rutinas) {
		super();
		this.nombre = nombre;
		this.rutinas = rutinas;
	}

	public EtiquetaVO(int idetiqueta, String nombre, List<RutinaVO> rutinas) {
		super();
		this.idetiqueta = idetiqueta;
		this.nombre = nombre;
		this.rutinas = rutinas;
	}

	public int getIdetiqueta() {
		return idetiqueta;
	}

	public void setIdetiqueta(int idetiqueta) {
		this.idetiqueta = idetiqueta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RutinaVO> getRutinas() {
		return rutinas;
	}

	public void setRutinas(List<RutinaVO> rutinas) {
		this.rutinas = rutinas;
	}
}