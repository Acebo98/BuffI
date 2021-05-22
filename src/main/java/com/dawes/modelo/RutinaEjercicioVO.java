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
@Table(name = "rutinasejercicios")
public class RutinaEjercicioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrutinaejercicio;
	
	//Texto opcional donde se explica como hacer el ejercicio. Por ejemplo las repeticiones.
	@Column(length = 200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idejercicio")
	private EjercicioVO ejercicio;
	
	@ManyToOne
	@JoinColumn(name = "idrutina")
	private RutinaVO rutina;

	public RutinaEjercicioVO() {
		super();
	}

	public RutinaEjercicioVO(EjercicioVO ejercicio, RutinaVO rutina, String descripcion) {
		super();
		this.ejercicio = ejercicio;
		this.rutina = rutina;
		this.descripcion = descripcion;
	}

	public RutinaEjercicioVO(int idrutinaejercicio, EjercicioVO ejercicio, RutinaVO rutina, String descripcion) {
		super();
		this.idrutinaejercicio = idrutinaejercicio;
		this.ejercicio = ejercicio;
		this.rutina = rutina;
		this.descripcion = descripcion;
	}

	public int getIdrutinaejercicio() {
		return idrutinaejercicio;
	}

	public void setIdrutinaejercicio(int idrutinaejercicio) {
		this.idrutinaejercicio = idrutinaejercicio;
	}

	public EjercicioVO getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(EjercicioVO ejercicio) {
		this.ejercicio = ejercicio;
	}

	public RutinaVO getRutina() {
		return rutina;
	}

	public void setRutina(RutinaVO rutina) {
		this.rutina = rutina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}