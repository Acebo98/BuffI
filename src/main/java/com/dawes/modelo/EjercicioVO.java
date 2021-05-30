package com.dawes.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ejercicios")
public class EjercicioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idejercicio;
	
	@Column(unique = true, nullable = false, length = 200)
	private String nombre;
	
	//Ruta
	@Column(nullable = true)
	private String imagen;
	
	@OneToMany(mappedBy = "ejercicio", fetch = FetchType.EAGER)
	private List<RutinaEjercicioVO> rutinas;

	public EjercicioVO() {
		super();
	}

	public EjercicioVO(String nombre, List<RutinaEjercicioVO> rutinas, String imagen) {
		super();
		this.nombre = nombre;
		this.rutinas = rutinas;
		this.imagen = imagen;
	}

	public EjercicioVO(int idejercicio, String nombre, List<RutinaEjercicioVO> rutinas, String imagen) {
		super();
		this.idejercicio = idejercicio;
		this.nombre = nombre;
		this.rutinas = rutinas;
		this.imagen = imagen;
	}

	public int getIdejercicio() {
		return idejercicio;
	}

	public void setIdejercicio(int idejercicio) {
		this.idejercicio = idejercicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RutinaEjercicioVO> getRutinas() {
		return rutinas;
	}

	public void setRutinas(List<RutinaEjercicioVO> rutinas) {
		this.rutinas = rutinas;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}