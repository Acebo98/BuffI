package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.RutinaEjercicioVO;
import com.dawes.modelo.RutinaVO;

public interface RutinaEjercicioServicio {

	<S extends RutinaEjercicioVO> S save(S entity);

	<S extends RutinaEjercicioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<RutinaEjercicioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<RutinaEjercicioVO> findAll();

	Iterable<RutinaEjercicioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(RutinaEjercicioVO entity);

	void deleteAll(Iterable<? extends RutinaEjercicioVO> entities);

	void deleteAll();

	long deleteByRutina(RutinaVO rutina);
}