package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.EjercicioVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.RutinaVO;

public interface EjercicioServicio {

	<S extends EjercicioVO> S save(S entity);

	<S extends EjercicioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<EjercicioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<EjercicioVO> findAll();

	Iterable<EjercicioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(EjercicioVO entity);

	void deleteAll(Iterable<? extends EjercicioVO> entities);

	void deleteAll();
	
	Optional<EjercicioVO> findByNombre(String nombre);
}