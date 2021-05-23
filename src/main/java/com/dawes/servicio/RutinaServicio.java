package com.dawes.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;

public interface RutinaServicio {

	<S extends RutinaVO> S save(S entity);

	<S extends RutinaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<RutinaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<RutinaVO> findAll();

	Iterable<RutinaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(RutinaVO entity);

	void deleteAll(Iterable<? extends RutinaVO> entities);

	void deleteAll();
	
	Iterable<RutinaVO> findByFcreacionBetween(LocalDate f1, LocalDate f2);
	
	Optional<RutinaVO> findByNombre(String nombre);
	
	Iterable<RutinaVO> findByNombres(String nombre);
	
	Iterable<RutinaVO> findAllByOrderByFcreacionAsc();		//Ascendiente
	
	Iterable<RutinaVO> findAllByOrderByFcreacionDesc();		//Descendiente	
}