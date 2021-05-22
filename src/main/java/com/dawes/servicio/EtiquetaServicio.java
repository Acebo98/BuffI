package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.EtiquetaVO;

public interface EtiquetaServicio {

	<S extends EtiquetaVO> S save(S entity);

	<S extends EtiquetaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<EtiquetaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<EtiquetaVO> findAll();

	Iterable<EtiquetaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(EtiquetaVO entity);

	void deleteAll(Iterable<? extends EtiquetaVO> entities);

	void deleteAll();

	Optional<EtiquetaVO> findByNombre(String nombre);
}