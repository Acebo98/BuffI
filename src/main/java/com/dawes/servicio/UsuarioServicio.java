package com.dawes.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.UsuarioVO;

public interface UsuarioServicio {

	<S extends UsuarioVO> S save(S entity);

	<S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioVO> findAll();

	Iterable<UsuarioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioVO entity);

	void deleteAll(Iterable<? extends UsuarioVO> entities);

	void deleteAll();
	
	Iterable<UsuarioVO> findByFcreacionBetween(LocalDate f1, LocalDate f2);
	
	Iterable<UsuarioVO> findByFnacimientoBetween(LocalDate f1, LocalDate f2);
	
	Optional<UsuarioVO> findByNombre(String nombre);
}