package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;

public interface ComentarioServicio {

	<S extends ComentarioVO> S save(S entity);

	<S extends ComentarioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ComentarioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ComentarioVO> findAll();

	Iterable<ComentarioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ComentarioVO entity);

	void deleteAll(Iterable<? extends ComentarioVO> entities);

	void deleteAll();

	Iterable<ComentarioVO> findByRutina(RutinaVO rutina);
	
	Iterable<ComentarioVO> findByUsuario(UsuarioVO usuario);
	
	Iterable<ComentarioVO> findAllByOrderByFcreacionDesc();	
	
	long deleteByRutina(RutinaVO rutina);
	
	long deleteByUsuario(UsuarioVO usuario);
}